# 🛠️ JPA 5단계 실습 - 실무 기능 (고급 매핑과 관리 기능)

이번 단계에서는 JPA의 고급 기능인 **Cascade**, **orphanRemoval**, **고아 객체 처리**, **엔티티 상태 변경 감지**, 그리고 **벌크 연산** 및 **EntityGraph** 등을 실습합니다. 이 기능들은 실무에서 JPA를 안전하고 효율적으로 사용하기 위해 필수적으로 알아야 합니다.

---

## ✅ 실습 환경

- Java 17+
- Spring Boot + JPA
- H2 / MySQL
- 실습 도메인 예시: `User`, `Post`, `Comment`, `Tag`, `PostTag`

---

## 📚 실습 과제

### 🟡 문제 1. CascadeType 적용

1. `Post`와 `Comment`의 연관관계를 설정하세요 (Post → Comment: 1:N).
2. `CascadeType.PERSIST`를 설정한 뒤, Post 하나에 여러 Comment를 설정 후, Post만 persist 하세요.
3. 모든 데이터가 잘 저장되는지 확인하세요.

---

### 🟡 문제 2. orphanRemoval 적용

1. 위 관계에서 `orphanRemoval = true`를 설정합니다.
2. Post에서 특정 Comment를 `comments.remove(...)`로 제거하고 flush 해보세요.
3. 해당 Comment가 DB에서 삭제되는지 확인하세요.

---

### 🟡 문제 3. 고아 객체 삭제와 연관관계 관리

1. Post를 삭제할 경우 연관된 Comment도 함께 삭제되도록 설정하세요.
2. `CascadeType.REMOVE`를 테스트하고, DB 쿼리 결과를 확인하세요.

---

### 🟡 문제 4. Entity 상태 변경 감지 (Dirty Checking)

1. 엔티티를 조회한 뒤, 필드 값을 변경하고 `flush()`만 호출하세요.
2. 별도 `save()`나 `merge()` 없이 UPDATE 쿼리가 나가는지 확인하세요.

---

### 🟡 문제 5. 벌크 연산

1. JPQL로 `UPDATE Post p SET p.title = '제목 없음'`을 실행하세요.
2. 영속성 컨텍스트 내 객체의 값과 DB의 값이 다른 상태가 되는지 확인하세요.
3. 벌크 연산 후 `em.clear()`의 필요성을 실험하세요.

---

### 🟡 문제 6. EntityGraph를 활용한 fetch 전략 최적화

1. `User` → `Post` 관계에서 N+1 문제가 발생하도록 테스트하세요.
2. `@EntityGraph`를 이용하여 함께 로딩되도록 설정하고 쿼리를 비교하세요.

---

## 🎯 연습 체크리스트

| 항목                           | 완료 여부 |
|--------------------------------|------------|
| Cascade를 이용한 연관 엔티티 저장       | ✅ / ❌ |
| orphanRemoval로 연관 객체 자동 삭제    | ✅ / ❌ |
| CascadeType.REMOVE로 함께 삭제        | ✅ / ❌ |
| Dirty Checking으로 상태 변경 반영      | ✅ / ❌ |
| 벌크 연산 후 영속성 컨텍스트 확인       | ✅ / ❌ |
| EntityGraph로 N+1 문제 해결            | ✅ / ❌ |

---

## 🧠 학습 포인트 요약

- Cascade를 사용하면 연관된 엔티티도 함께 저장/삭제할 수 있음
- orphanRemoval은 부모에서 제거 시 자식 자동 삭제
- flush만으로 변경 감지가 동작 → dirty checking
- 벌크 연산은 영속성 컨텍스트 무시 → 주의 필요
- EntityGraph는 지연 로딩 문제를 해결하는 실무형 도구

---

Happy Advanced JPA! 💼⚙️

