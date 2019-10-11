package ru.itis.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.logicmodule.dto.BookDto;
import ru.itis.logicmodule.service.AuthorsService;
import ru.itis.logicmodule.service.BooksService;

@Controller
public class BookController {

    private final BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", booksService.getAll());
        return "books";
    }

    @GetMapping("/books/{id}")
    public ModelAndView getBookPage(@PathVariable Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("book", booksService.getById(id));
        model.setViewName("book");
        return model;
    }

    @GetMapping("/authors/books/{id}")
    public String getAuthorBook(@PathVariable Long id, Model model) {
        model.addAttribute("books", booksService.getBooksByAuthorId(id));
        return "authorBook";
    }

    @PostMapping("/books/add")
    public String addNewBook(@ModelAttribute BookDto bookCreateForm) {
        booksService.save(bookCreateForm);
        return "redirect:/books";
    }

    @GetMapping("/books/add")
    public String addBookPAge() {
        return "bookAdd";
    }

    @GetMapping("/books/edit/{id}")
    public String getEditBookPage(@PathVariable Long id, Model model) {
        model.addAttribute("book", booksService.getById(id));
        return "bookEdit";
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute BookDto bookDto) {
        booksService.update(id, bookDto);
        return "redirect:/books";
    }

    @Transactional
    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        booksService.deleteById(id);
        return "redirect:/books";
    }

}
