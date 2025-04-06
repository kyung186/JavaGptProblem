# 🧱 JPA 1단계 실습 문제 - 기본 문법

이 실습은 JPA의 가장 기본적인 기능들을 직접 구현하며 익히는 데 목적이 있습니다.  
**엔티티 매핑, CRUD, JPQL** 등 JPA의 필수 개념을 단계적으로 연습할 수 있습니다.

---

## ✅ 환경 설정

- Java 17+
- Spring Boot (또는 순수 Java 프로젝트)
- H2 / MySQL 등 관계형 DB
- JPA 설정 완료 상태 (`spring.jpa.hibernate.ddl-auto=update`)

---

## 📚 실습 과제

### 🟡 문제 1. User 엔티티 만들기

다음 조건에 맞는 `User` 엔티티를 작성하세요.

- 테이블 이름: `users`
- 필드:
    - `id` (Long, PK, auto)
    - `username` (String, not null)
    - `age` (int)
    - `email` (String, unique)
- 기본 생성자 필수
- getter/setter 작성

---

### 🟡 문제 2. EntityManager로 저장

`User` 객체를 생성하여 DB에 저장하세요.

- username: `"jpaUser"`
- age: `25`
- email: `"jpa@user.com"`

---

### 🟡 문제 3. ID로 조회

`User`의 ID 값을 이용해 해당 사용자 정보를 조회하고,  
`username`, `email`을 출력해보세요.

---

### 🟡 문제 4. 전체 유저 목록 조회 (JPQL)

JPQL을 사용하여 전체 사용자 목록을 가져오고,  
각 사용자의 `username`을 출력하세요.

---

### 🟡 문제 5. 조건 조회 (JPQL)

나이가 20 이상인 사용자만 조회하고,  
이름과 나이를 출력하세요.

---

### 🟡 문제 6. 수정 및 삭제

1. 이메일이 `"jpa@user.com"`인 사용자를 조회하세요.
2. 해당 사용자의 이름을 `"updatedUser"`로 수정하세요.
3. 변경한 사용자를 삭제하세요.

---

### 🎯 보너스 과제

`@Column`의 속성을 사용해 다음 조건을 실습하세요:

- `nullable = false`
- `length = 50`
- `unique = true`

💡 테이블 생성된 구조를 DB에서 확인해보세요.

---

## 🧠 학습 목표 요약

| 항목                     | 설명 |
|--------------------------|------|
| 엔티티 매핑 (`@Entity`, `@Id`) | 객체와 테이블 매핑 방법 이해 |
| EntityManager 활용          | 저장, 조회, 삭제 |
| JPQL 사용법 익히기         | 조건 조회, 전체 조회 |
| 트랜잭션 제어 이해         | `begin()` → `commit()` 흐름 |
| 삭제 시 `remove()` 위치 이해 | 영속 상태에서만 호출 가능 |

---

## 🚀 다음 단계

이 실습을 완료한 후에는 다음으로 진행해보세요:

- **양방향 연관관계 매핑 실습**
- **지연 로딩과 프록시 실습**
- **N+1 문제 발생 실험 및 해결 방법**

---

Happy Coding! 💻🔥
