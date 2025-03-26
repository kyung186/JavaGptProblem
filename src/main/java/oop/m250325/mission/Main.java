package oop.m250325.mission;

import oop.m250325.mission.model.Book;
import oop.m250325.mission.model.Member;
import oop.m250325.mission.service.RecommendManager;
import oop.m250325.mission.service.RentalManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Member 객체 선언해서 테스트값 입력
        Member member1 = new Member("LM001", "meta", "Fantasy");
        Member member2 = new Member("LM002", "verse", "Romance");

        // List 사용하여 도서 목록의 테스트값 입력
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java", "Spring", "Fantasy"));
        bookList.add(new Book("Python", "Django", "Science"));
        bookList.add(new Book("C#", "DotNet", "Fantasy"));
        bookList.add(new Book("Php", "Rarabel", "Science"));
        bookList.add(new Book("JavaScript", "React", "Romance"));

        RentalManager rentalManager = new RentalManager();

        rentalManager.rentBook(member1.getId(), bookList.get(0), LocalDate.now(), 5);

        rentalManager.checkOverdue(member1.getId());
    }
}
