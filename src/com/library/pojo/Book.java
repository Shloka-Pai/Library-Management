package com.library.pojo;

// POJO Class
public class Book {

    // Encapsulation
    private int Book_id;
    private String book_name;
    private String author;
    private double price;

    public Book() {

    }

    public Book(int Book_id, String book_name, String author, double price) {
        this.Book_id = Book_id;
        this.book_name = book_name;
        this.author = author;
        this.price = price;
    }

    public int getBook_id() {
        return Book_id;
    }


    public void setBook_id(int Book_id) {
        this.Book_id = Book_id;
    }
    
    public String getbook_name() {
        return book_name;
    }

  
    public void setbook_name(String book_name) {
        this.book_name = book_name;
    }

 
    public String getauthor() {
        return author;
    }


    public void setauthor(String author) {
        this.author = author;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

}