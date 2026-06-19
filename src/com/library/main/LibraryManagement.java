package com.library.main;

import java.util.Scanner;

import com.library.dal.BookDAL;
import com.library.pojo.Book;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAL dal = new BookDAL();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Book b1 = new Book();

                System.out.print("Enter Book ID : ");
                b1.setBook_id(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Title : ");
                b1.setbook_name(sc.nextLine());

                System.out.print("Enter Author : ");
                b1.setauthor(sc.nextLine());

                System.out.print("Enter Price : ");
                b1.setprice(sc.nextDouble());

                dal.addBook(b1);

                break;

            case 2:

                dal.viewBooks();

                break;

            case 3:

                System.out.print("Enter Book ID : ");
                int searchId = sc.nextInt();

                dal.searchBook(searchId);

                break;

            case 4:

                Book b2 = new Book();

                System.out.print("Enter Book ID : ");
                b2.setBook_id(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter New Title : ");
                b2.setbook_name(sc.nextLine());

                System.out.print("Enter New Author : ");
                b2.setauthor(sc.nextLine());

                System.out.print("Enter New Price : ");
                b2.setprice(sc.nextDouble());

                dal.updateBook(b2);

                break;

            case 5:

                System.out.print("Enter Book ID : ");
                int deleteId = sc.nextInt();

                dal.deleteBook(deleteId);

                break;

            case 6:

                System.out.println("Thank You");
                break;

            default:

                System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}