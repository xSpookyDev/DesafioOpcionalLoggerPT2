package com.praxis.gestorBiblioteca.controller;

import com.praxis.gestorBiblioteca.GestorBibliotecaApplication;
import com.praxis.gestorBiblioteca.model.dto.Book;
import com.praxis.gestorBiblioteca.model.dto.Author;
import com.praxis.gestorBiblioteca.model.service.BookService;
import com.praxis.gestorBiblioteca.model.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

    private final BookService bookService;
    private final AuthorService authorService; // Asegúrate de tener AuthorService

    public BookController(BookService bookService, AuthorService authorService) {
        logger.warn("Iniciando bookController");
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("books", bookService.searchAll());
        return "BookList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.searchOne(id));
        return "bookEdit";
    }

    @GetMapping("/books/add")
    public ModelAndView create() {
        return new ModelAndView("add").addObject("book", new Book());
    }

    @PostMapping("/books/add")
    public String save(@ModelAttribute Book book) {
        // Buscar el autor usando el ID del formulario
        Author author = authorService.searchOne(book.getAuthorBook().getAuthorId());
        if (author != null) {
            book.setAuthorBook(author);
        } else {
            logger.warn("Autor no encontrado con ID: {}", book.getAuthorBook().getAuthorId());
        }

        boolean result = bookService.create(book);
        if (result) {
            logger.info("Libro creado correctamente");
            return "redirect:/";
        } else {
            logger.error("Error al crear el libro");
            return "add"; // Reanudar el formulario si ocurre un error
        }
    }

    @GetMapping("/books/search")
    public String search(@RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "author", required = false) String author,
                         Model model) {
        List<Book> books;
        if (title != null && !title.isEmpty()) {
            books = bookService.searchByTitle(title);
        } else if (author != null && !author.isEmpty()) {
            books = bookService.searchByAuthor(author);
        } else {
            books = bookService.searchAll();
        }
        model.addAttribute("books", books);
        return "search";
    }
}
