package ru.itis.logicmodule.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.mapper.AuthorMapper;
import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.repository.AuthorRepository;
import ru.itis.logicmodule.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AuthorsServiceImplTest {


    @Autowired
    private AuthorsService authorsService;

    private boolean insertAuthor() {
        AuthorDto authorDto = AuthorDto.builder()
                .name("NaNa")
                .description("na")
                .build();
        return authorsService.save(authorDto);
    }


    @Test
    public void savePositiveTest() {
        AuthorDto authorDto = AuthorDto.builder()
                .id(9L)
                .name("Na")
                .description("na")
                .build();

        boolean isAuthorCreated = authorsService.save(authorDto);

        Assert.assertTrue(isAuthorCreated);
    }


    @Test
    public void saveNegativeTest() {
        boolean bool = insertAuthor();
        AuthorDto authorDto = AuthorDto.builder()
                .id(10L)
                .name("NaNa")
                .description("na")
                .build();


        boolean isAuthorCreated = authorsService.save(authorDto);

        Assert.assertFalse(isAuthorCreated);

    }

    @Test
    public void deleteAuthorPositiveTest() {
        Long id = 40L;

        Author author = new Author();
        author.setId(id);

        boolean isAuthorDelete = authorsService.delete(id);

        Assert.assertTrue(isAuthorDelete);
    }

    @Test
    public void deleteAuthorNegativeTest() {
        Long id = 1L;

        boolean isAuthorDelete = authorsService.delete(id);

        Assert.assertFalse(isAuthorDelete);
    }

    @Test
    public void update() {
    }

    @Test
    public void getByIdPositiveTest() {

        Long id = 48L;
        boolean bool = insertAuthor();
        AuthorDto authorDto = authorsService.getById(id);

        Assert.assertNotNull(authorDto);
    }

    @Test
    public void getAllPositiveTest() {

        insertAuthor();

        Assert.assertNotNull(authorsService.getAll());
    }
}