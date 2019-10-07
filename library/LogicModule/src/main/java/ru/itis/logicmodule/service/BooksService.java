package ru.itis.logicmodule.service;

import ru.itis.logicmodule.dto.BookDto;

import java.util.List;

public interface BooksService {


    List<BookDto> getAll();

    void save(BookDto bookDto);

    void update(Long id, BookDto bookDto);

    BookDto getById(Long id);

    void deleteById(Long id);

    List<BookDto> getBooksByAuthorId(Long authorId);
}
