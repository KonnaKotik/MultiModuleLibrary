package ru.itis.logicmodule.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.itis.logicmodule.dto.BookDto;
import ru.itis.logicmodule.model.Book;


import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "author.id", source = "authorId")
    Book bookDtoToBook(BookDto bookDto);

    @Mappings({
            @Mapping(target = "authorName",source = "book.author.name"),
            @Mapping(target = "authorId", source = "book.author.id")
    })
    BookDto bookToBookDto(Book book);

    List<Book> bookDtosToBooks(List<BookDto> bookDtos);

    List<BookDto> booksToBookDtos(List<Book> books);
}
