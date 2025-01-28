package com.library.service;

import com.library.exception.LibraryException;
import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private static final Pattern BOOK_NAME_PATTERN = Pattern.compile("^[а-яА-Яa-zA-Z0-9\\s\\-.,!?()\"']{2,255}$");

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        try {
            validateBook(book);
            return bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Книга с таким названием уже существует в данном жанре");
        }
    }

    public Book update(Book book) {
        try {
            validateBook(book);
            return bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Книга с таким названием уже существует в данном жанре");
        }
    }

    private void validateBook(Book book) {
        if (book.getBookName() == null || book.getBookName().trim().isEmpty()) {
            throw new LibraryException("Название книги не может быть пустым");
        }
        if (book.getBookName().length() < 2) {
            throw new LibraryException("Название книги должно содержать минимум 2 символа");
        }
        if (book.getBookName().length() > 255) {
            throw new LibraryException("Название книги не может быть длиннее 255 символов");
        }
        if (!BOOK_NAME_PATTERN.matcher(book.getBookName()).matches()) {
            throw new LibraryException("Название книги содержит недопустимые символы. Разрешены буквы, цифры, пробелы и знаки препинания");
        }
        
        if (book.getGenre() == null || book.getGenre().getGenreId() == null) {
            throw new LibraryException("Необходимо указать жанр книги");
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteById(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Невозможно удалить книгу, так как она используется");
        }
    }
} 