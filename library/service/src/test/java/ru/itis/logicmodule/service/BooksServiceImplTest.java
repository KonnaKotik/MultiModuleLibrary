package ru.itis.logicmodule.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.dto.BookDto;
import ru.itis.logicmodule.mapper.BookMapper;
import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.model.Book;
import ru.itis.logicmodule.repository.AuthorRepository;
import ru.itis.logicmodule.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BooksServiceImplTest {

    @Autowired
    private BooksService booksService;

    @Autowired
    AuthorsService authorsService;

    private void initBook() {
        AuthorDto authorDto = AuthorDto.builder()
                .name("NaNa")
                .description("na")
                .build();
        authorsService.save(authorDto);

        BookDto bookDto = BookDto.builder()
                .title("na")
                .description("nanananan")
                .authorName("NaNa")
                .build();


        booksService.save(bookDto);
    }


    @Test
    public void saveBookPositiveTest() {

        initBook();

        BookDto bookDto = BookDto.builder()
                .title("naghfje")
                .description("nanananan")
                .authorId(52L)
                .authorName("NaNa")
                .build();


        boolean isBookCreated = booksService.save(bookDto);

        Assert.assertTrue(isBookCreated);
    }

    @Test
    public void update() {

    }

    @Test
    public void getBooksByAuthorIdPositiveTest() {

        initBook();

        Long id = 53L;

        Assert.assertNotNull(booksService.getBooksByAuthorId(id));
    }

    @Test
    public void deleteBookByIdPositiveTest() {

        initBook();

        Long id = 33L;

        boolean isBookDelete = booksService.deleteById(id);

        Assert.assertTrue(isBookDelete);
    }

    @Test
    public void getByIdPositiveTest() {
        initBook();

        Long id = 34L;

        BookDto bookDto = booksService.getById(id);

        Assert.assertNotNull(bookDto);

    }
}