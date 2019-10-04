package ru.itis.logicmodule.service;

import org.springframework.stereotype.Service;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.model.Book;

import java.util.List;


@Service
public class AuthorsServiceImpl implements AuthorsService {


    @Override
    public List<AuthorDto> getAll() {
        return null;
    }

    @Override
    public AuthorDto getById(Long id) {
        return null;
    }

    @Override
    public void save(AuthorDto authorDto) {

    }

    @Override
    public void update(Long id, AuthorDto authorDto) {


    }

    @Override
    public void delete(Long id) {

    }
}
