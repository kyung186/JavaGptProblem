# 📘 Spring Boot 3단계 실습 - JPA + MySQL을 활용한 고객 REST API

Spring Boot + JPA + MySQL을 활용한 고객 등록 및 조회 실습 프로젝트입니다.  
Controller → Service → Repository → DB 흐름을 이해하고, 실전처럼 DB에 저장하는 구조를 익히는 것이 목표입니다.

---

## ✅ 실습 목표

- Spring Boot 기반 프로젝트 구성
- Spring Data JPA를 이용한 데이터 저장/조회
- REST API 설계 (`@RestController`, `@PostMapping`, `@GetMapping`)
- MySQL 연동 및 데이터 영속화

---

## 📦 프로젝트 구조

src/ 

└── main/java/com/example/jpademo/
├── entity/  
│ └── Customer.java  
├── repository/  
│ └── CustomerRepository.java  
├── service/  
│ └── CustomerService.java  
├── controller/  
│ └── CustomerController.java  
└── Application.java

---

## 📮 API 명세

| 기능 | URL | 메서드 | 설명 |
|------|-----|--------|------|
| 고객 등록 | `/customers` | POST | 고객 정보 DB에 저장 |
| 고객 조회 | `/customers/{id}` | GET | 단건 조회 |
| 전체 조회 | `/customers` | GET | 전체 고객 목록 반환 |

---

## 📘 Entity - `Customer.java`

- 필드: id, name, email, createdAt
- `@Entity` 어노테이션 필수
- `@GeneratedValue`로 id 자동 생성

---

## 💾 application.properties 설정

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpademo?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## 💡 보너스 과제 (선택)
- 이메일 중복 검사 기능 추가 (/customers/email-check)  
- @ResponseStatus, @ExceptionHandler로 에러 처리 연습  
- 고객 삭제/수정 API 추가