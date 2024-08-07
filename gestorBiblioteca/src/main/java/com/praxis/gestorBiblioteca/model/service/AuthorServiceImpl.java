package com.praxis.gestorBiblioteca.model.service;

import com.praxis.gestorBiblioteca.model.dto.Author;
import com.praxis.gestorBiblioteca.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{


    List<Author> authorList;
    public  AuthorServiceImpl(){
        authorList = new ArrayList<>();
        authorList.add(new Author(1,"Estefan","kramer","1932"));
        authorList.add(new Author(2,"Yonas","Rabel","1992"));
        authorList.add(new Author(3,"Carpintero","huaso","1974"));
        authorList.add(new Author(4,"Raul","gatuno","1999"));
        authorList.add(new Author(5,"Raula","gatuna","1942"));

    }

    @Override
    public List<Author> searchAll() {
        return authorList;
    }

    @Override
    public Author searchOne(int id) {
        return authorList.stream().filter(author -> author.getAuthorId() == id).findFirst().orElse(null);

    }

    @Override
    public boolean create(Author a) {
        return false;
    }

    @Override
    public boolean update(Author a) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
