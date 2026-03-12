package services;


import entities.Book;
import entities.Loan;
import entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryServices {



    List<User> users = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();

    public void signInBook(Book book) {
        books.add(book);
    }
    public void signOutBook(Book book) {
        books.remove(book);
    }
    public void signInUser(User user) {
        users.add(user);
    }
    public void signOutUser(User user) {
        users.remove(user);
    }
    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }


    public Loan loanBook(int bookId, int userId) {
        Book book = getBook(bookId);
        User user = getUser(userId);
        if (book == null || user == null) {
            return null;
        }
        if (book.isAvailable()) {
            Loan loan = new Loan(book, user,  LocalDateTime.now());
            loans.add(loan);
            book.setAvailable(false);
            return loan;
        }
        return null;
    }

    public Loan returnBook(int bookId, int userId) {
        Book book = getBook(bookId);
        User user = getUser(userId);
        if (book == null || user == null) {
            return null;
        }
        if (!book.isAvailable()) {
                for (Loan loan : loans) {
                    if (loan.getBook().getId() == bookId && loan.getUser().getId() == userId) {
                        if(loan.getReturnDate() == null) {
                            loan.setReturnDate(LocalDateTime.now());
                            book.setAvailable(true);
                            return loan;
                        }
                    }
                }
            }

        return null;
    }
}


