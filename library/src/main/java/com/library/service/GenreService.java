package com.library.service;

import com.library.exception.LibraryException;
import com.library.model.Genre;
import com.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private static final Pattern GENRE_NAME_PATTERN = Pattern.compile("^[а-яА-Яa-zA-Z\\s]{2,100}$");

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre) {
        try {
            validateGenre(genre);
            return genreRepository.save(genre);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Жанр с таким названием уже существует");
        }
    }

    public Genre update(Genre genre) {
        try {
            validateGenre(genre);
            return genreRepository.save(genre);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Жанр с таким названием уже существует");
        }
    }

    private void validateGenre(Genre genre) {
        if (genre.getGenreName() == null || genre.getGenreName().trim().isEmpty()) {
            throw new LibraryException("Название жанра не может быть пустым");
        }
        if (genre.getGenreName().length() < 2) {
            throw new LibraryException("Название жанра должно содержать минимум 2 символа");
        }
        if (genre.getGenreName().length() > 100) {
            throw new LibraryException("Название жанра не может быть длиннее 100 символов");
        }
        if (!GENRE_NAME_PATTERN.matcher(genre.getGenreName()).matches()) {
            throw new LibraryException("Название жанра может содержать только буквы и пробелы");
        }
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    public void deleteById(Long id) {
        try {
            genreRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new LibraryException("Невозможно удалить жанр, так как он используется в книгах");
        }
    }
} 