package com.example.librarymanagement;

public class Modal_books {

    String books, code, author, sem, dept, price, count;

    public Modal_books() {
    }

    public Modal_books(String books, String code, String author, String sem, String dept, String price, String count) {
        this.books = books;
        this.code = code;
        this.author = author;
        this.sem = sem;
        this.dept = dept;
        this.price = price;
        this.count = count;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
