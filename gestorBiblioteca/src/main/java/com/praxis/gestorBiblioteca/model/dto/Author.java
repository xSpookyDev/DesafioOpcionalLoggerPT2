package com.praxis.gestorBiblioteca.model.dto;

public class Author {
    private int authorId;
    private String name;
    private String lastName;
    private String birhdateYear;

    public Author() {
    }

    public Author(int authorId, String name, String lastName, String birhdateYear) {
        this.authorId = authorId;
        this.name = name;
        this.lastName = lastName;
        this.birhdateYear = birhdateYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirhdateYear() {
        return birhdateYear;
    }

    public void setBirhdateYear(String birhdateYear) {
        this.birhdateYear = birhdateYear;
    }
}
