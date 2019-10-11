package ru.itis.restmodule.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.logicmodule.dto.BookDto;
import ru.itis.logicmodule.service.BooksService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    private final BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }


    @ApiOperation("Get all book")
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.ok().body(booksService.getAll());
    }

    @ApiOperation("Get book by id")
    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
        return ResponseEntity.ok().body(booksService.getById(id));
    }

    @ApiOperation("Get author's books")
    @GetMapping("/authors/{id}/books")
    public ResponseEntity<List<BookDto>> getAuthorBook(@PathVariable Long id) {
        return ResponseEntity.ok().body(booksService.getBooksByAuthorId(id));
    }

    @ApiOperation("Create book")
    @PostMapping("books/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDto bookDto) {
        booksService.save(bookDto);
    }


    @ApiOperation("Get edit book page")
    @GetMapping("/books/edit/{id}")
    public ResponseEntity<BookDto> getEditBookForm(@PathVariable Long id) {
        return ResponseEntity.ok().body(booksService.getById(id));
    }

    @ApiOperation("Update book")
    @PutMapping("/books/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void editBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        booksService.update(id, bookDto);
    }

    @ApiOperation("Delete book")
    @DeleteMapping("/books/delete/{id}")
    public void delete(@PathVariable Long id) {
        booksService.deleteById(id);
    }


}
