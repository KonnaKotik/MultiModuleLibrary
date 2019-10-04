package ru.itis.logicmodule.service;

import ru.itis.logicmodule.dto.AuthorDto;

import java.util.List;

public interface AuthorsService {
    List<AuthorDto> getAll();

    AuthorDto getById(Long id);

    void save(AuthorDto authorDto);

    void update(Long id, AuthorDto authorDto);

    void delete(Long id);
}
