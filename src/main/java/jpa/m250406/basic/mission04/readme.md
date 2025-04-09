# 🔍 JPA 4단계 실습 - JPQL / QueryDSL 쿼리 최적화

이 단계에서는 JPA에서 복잡한 조회를 처리할 수 있는 **JPQL**, **QueryDSL**을 이용해 쿼리를 최적화하고, 실무에서 자주 쓰이는 **DTO 조회**, **정렬/조건/페이징** 기능을 실습합니다.

---

## ✅ 실습 환경

- Java 17+
- Spring Boot + JPA
- H2 / MySQL
- QueryDSL 설정 완료 (선택)
- 테스트 데이터를 적절히 미리 저장해 둘 것 (Team, Member 등)

---

## 📚 실습 과제

### 🟡 문제 1. JPQL 기본 조회

1. 모든 Member 엔티티를 조회하는 JPQL을 작성하세요.
2. 나이가 30 이상인 Member만 조회하도록 조건을 추가하세요.
3. 결과를 이름 기준으로 정렬하세요.

---

### 🟡 문제 2. DTO로 직접 조회 (JPQL)

1. Member의 이름과 팀 이름만 포함하는 DTO 클래스를 생성하세요.
2. `new 패키지명.DTO명(m.name, t.name)` 구문을 사용하여 JPQL로 DTO를 직접 조회하세요.

---

### 🟡 문제 3. 페이징 처리 (JPQL)

1. Member를 이름순으로 정렬하여 3개씩 페이지 단위로 조회하세요.
2. setFirstResult / setMaxResults를 사용해 2페이지를 가져오세요.

---

### 🟡 문제 4. QueryDSL로 조건 검색

1. QueryDSL을 사용하여 이름이 "홍길동"인 Member를 조회하세요.
2. 나이가 20 이상이고 팀 이름이 "팀A"인 멤버만 조회하도록 조건을 조합하세요.

---

### 🟡 문제 5. QueryDSL 정렬, 페이징

1. 이름을 기준으로 오름차순 정렬하고, 나이로 내림차순 2차 정렬을 하세요.
2. 페이징 기능으로 5명씩 끊어서 조회하세요.

---

### 🟡 문제 6. QueryDSL DTO 조회 (Projection)

1. `@QueryProjection` 또는 `Projections.constructor()`를 사용해 DTO로 조회하세요.
2. 이름, 나이, 팀 이름을 포함하는 MemberDTO를 정의하고 이를 반환하도록 작성하세요.

---

## 🎯 연습 체크리스트

| 항목                          | 완료 여부 |
|-------------------------------|------------|
| JPQL 기본 조회, 조건, 정렬 확인      | ✅ / ❌ |
| DTO로 직접 조회 (JPQL)             | ✅ / ❌ |
| JPQL 페이징 기능 실습               | ✅ / ❌ |
| QueryDSL 조건 검색 / 조합           | ✅ / ❌ |
| QueryDSL 정렬, 페이징              | ✅ / ❌ |
| QueryDSL DTO 프로젝션 사용         | ✅ / ❌ |

---

## 🧠 학습 포인트 요약

- JPQL은 SQL 유사 문법으로 객체 중심 쿼리 작성 가능
- DTO 직접 조회 시 new 구문 또는 QueryDSL 프로젝션 활용
- 페이징은 setFirstResult, setMaxResults로 구현
- QueryDSL은 타입 안정성, 조건 조합, 복잡 쿼리에 적합

---

Happy Querying! ✨📊

