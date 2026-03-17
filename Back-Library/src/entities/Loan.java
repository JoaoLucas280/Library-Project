package entities;

import java.time.LocalDateTime;

public class Loan {
    private Book book;
    private User user;
    private LocalDateTime loanDate =  LocalDateTime.now();
    private LocalDateTime returnDate;
    private LocalDateTime dueDate;

    public Loan(Book book, User user,LocalDateTime loanDate, LoanType loanType) {
        this.book = book;
        this.user = user;
        this.dueDate = loanDate.plusDays(loanType.getDays());

    }

    public Book getBook() {
        return book;
    }
    public User getUser() {
        return user;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
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
