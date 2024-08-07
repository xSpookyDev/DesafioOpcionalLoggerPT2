package com.praxis.gestorBiblioteca.model.service;

import com.praxis.gestorBiblioteca.model.dto.Author;
import com.praxis.gestorBiblioteca.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookList;
    private AuthorService authorService = new AuthorServiceImpl();

    public BookServiceImpl() {

        bookList = new ArrayList<>();
        bookList.add(new Book(0, "El cuento chino", "Aprender a robar como chino", "20000", authorService.searchOne(1)));
        bookList.add(new Book(1, "El cuento chino", "Aprender a robar como japones", "20000",authorService.searchOne(2)));
        bookList.add(new Book(2, "El cuento chino", "Aprender a robar como taiwanes", "20000", authorService.searchOne(3)));
        bookList.add(new Book(3, "El cuento chino", "Aprender a robar como coreano", "20000", authorService.searchOne(4)));
        bookList.add(new Book(0, "El cuento chino", "Aprender a robar como philipino", "20000", authorService.searchOne(5)));


    }

    @Override
    public List<Book> searchAll() {
        return bookList;
    }

    @Override
    public Book searchOne(int id) {
        return bookList.stream().filter(book -> book.getId()== id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Book b) {
       bookList.add(b);
       return true;
    }

    @Override
    public boolean update(Book b) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public List<Book> searchByTitle(String title) {
        return bookList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String authorName) {
        return bookList.stream()
                .filter(book -> {
                    if (book.getAuthorBook() == null || book.getAuthorBook().getName() == null) {
                        return false;
                    }
                    return book.getAuthorBook().getName().toLowerCase().contains(authorName.toLowerCase());
                })
                .collect(Collectors.toList());
    }

}
