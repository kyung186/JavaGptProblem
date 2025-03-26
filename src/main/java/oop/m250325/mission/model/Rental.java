package oop.m250325.mission.model;

import java.time.LocalDate;

public class Rental {

    private Book book;
    private LocalDate rentalDate;
    private LocalDate returnDueDate;

    public Rental(Book book, LocalDate rentalDate, LocalDate returnDueDate) {
        this.book = book;
        this.rentalDate = rentalDate;
        this.returnDueDate = returnDueDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }
}
