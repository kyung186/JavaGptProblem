package oop.m250325.mission.service;

import oop.m250325.mission.model.Book;
import oop.m250325.mission.model.Rental;

import java.time.LocalDate;
import java.util.*;

public class RentalManager {

    Map<String, List <Rental>> rentalMap = new HashMap<String, List <Rental>>();
    List<Rental> rentalList = new ArrayList<Rental>();

    // 회원의 대여 목록에 도서를 추가합니다.
    /*
    * 1. 회원의 대여 목록이 없을 경우 rentalMap에 추가한다.
    * 2. 회원의 대여 목록이 있을 경우 기존에 존재하는 객체의 데이터에 추가한다.
    * */
    public void rentBook(String memberId, Book book, LocalDate rentalDate, int rentalPeriod) {
        if (rentalMap.containsKey(memberId)) {
            rentalList = rentalMap.get(memberId);
        }
        rentalList.add(new Rental(book, rentalDate, rentalDate.plusDays(rentalPeriod)));
        rentalMap.put(memberId, rentalList);
    }

    // 회원이 책을 반납하는 기능을 구현합니다.
    public void returnBook(String memberId, String bookTitle) {
        rentalList = rentalMap.get(memberId);
        for (int i = 0; i < rentalList.size(); i++) {
            if (rentalList.get(i).getBook().getTitle().equals(bookTitle)) {
                rentalList.remove(i);
                break;
            }
        }
    }

    // 특정 회원의 연체 도서 목록과 연체료를 조회합니다.
    /*
    * 회원ID: LM001 -> 대여 도서: [Title1] (반납 기한: 2025-03-20) [Title2] (반납 기한: 2025-03-25)
      연체 도서: [Title1] (연체일: 2일, 연체료: 1000원)
    * */
    public void checkOverdue(String memberId) {

    }
}
