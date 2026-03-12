package entities;

import java.time.LocalDateTime;

public class Loan {
    private Book book;
    private User user;
    private LocalDateTime loanDate =  LocalDateTime.now();
    private LocalDateTime returnDate;
    private LocalDateTime dueDate;

    public Loan(Book book, User user, LocalDateTime loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    public Loan(Book book, User user, LoanType loanType) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDateTime.now();
        this.dueDate = loanDate.plusDays(loanType.getDays());

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public enum LoanType{
        NORMAL(30),
        EXTENDED(60);

        private int days;
        LoanType(int days) {
            this.days = days;
        }
        public int getDays() {
            return days;
        }
    }
}
