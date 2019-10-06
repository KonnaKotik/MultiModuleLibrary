package ru.itis.logicmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.mapper.AuthorMapper;
import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.model.Book;
import ru.itis.logicmodule.repository.AuthorRepository;
import ru.itis.logicmodule.repository.BooksRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Transactional
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BooksRepository booksRepository;

    @Autowired
    public AuthorsServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.booksRepository = booksRepository;
    }


    @Override
    public void save(AuthorDto authorDto) {
        authorRepository.save(authorMapper.authorDtoToAuthor(authorDto));
    }

    @Override
    public void delete(Long id) {
        List<Book> books = booksRepository.findAllByAuthor_Id(id);
        for (Book book : books) {
            booksRepository.deleteBookById(book.getId());
        }
        authorRepository.deleteAuthorById(id);
    }

    @Override
    public void update(Long id, AuthorDto authorDto) {
        AuthorDto newAuthorDto = getById(id);
        newAuthorDto.setName(authorDto.getName());
        newAuthorDto.setDescription(authorDto.getDescription());
        Author author = authorMapper.authorDtoToAuthor(newAuthorDto);
        authorRepository.save(author);
    }

    @Override
    public AuthorDto getById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return authorMapper.authorToAuthorDto(author);

    }

    @Override
    public List<AuthorDto> getAll() {
        return authorMapper.authorsToAuthorDtos(authorRepository.findAll());
    }
}
