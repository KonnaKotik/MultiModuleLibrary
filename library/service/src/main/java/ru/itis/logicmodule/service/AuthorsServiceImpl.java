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
import java.util.Optional;


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
    public boolean save(AuthorDto authorDto) {
        Optional<Author> authorCandidate = authorRepository.findByName(authorDto.getName());
        if(authorCandidate.isPresent()) {
            return false;
        }
        authorRepository.save(authorMapper.authorDtoToAuthor(authorDto));
      /*  System.out.println();
        System.out.println();
        System.out.println("id" + authorRepository.findByName(authorDto.getName()).get().getId());*/
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Author> authorCandidate = authorRepository.findById(id);
        if(authorCandidate.isPresent()) {
            List<Book> books = booksRepository.findAllByAuthor_Id(id);
            for (Book book : books) {
                booksRepository.deleteBookById(book.getId());
            }
            authorRepository.deleteAuthorById(id);
            return true;
        }
        return false;
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
        Optional<Author> authorCandidate = authorRepository.findById(id);
        if(authorCandidate.isPresent()) {

            return authorMapper.authorToAuthorDto(authorCandidate.get());
        } else throw new EntityNotFoundException("don't find author with id = " + id );

    }

    @Override
    public List<AuthorDto> getAll() {
        return authorMapper.authorsToAuthorDtos(authorRepository.findAll());
    }
}
