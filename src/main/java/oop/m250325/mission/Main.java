package oop.m250325.mission;

import oop.m250325.mission.model.Book;
import oop.m250325.mission.model.Member;
import oop.m250325.mission.service.RecommendManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Member 객체 선언해서 테스트값 입력
//        Member member1 = new Member("LM001", "meta", "Fantasy");
//        Member member2 = new Member("LM002", "verse", "Romance");

        // List 사용하여 도서 목록의 테스트값 입력
        List<Book> bookList = new ArrayList<>();
//        bookList.add(new Book("Java", "Spring", "Fantasy"));
//        bookList.add(new Book("Python", "Django", "Science"));
//        bookList.add(new Book("C#", "DotNet", "Fantasy"));
//        bookList.add(new Book("Php", "Rarabel", "Science"));
//        bookList.add(new Book("JavaScript", "React", "Romance"));

        // RecommendManager 객체 선언
//        RecommendManager manager = new RecommendManager();

        // 테스트 - 도서 추천 출력1
//        manager.recommendBook(member1, bookList);
//        manager.getBookList(member1.getId(), member1.getPreferGenre());

        // 테스트 - 도서 추천 출력2
//        manager.recommendBook(member2, bookList);
//        manager.getBookList(member2.getId(), member2.getPreferGenre());

        // 특정 장르 도서 조회
//        manager.getSpecBook("Science", bookList);

    }
}
