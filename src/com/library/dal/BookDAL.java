package com.library.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.library.exceptions.DuplicateBookIdException;
import com.library.pojo.Book;
import com.library.util.DBConnection;

public class BookDAL {

    private Connection con;

    public BookDAL() {
        con = DBConnection.getConnection();
    }

    // Add Book
    public void addBook(Book b) {

        try {

            // Check if Book ID already exists
            String checkSql = "SELECT * FROM books WHERE book_id = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);

            checkPs.setInt(1, b.getBook_id());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                throw new DuplicateBookIdException(
                        "Book with ID " + b.getBook_id() + " already exists.");
            }

            // Insert Book
            String sql = "INSERT INTO books VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, b.getBook_id());
            ps.setString(2, b.getbook_name());
            ps.setString(3, b.getauthor());
            ps.setDouble(4, b.getprice());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Added Successfully");
            }

        } catch (DuplicateBookIdException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // View Books
    public void viewBooks() {

        try {

            String sql = "SELECT * FROM books";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | "
                        + rs.getString("book_name") + " | "
                        + rs.getString("author") + " | "
                        + rs.getDouble("price"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Search Book
    public void searchBook(int id) {

        try {

            String sql = "SELECT * FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Book Found");

                System.out.println(
                        rs.getInt("book_id") + " | "
                        + rs.getString("book_name") + " | "
                        + rs.getString("author") + " | "
                        + rs.getDouble("price"));

            } else {

                System.out.println("Book Not Found");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Update Book
    public void updateBook(Book b) {

        try {

            String sql = "UPDATE books SET book_name=?, author=?, price=? WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, b.getbook_name());
            ps.setString(2, b.getauthor());
            ps.setDouble(3, b.getprice());
            ps.setInt(4, b.getBook_id());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Book Updated Successfully");

            } else {

                System.out.println("Book Not Found");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Delete Book
    public void deleteBook(int id) {

        try {

            String sql = "DELETE FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Book Deleted Successfully");

            } else {

                System.out.println("Book Not Found");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}