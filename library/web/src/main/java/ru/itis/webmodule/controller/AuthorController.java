package ru.itis.webmodule.controller;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.logicmodule.dto.AuthorDto;
import ru.itis.logicmodule.service.AuthorsService;

@Controller
public class AuthorController {


    private final AuthorsService authorsService;

    @Autowired
    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/authors")
    public ModelAndView getAllAthors() {
        ModelAndView model = new ModelAndView();
        model.addObject("authors", authorsService.getAll());
        model.setViewName("authors");
        return model;
    }

    @GetMapping("/authors/{id}")
    public ModelAndView getAuthor(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject("author", authorsService.getById(id));
        model.setViewName("author");
        return model;
    }


    @GetMapping("/authors/add")
    public String addAuthorPage() {
        return "authorAdd";
    }

    @PostMapping("/authors/add")
    public String addNewAuthor(@ModelAttribute("authorDto") AuthorDto authorCreateForm) {
        authorsService.save(authorCreateForm);
        return "redirect:/authors";
    }

    @PostMapping("/authors/edit/{id}")
    public String updateAuthors(@PathVariable Long id, @ModelAttribute("authorDto") AuthorDto authorDto) {
        authorsService.update(id, authorDto);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{id}")
    public String getEditBookPage(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorsService.getById(id));
        return "authorEdit";
    }

    @Transactional
    @PostMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorsService.delete(id);
        return "redirect:/authors";
    }


}