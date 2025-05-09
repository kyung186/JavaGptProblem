# 📖 미션 : 도서 추천 시스템 구현

## ✨ 개요
회원의 선호 장르를 기반으로 도서를 추천하는 시스템을 구현합니다. 도서 목록을 관리하고, 회원에게 적절한 장르의 도서를 추천해줍니다.

## 🔍 요구사항
### **👉 입력**
- 회원 정보 (`Member` 객체): 회원 ID, 이름, 선호 장르
- 도서 정보 (`Book` 객체): 제목, 저자, 장르
- 도서 목록 (`List<Book>`)

### **👉 기능**
1. 회원의 선호 장르를 기반으로 도서를 추천하는 기능
2. 특정 장르의 도서 목록을 조회하는 기능
3. 추천 도서를 문자열로 반환

### **👉 포함 기술**
- 클래스 및 객체, 생성자와 메서드 활용, 캡슐화
- 상속 및 다평성 (필요시)
- 인터페이스와 제네릭 활용
- `Map<String, List<Book>>`, `List` 활용

## 📄 예제
### **📖 도서 추천 예시**
```plaintext
회원ID: LM001 님을 위한 추천 도서: [Title1] (Fantasy), [Title2] (Fantasy)
```

### **📖 장르 도서 조회 예시**
```plaintext
[Science Fiction] 장르의 도서 목록: [Title3], [Title4]
```

## ⚡ 미션 목표
회원의 개인 선호를 반영하여 추천하는 기능을 구현합니다. 컨텐츠 기법을 이용하여 신축된 도서 데이터를 관리하고, 객체지형 구조를 통해 이벤트를 합니다.

## 🔧 구현 가이드
1. `Member` 클래스에서 `memberId`, `name`, `preferredGenre` 필드를 구현하고 생성자/ getter 메서드 구현
2. `Book` 클래스에서 `title`, `author`, `genre` 필드 구현
3. `RecommendationService` 클래스 구현
    - `recommendBooks(String memberId)` : 회원의 선호 장르에 맞는 도서를 검색하여 추천 도서 목록 반환
    - `getBooksByGenre(String genre)` : 특정 장르의 도서 목록을 반환
4. `main()` 메서드에서 샘플 데이터를 이용해 기능 시연

---
🔧 **도전 과제:**
- 여러 가지 장르를 선호하는 회원을 고려해 도서 추천를 포함해 보세요.
- 특정 도서가 없을 경우 단일 인기 장르의 도서를 받아가 추천하는 기능을 구현해 보세요.