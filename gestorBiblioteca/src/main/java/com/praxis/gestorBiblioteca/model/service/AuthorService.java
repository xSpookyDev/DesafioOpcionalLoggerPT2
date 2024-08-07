package com.praxis.gestorBiblioteca.model.service;


import com.praxis.gestorBiblioteca.model.dto.Author;
import com.praxis.gestorBiblioteca.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorService {
    List<Author> searchAll();
    Author searchOne(int id);
    boolean create(Author a);
    boolean update(Author a);
    boolean delete(int id);
}
