package ru.itis.logicmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.logicmodule.dto.BookDto;
import ru.itis.logicmodule.mapper.BookMapper;
import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.model.Book;
import ru.itis.logicmodule.repository.AuthorRepository;
import ru.itis.logicmodule.repository.BooksRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;


    private final BookMapper bookMapper;


    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository, BookMapper bookMapper, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDto> getAll() {
        return bookMapper.booksToBookDtos(booksRepository.findAll());
    }

    @Override
    public void save(BookDto bookDto) {
            Author author = authorRepository.findByName(bookDto.getAuthorName()).orElseThrow(EntityNotFoundException::new);
            Book book = bookMapper.bookDtoToBook(bookDto);
            book.setAuthor(author);
            booksRepository.save(book);
    }


    @Override
    public void update(Long id, BookDto bookDto) {
        BookDto newBookDto = getById(id);
        newBookDto.setDescription(bookDto.getDescription());
        newBookDto.setTitle(bookDto.getTitle());
        Book book = bookMapper.bookDtoToBook(newBookDto);
        booksRepository.save(book);

    }

    @Override
    public List<BookDto> getBooksByAuthorId(Long authorId) {
        return bookMapper.booksToBookDtos(booksRepository.findAllByAuthor_Id(authorId));
    }

   // @Transactional
    @Override
    public void deleteById(Long id) {
        Book book = booksRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        booksRepository.deleteBookById(id);
    }

    @Override
    public BookDto getById(Long id) {
        Book book = booksRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return bookMapper.bookToBookDto(book);

    }
}
