# 🌱 Spring Core 실습 예제

Spring Framework의 핵심 개념인 **의존성 주입(DI)**, **Bean 등록**, **라이프사이클**, **스코프** 등을 실습하며 학습합니다.

---

## 📁 프로젝트 구조
src/  
└── main/java/com/example/core/  
├── Customer.java  
├── CustomerRepository.java  
├── CustomerService.java  
├── AppConfig.java  
└── CoreApplication.java


---

## ✅ 실습 목표

### 1. 의존성 주입(DI) 구현
- `CustomerService`가 `CustomerRepository`에 의존하도록 구현
- 생성자 주입 방식 사용

### 2. Bean 등록 방식 실습
- `@Component` 기반 자동 등록
- `@Configuration + @Bean` 기반 수동 등록

### 3. 스코프 실습
- Singleton(default) vs Prototype
- `@Scope("prototype")` 적용 후 인스턴스 비교

### 4. Bean 생명주기
- `@PostConstruct`, `@PreDestroy` 활용

---

## 🗃️ Customer 테이블 쿼리 (MySQL 기준)

```sql
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
