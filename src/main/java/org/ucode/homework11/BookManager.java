package org.ucode.homework11;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {

    static ArrayList<Book> inventory = new ArrayList<Book>();
    static ArrayList<Book> availableBooks = new ArrayList<Book>();
    static ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public static void menu (){
        System.out.println("Please choose from the following options: ");
        System.out.println("\t1. Add a new book.");
        System.out.println("\t2. List all the books");
        System.out.println("\t3. Borrow a book");
        System.out.println("\t4. Return a book");
        System.out.println("\t5. Search all available books by Author");
        System.out.println("\t6. Search all available books by Title");
        System.out.println("\t7. Search all available books by Type");
        System.out.println("\t8. Quit program");
        System.out.println(">");
    }

    public static void addBook (){
        System.out.println("Please specify the ISBN");
        Book book = new Book();
        Scanner sc = new Scanner(System.in);
        long isbn = sc.nextLong();
        String lengthOfISBN = Long.toString(isbn);
        while (lengthOfISBN.length()<10){
            System.out.println("Please make sure that the ISBN is correct, it should be at least 10 characters long or 13 if the book was published after 2007");
            isbn = sc.nextLong();
            lengthOfISBN = Long.toString(isbn);
        }
        book.setISBN(isbn);

        System.out.println("Please specify the publisher");
        String publisher = sc.next();
        while (publisher.length() > 50) {
            System.out.println("Publisher can not be equal to or more than 50 characters. Please try again");
            publisher = sc.next();
        }

        System.out.println("Please specify the author");
        String author = sc.next();
        while (author.length() > 50) {
            System.out.println("Author can not be equal to or more than 50 characters. Please try again");
            author = sc.next();
        }

        System.out.println("Please specify the title");
        String title = sc.next();
        while (title.length() > 50) {
            System.out.println("Title can not be equal to or more than 50 characters. Please try again");
            title = sc.next();
        }

        System.out.println("Please specify the year the book was published");
        int year = sc.nextInt();
        while (year < 1454 || year > 2020){
            while (year < 1454){
                System.out.println("Calm down you do not have an older book that the first edition Gutenberg Bible.Please make sure the year is correct.");
                year = sc.nextInt();
            }
            while (year > 2020){
                System.out.println("Calm down Marty McFly you do not have a book from the future. Please make sure the year is correct.");
                year = sc.nextInt();
            }
        }

        System.out.println("Please specify the type");
        String type = sc.next();
        while (!(type.equals("kindle") || type.equals("audiobook") || type.equals("hardcover") || type.equals("paperback"))) {
            System.out.println("Please specify a valid book type(kindle, audiobook, hardcover or paperback)");
            type = sc.next();
        }

        inventory.add(new Book(isbn, publisher, author, title, year, type));
        availableBooks.add(new Book(isbn, publisher, author, title, year, type));
        System.out.println("New book successfully added");

    }

    public static void listAllBooks(){
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("book ISBN: " + inventory.get(i).getISBN());
            System.out.println("publisher: " + inventory.get(i).getPublisher());
            System.out.println("author: " + inventory.get(i).getAuthor());
            System.out.println("title: " + inventory.get(i).getTitle());
            System.out.println("year: " + inventory.get(i).getYear());
            System.out.println();
        }
    }

    public static void rentBook(){
        System.out.println("Please specify the ISBN of the book you would like to rent:");
        Scanner sc = new Scanner(System.in);
        long borrow = sc.nextLong();
        for (int i=0;i<availableBooks.size();i++){
            if (borrow == availableBooks.get(i).ISBN) {
                borrowedBooks.add(new Book(availableBooks.get(i).ISBN, availableBooks.get(i).publisher, availableBooks.get(i).author, availableBooks.get(i).title, availableBooks.get(i).year, availableBooks.get(i).type));
                availableBooks.remove(new Book(availableBooks.get(i).ISBN, availableBooks.get(i).publisher, availableBooks.get(i).author, availableBooks.get(i).title, availableBooks.get(i).year, availableBooks.get(i).type));
                System.out.println("Book with ISBN number "+availableBooks.get(i).getISBN()+" has been successfully borrowed.");
            }
            while (borrow != availableBooks.get(i).ISBN){
                System.out.println("Book with ISBN number "+availableBooks.get(i).getISBN()+" is not available. Please choose another one.");
                borrow = sc.nextLong();
            }
        }
    }

    public static void returnBook (){
        System.out.println("Please specify the ISBN of the book you would like to return:");
        Scanner sc = new Scanner(System.in);
        long returnBook = sc.nextLong();
        for (int i=0;i<availableBooks.size();i++){
            if (returnBook == borrowedBooks.get(i).ISBN) {
                borrowedBooks.remove(new Book(availableBooks.get(i).ISBN, availableBooks.get(i).publisher, availableBooks.get(i).author, availableBooks.get(i).title, availableBooks.get(i).year, availableBooks.get(i).type));
                availableBooks.add(new Book(availableBooks.get(i).ISBN, availableBooks.get(i).publisher, availableBooks.get(i).author, availableBooks.get(i).title, availableBooks.get(i).year, availableBooks.get(i).type));
                System.out.println("Book with ISBN number "+availableBooks.get(i).getISBN()+" has been successfully returned.");
            }
            while (returnBook != availableBooks.get(i).ISBN){
                System.out.println("Book with ISBN number "+availableBooks.get(i).getISBN()+" was not borrowed. Please choose another one.");
                returnBook = sc.nextLong();
            }
        }
    }

    public static void authorSearch () {
        System.out.println("Please specify the author that you would like to search for");
        Scanner sc = new Scanner(System.in);
        String authorSearch = sc.next();
        for (int i = 0; i < inventory.size(); i++) {
            if (authorSearch.equals(inventory.get(i).author)) {
                System.out.println("book ISBN: " + inventory.get(i).getISBN());
                System.out.println("publisher: " + inventory.get(i).getPublisher());
                System.out.println("author: " + inventory.get(i).getAuthor());
                System.out.println("title: " + inventory.get(i).getTitle());
                System.out.println("year: " + inventory.get(i).getYear());
                System.out.println("type: " + inventory.get(i).getType());
                System.out.println();
            }
        }
    }

    public static void titleSearch () {
        System.out.println("Please specify the title that you would like to search for");
        Scanner sc = new Scanner(System.in);
        String titleSearch = sc.next();
        for (int i = 0; i < inventory.size(); i++) {
            if (titleSearch.equals(inventory.get(i).title)){
                System.out.println("book ISBN: " + inventory.get(i).getISBN());
                System.out.println("publisher: " + inventory.get(i).getPublisher());
                System.out.println("author: " + inventory.get(i).getAuthor());
                System.out.println("title: " + inventory.get(i).getTitle());
                System.out.println("year: " + inventory.get(i).getYear());
                System.out.println("type: " + inventory.get(i).getType());
                System.out.println();
            }
        }
    }

    public static void typeSearch (){
        System.out.println("Please specify the type that you would like to search for");
        Scanner sc = new Scanner(System.in);
        String typeSearch = sc.next();
        for (int i = 0; i < inventory.size(); i++) {
            if (typeSearch.equals(inventory.get(i).type)){
                System.out.println("book ISBN: " + inventory.get(i).getISBN());
                System.out.println("publisher: " + inventory.get(i).getPublisher());
                System.out.println("author: " + inventory.get(i).getAuthor());
                System.out.println("title: " + inventory.get(i).getTitle());
                System.out.println("year: " + inventory.get(i).getYear());
                System.out.println("type: " + inventory.get(i).getType());
                System.out.println();
            }
        }
    }
}
