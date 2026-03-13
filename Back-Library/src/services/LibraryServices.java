package services;


import entities.Book;
import entities.Loan;
import entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryServices {



   private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
   private List<Loan> loans = new ArrayList<>();

    public void signInBook(Book book) {
        if (getBook(book.getId()) == null) {
            books.add(book);
        }
    }
    public void signOutBook(Book book) {
        for (Loan activeLoan : getActiveLoans()){
            if (activeLoan.getBook() ==  book){
                return;
            }
        }
        books.remove(book);
    }
    public void signInUser(User user) {
        if(getUser(user.getId()) == null) {
            users.add(user);
        }
    }
    public void signOutUser(User user) {
        for (Loan  activeLoan : getActiveLoans()){
            if(activeLoan.getUser() ==  user){
                return;
            }
        }
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
        Loan.LoanType loanType = Loan.LoanType.NORMAL;
        Book book = getBook(bookId);
        User user = getUser(userId);
        if (book == null || user == null) {
            return null;
        }
        if (book.isAvailable() == true) {
            Loan loan = new Loan(book, user,LocalDateTime.now(), loanType);
            loans.add(loan);
            book.setAvailable(false);
            return loan;
        }
        return null;
    }
    public List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null && LocalDateTime.now().isAfter(loan.getDueDate())) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }

    public Loan returnBook(int bookId, int userId) {
        Book book = getBook(bookId);
        User user = getUser(userId);
        if (book == null || user == null) {
            return null;
        }
        for (Loan loan : loans) {
        if(loan.getBook().getId() == bookId && loan.getUser().getId() == userId && loan.getReturnDate() == null) {
            loan.setReturnDate(LocalDateTime.now());
            book.setAvailable(true);
            return loan;
        }
        }
        return null;
    }
    public List<Loan> getActiveLoans(){
        List <Loan> activeLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null && LocalDateTime.now().isBefore(loan.getDueDate())) {
                    activeLoans.add(loan);
                }
            }
        return activeLoans;
    }
    public List<Loan> getLoansByUser(int userId) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUser().getId() == userId){
                userLoans.add(loan);
            }
        }
        return userLoans;
    }
}


