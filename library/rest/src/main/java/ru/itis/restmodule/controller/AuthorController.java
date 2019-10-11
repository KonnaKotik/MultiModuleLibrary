package ru.itis.restmodule.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.logicmodule.dto.AuthorDto;

import ru.itis.logicmodule.model.Author;
import ru.itis.logicmodule.service.AuthorsService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorsService authorsService;


    @Autowired
    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @ApiOperation("Get all author")
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthor() {
        return ResponseEntity.ok().body(authorsService.getAll());
    }


    @ApiOperation("Get author by id")
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorsService.getById(id));
    }

    @ApiOperation("Create author")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        authorsService.save(authorDto);
    }



    @ApiOperation("Get edit author page")
    @GetMapping("/edit/{id}")
    public ResponseEntity<AuthorDto> getAuthorEditForm(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorsService.getById(id));
    }

    @ApiOperation("Update author")
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @Valid @RequestBody AuthorDto authorDto) {
        authorsService.update(id, authorDto);
    }

    @ApiOperation("Delete author")
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        authorsService.delete(id);
    }


}
