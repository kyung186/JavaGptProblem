# 📚 미션 : 도서 반납 및 연체 관리 기능 구현

## ✨ 개요
도서관에서 회원별 대여 도서를 관리하고, 반납 및 연체 여부를 확인하는 기능을 구현합니다. 회원은 책을 반납할 수 있으며, 기한 내 반납 여부를 시스템에서 확인할 수 있습니다.

## 🔍 요구사항
### **👉 입력**
- 회원 정보 (`LibraryMember` 객체): 회원 ID, 이름
- 도서 정보 (`Book` 객체): 제목, 저자, 대여일, 반납 기한
- 대여 목록 (`Map<String, List<Rental>>`): 회원 ID별 대여 기록 관리

### **👉 기능**
1. **회원별로 도서 대여 및 반납 기능 구현**
2. **반납 기한 초과 시 연체 여부 확인 및 연체료 계산 기능 추가**
3. **회원의 대여 목록 및 연체 도서 조회 기능**

### **👉 포함 기술**
- 클래스 및 객체, 생성자와 메서드 활용, 캡슐화
- 상속 및 다형성 (필요 시)
- 인터페이스와 제네릭스 활용
- `Map<String, List<Rental>>` 컬렉션 활용
- 날짜 관련 클래스 (`LocalDate`, `Period`) 활용

## 📄 예제
### **📚 반납 및 연체 조회 예시**
```plaintext
회원ID: LM001 -> 대여 도서: [Title1] (반납 기한: 2025-03-20) [Title2] (반납 기한: 2025-03-25)
연체 도서: [Title1] (연체일: 2일, 연체료: 1000원)
```

## ⚡ 미션 목표
이 미션은 회원별 도서 대여 및 반납 기능을 효과적으로 관리하는 것이 목표입니다. 연체 여부를 자동으로 확인하고, 연체료를 계산하는 기능을 추가해 보세요!

## 🔧 구현 가이드
1. `LibraryMember` 클래스를 정의하여 `private` 멤버 변수 (`name`, `membershipId`)를 선언하고, 생성자와 getter, `toString()`을 구현합니다.
2. `Rental` 클래스를 정의하여 도서 대여 정보를 저장합니다 (`Book book`, `LocalDate rentalDate`, `LocalDate returnDueDate`).
3. `RentalManager` 클래스를 정의하여 내부에 `Map<String, List<Rental>>` 컬렉션을 선언하고,
   - `rentBook(String memberId, Book book, LocalDate rentalDate, int rentalPeriod)` 메서드로 회원의 대여 목록에 도서를 추가합니다.
   - `returnBook(String memberId, String bookTitle)` 메서드로 회원이 책을 반납하는 기능을 구현합니다.
   - `checkOverdue(String memberId)` 메서드로 특정 회원의 연체 도서 목록과 연체료를 조회합니다.
4. `main()` 메서드에서 샘플 데이터를 이용하여 기능을 시연합니다.

---
🔧 **도전 과제:**
- 회원별 연체료 총합을 계산하는 기능을 추가해 보세요.
- 연체일이 길어질수록 연체료가 증가하는 로직을 구현해 보세요.
- 회원이 연체료를 납부할 수 있는 기능을 추가해 보세요.