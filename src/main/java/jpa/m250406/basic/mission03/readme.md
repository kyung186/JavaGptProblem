# 🚀 JPA 3단계 실습 - 프록시, 지연 로딩, N+1, Fetch Join

이번 실습은 JPA의 성능 최적화 핵심 주제인 **프록시**, **지연 로딩**, **N+1 문제**, **Fetch Join**을 실제 코드로 실험하면서 학습하는 데 목적이 있습니다.

---

## ✅ 실습 환경

- Java 17+
- Spring Boot + JPA 설정 완료
- H2 / MySQL 등 관계형 DB
- `spring.jpa.show-sql=true`, `hibernate.format_sql=true` 권장
- LAZY 전략을 명시하고 콘솔 로그로 쿼리 확인할 것

---

## 📚 실습 과제

### 🟡 문제 1. 프록시 객체 확인

1. Member와 Team을 저장한다.
2. 영속성 컨텍스트를 초기화한다.
3. Member를 조회한 뒤, `getTeam()` 호출 결과가 프록시인지 확인한다.
4. 실제 팀 이름을 출력하고, 쿼리가 언제 실행되는지 확인한다.

---

### 🟡 문제 2. `getReference()`로 프록시 직접 생성

1. Team을 하나 저장한다.
2. `em.clear()` 호출 후 `getReference()`를 사용하여 Team의 프록시 객체를 얻는다.
3. 클래스명과 초기화 여부(`Hibernate.isInitialized`)를 확인한다.
4. 필드 접근 시 쿼리가 발생하는지 확인한다.

---

### 🟡 문제 3. 지연 로딩과 N+1 문제 발생

1. Team 2개, Member 5명을 각각 팀에 소속되도록 저장한다.
2. `flush()` + `clear()` 이후 `SELECT m FROM Member m` 으로 모든 멤버 조회
3. 각 멤버의 팀 이름을 출력한다.
4. 발생한 쿼리 수를 확인하고, **N+1 문제가 발생했는지 분석한다**

---

### 🟡 문제 4. Fetch Join으로 N+1 문제 해결

1. JPQL로 `SELECT m FROM Member m JOIN FETCH m.team` 쿼리를 작성한다.
2. Fetch Join으로 Member와 Team을 한 번에 조회한다.
3. 쿼리 수와 반환된 결과를 비교하고, 프록시가 아닌 실제 객체가 들어왔는지 확인한다.

---

### 🟡 문제 5. 컬렉션 Fetch Join과 중복 문제

1. Team 1개에 Member 여러 명을 저장한다.
2. `SELECT t FROM Team t JOIN FETCH t.members` 로 팀을 조회한다.
3. 같은 팀이 여러 번 조회되는지 확인한다.
4. `DISTINCT` 키워드를 추가하고 결과 차이를 확인한다.

---

## 🎯 연습 체크리스트

| 항목                          | 완료 여부 |
|-------------------------------|------------|
| 프록시 객체 반환 확인               | ✅ / ❌ |
| getReference()로 프록시 생성 테스트   | ✅ / ❌ |
| 지연 로딩으로 인한 N+1 확인          | ✅ / ❌ |
| Fetch Join으로 N+1 해결            | ✅ / ❌ |
| 컬렉션 Fetch Join 중복 확인 및 DISTINCT | ✅ / ❌ |

---

## 🧠 학습 포인트 요약

- 프록시는 연관 객체 대신 가짜 객체로 성능 최적화
- 지연 로딩은 실제 필드 접근 시 DB 쿼리 실행
- N+1 문제는 지연 로딩 + 반복 조회로 발생
- Fetch Join은 이를 한 번의 쿼리로 해결 가능
- 컬렉션 Fetch Join은 중복주의 + DISTINCT 필요

---

Happy Query Optimization! 🎯🔥

