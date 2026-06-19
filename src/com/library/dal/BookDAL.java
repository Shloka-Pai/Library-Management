package com.library.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.library.pojo.Book;
import com.library.util.DBConnection;

public class BookDAL {
	
	
	
    // Add Book
    public void addBook(Book b) {
        try {

            Connection con = DBConnection.getConnection();
            String sql = "insert into books values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, b.getBook_id());
            ps.setString(2, b.getbook_name());
            ps.setString(3, b.getauthor());
            ps.setDouble(4, b.getprice());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book Added Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Books
    public void viewBooks() {
        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from books";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +        
                        rs.getString("book_name") + " | "
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

            Connection con = DBConnection.getConnection();
            String sql = "select * from books where Book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Book Found");
                System.out.println(
                        rs.getInt("Book_id") + " | "
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

            Connection con = DBConnection.getConnection();
            String sql = "update books set book_name=?, author=?, price=? where Book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, b.getbook_name());
            ps.setString(2, b.getauthor());
            ps.setDouble(3, b.getprice());
            ps.setInt(4, b.getBook_id());

            int rows = ps.executeUpdate();
            if (rows > 0) {

                System.out.println("Book Updated Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Book
    public void deleteBook(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "delete from books where book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Deleted Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}