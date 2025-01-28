package com.library.service;

import com.library.exception.LibraryException;
import com.library.model.User;
import com.library.model.Book;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{11}$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[а-яА-Яa-zA-Z\\s]{2,50}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,255}$");
    private final BookService bookService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, BookService bookService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bookService = bookService;
    }

    public User registerUser(User user) {
        try {
            validateUser(user);

            if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
                throw new LibraryException("Пользователь с таким номером телефона уже существует");
            }

            if (userRepository.existsByUserNameAndPhoneNumber(user.getUserName(), user.getPhoneNumber())) {
                throw new LibraryException("Пользователь с таким именем и номером телефона уже существует");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Ошибка при регистрации пользователя. Возможно, такой пользователь уже существует");
        }
    }

    private void validateUser(User user) {
        if (user.getUserName() == null || user.getUserName().trim().isEmpty()) {
            throw new LibraryException("Имя пользователя не может быть пустым");
        }
        if (user.getUserName().length() < 2) {
            throw new LibraryException("Имя пользователя должно содержать минимум 2 символа");
        }
        if (user.getUserName().length() > 50) {
            throw new LibraryException("Имя пользователя не может быть длиннее 50 символов");
        }
        if (!USERNAME_PATTERN.matcher(user.getUserName()).matches()) {
            throw new LibraryException("Имя пользователя может содержать только буквы и пробелы");
        }

        if (user.getPhoneNumber() == null || !PHONE_PATTERN.matcher(user.getPhoneNumber()).matches()) {
            throw new LibraryException("Неверный формат номера телефона. Должно быть 11 цифр");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new LibraryException("Пароль должен содержать минимум 6 символов");
        }
        if (user.getPassword().length() > 255) {
            throw new LibraryException("Пароль слишком длинный");
        }
        if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            throw new LibraryException("Пароль должен содержать хотя бы одну цифру, одну строчную и одну заглавную букву");
        }
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Невозможно удалить пользователя, так как у него есть книги");
        }
    }

    public User update(User user) {
        try {
            validateUserUpdate(user);

            Optional<User> existingUserWithPhone = userRepository.findByPhoneNumber(user.getPhoneNumber());
            if (existingUserWithPhone.isPresent() && !existingUserWithPhone.get().getUserId().equals(user.getUserId())) {
                throw new LibraryException("Пользователь с таким номером телефона уже существует");
            }

            if (userRepository.existsByUserNameAndPhoneNumber(user.getUserName(), user.getPhoneNumber()) &&
                !existingUserWithPhone.get().getUserId().equals(user.getUserId())) {
                throw new LibraryException("Пользователь с таким именем и номером телефона уже существует");
            }

            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                userRepository.findById(user.getUserId())
                        .ifPresent(existingUser -> user.setPassword(existingUser.getPassword()));
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Ошибка при обновлении пользователя. Возможно, такой пользователь уже существует");
        }
    }

    private void validateUserUpdate(User user) {
        if (user.getUserName() == null || user.getUserName().trim().isEmpty()) {
            throw new LibraryException("Имя пользователя не может быть пустым");
        }
        if (user.getUserName().length() < 2) {
            throw new LibraryException("Имя пользователя должно содержать минимум 2 символа");
        }
        if (user.getUserName().length() > 50) {
            throw new LibraryException("Имя пользователя не может быть длиннее 50 символов");
        }
        if (!USERNAME_PATTERN.matcher(user.getUserName()).matches()) {
            throw new LibraryException("Имя пользователя может содержать только буквы и пробелы");
        }
        if (user.getPhoneNumber() == null || !PHONE_PATTERN.matcher(user.getPhoneNumber()).matches()) {
            throw new LibraryException("Неверный формат номера телефона. Должно быть 11 цифр");
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty() && user.getPassword().length() < 6) {
            throw new LibraryException("Пароль должен содержать минимум 6 символов");
        }
    }

    public void addBookToLibrary(Long userId, Long bookId) {
        try {
            User user = findById(userId)
                .orElseThrow(() -> new LibraryException("Пользователь не найден"));
            Book book = bookService.findById(bookId)
                .orElseThrow(() -> new LibraryException("Книга не найдена"));

            user.getBooks().add(book);
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Эта книга уже есть в вашей библиотеке");
        }
    }

    public void removeBookFromLibrary(Long userId, Long bookId) {
        User user = findById(userId)
            .orElseThrow(() -> new LibraryException("Пользователь не найден"));
        Book book = bookService.findById(bookId)
            .orElseThrow(() -> new LibraryException("Книга не найдена"));

        user.getBooks().remove(book);
        userRepository.save(user);
    }
}