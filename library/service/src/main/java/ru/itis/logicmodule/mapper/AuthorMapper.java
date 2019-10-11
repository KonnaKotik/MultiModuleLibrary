package ru.itis.logicmodule.mapper;

import org.mapstruct.Mapper;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.model.Author;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface AuthorMapper {

    Author authorDtoToAuthor(AuthorDto authorDto);

    AuthorDto authorToAuthorDto(Author author);

    List<Author> auhtorDtosToAuthors(List<AuthorDto> authorDtos);

    List<AuthorDto> authorsToAuthorDtos(List<Author> authors);

}
