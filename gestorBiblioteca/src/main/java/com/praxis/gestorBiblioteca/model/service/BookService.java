package com.praxis.gestorBiblioteca.model.service;

import com.praxis.gestorBiblioteca.model.dto.Author;
import com.praxis.gestorBiblioteca.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {


    List<Book> searchAll();
    Book searchOne(int id);
    boolean create(Book b);
    boolean update(Book b);
    boolean delete(int id);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String authorName);
}
