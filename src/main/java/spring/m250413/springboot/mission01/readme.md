# 📘 Spring Boot 3단계 실습 - 고객 등록/조회 REST API

Spring Boot를 활용한 간단한 고객 정보 등록 및 조회 API 실습 프로젝트입니다.  
컨트롤러, 서비스, 리포지토리 계층을 분리하여 RESTful 구조로 구현되었습니다.

---

## ✅ 실습 목표

- Spring Boot 애플리케이션 구조 이해
- REST API 구현 (`@RestController`, `@GetMapping`, `@PostMapping`)
- 메모리 기반 저장소(`Map`) 사용
- 의존성 주입 및 계층 분리 실습

---

## 📦 프로젝트 구조
src/  
└── main/java/spring/m250413/springboot/mission/  
├── Application.java # 애플리케이션 실행 클래스  
├── Customer.java # 도메인 모델  
├── CustomerController.java # REST 컨트롤러  
├── CustomerService.java # 비즈니스 로직  
└── CustomerRepository.java # 메모리 저장소

---

## 🚀 실행 방법

1. 프로젝트 열기 (IntelliJ, VS Code 등)
2. `Application.java` 실행 (Spring Boot 로고가 뜨면 성공)
3. Postman 또는 브라우저로 API 테스트

---

## 📮 API 명세

### 📌 POST `/customers` - 고객 등록

- 요청 본문 (JSON):

```json
{
  "name": "홍길동",
  "email": "hong@example.com"
}
