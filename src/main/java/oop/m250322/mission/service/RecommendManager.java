package oop.m250322.mission.service;

import oop.m250322.mission.model.Book;
import oop.m250322.mission.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendManager {

    // 회원의 선호 장르를 기반으로 도서를 추천하는 기능
    /*
    * 1. 회원 객체, 도서 목록을 매개변수로 받아온다.
    * 2. 추천 도서 제목을 담을 List(titleList)를 생성한다.
    * 3. 도서 목록에서 회원 장르와 같은 도서를 찾아서 titleList에 담는다.
    * 4. 회원 ID와 추천 도서 제목을 담을 Map(recommendMap)을 생성한다.
    * 5. recommendMap에 <회원 ID, 추천 도서 제목>을 담는다.
    * */

    // 특정 장르의 도서 제목을 담을 specificList를 선언한다.
    List<String> specificList = new ArrayList<>();
    // 3. 추천 도서 제목을 담을 titleList를 생성한다.
    List<String> titleList = new ArrayList<>();
    // 4. 회원 ID와 추천 도서 제목을 담을 recommendMap을 생성한다.
    Map<String, List<String>> recommendMap = new HashMap<>();

    // 1. 회원 객체, 도서 목록을 매개변수로 받아온다.
    public void recommendBook(Member member, List<Book> bookList) {

        // 2. 도서 목록에서 회원 장르와 같은 도서를 찾는다.
        //    foreach문을 돌면서 회원 장르와 도서 장르를 비교하여 같으면 titleList에 담는다.
        titleList = inquireGenre(member.getPreferGenre(), bookList);

        // 5. recommendMap에 <회원 ID, 추천 도서 제목>을 담는다.
        recommendMap.put(member.getId(), titleList);
    }

    // 특정 장르의 도서 목록을 조회하는 기능
    public List<String> inquireGenre(String genre, List<Book> bookList) {

        // foreach문을 돌면서 특정 장르와 도서 장르를 비교하여 같으면 specificList에 담는다.
        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                specificList.add("[" + book.getTitle() + "]");
            }
        }
        return specificList;
    }

    // 특정 장르의 도서 목록을 조회하여 출력하는 기능
    public void getSpecBook(String genre, List<Book> bookList) {
        inquireGenre(genre, bookList);
        String specBookList = String.join(", ", specificList);

        System.out.println("[ " + genre + " ] 장르의 도서 목록: " + specBookList);
    }

    // 추천된 도서를 문자열로 반환하는 기능
    /*
    * 1. recommendMap의 key가 id인 value를 찾는다.
    * 2. String.join을 사용하여 추천 도서를 recommBook에 담는다.
    * 3. 출력 형식에 맞춰서 id와 추천 도서를 출력한다.
    * */
    public void getBookList(String id, String genre) {
        // 1. recommendMap의 key가 id인 value를 찾는다.
        titleList = recommendMap.get(id);

        // +) 제목 옆에 장르를 붙인다.
        for (int i = 0; i < titleList.size(); i++) {
            titleList.set(i, titleList.get(i) + " (" + genre + ")");
        }

        // 2. String.join을 사용하여 추천 도서를 recommBook에 담는다.
        String recommBook = String.join(", ", titleList);

        // 3. 출력 형식에 맞춰서 id와 추천 도서를 출력한다.
        System.out.println("회원ID : " + id + "님을 위한 추천 도서: " + recommBook);
    }
}
