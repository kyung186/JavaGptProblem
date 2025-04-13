# 🧪 Java 실습 과제: 람다식 · Stream · 함수형 프로그래밍

자바 8의 핵심 기능인 **람다식(Lambda Expression)**, **Stream API**, 그리고 **함수형 프로그래밍(Functional Programming)** 개념을 실습 중심으로 익혀보세요!  
난이도는 `Level 1 ~ 3`, 그리고 보너스 미션까지 포함돼 있습니다.

---

## 📋 실습 주제 목록

- 람다식 기초 및 축약 문법
- 함수형 인터페이스 구현
- Stream API 기본 연산 및 고급 연산
- 고급 집계: `reduce()`, `collect()`, `groupingBy()`, `partitioningBy()`
- 실무에 가까운 보너스 미션!

---

## 🟢 Level 1 – 기초 문제

### 1. 문자열 리스트에서 각 문자열의 길이를 출력하세요.

```java
List<String> list = List.of("Java", "Spring", "GPT", "Lambda");
```

---

### 2. 아래 인터페이스를 람다식으로 구현하여 `Hello, 이름`을 출력하세요.

```java
@FunctionalInterface
interface StringPrinter {
    void print(String s);
}
```

---

### 3. 숫자 리스트에서 짝수만 필터링하여 출력하세요.

```java
List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
```

---

## 🟡 Level 2 – 중급 문제

### 4. 4글자 이상인 단어만 대문자로 변환하여 새로운 리스트로 수집하세요.

```java
List<String> names = List.of("java", "code", "ai", "lambda", "gpt");
```

---

### 5. 숫자 리스트의 합계를 `reduce()`를 사용하여 구하세요.

```java
List<Integer> nums = List.of(1, 2, 3, 4, 5);
```

---

### 6. 아래 인터페이스를 람다식으로 구현하여 `곱셈`을 수행하세요.

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}
```

---

## 🔴 Level 3 – 심화 문제

### 7. 다음 학생 리스트에서 평균 나이가 25세 이상인 학생의 이름을 출력하세요.

```java
class Student {
    String name;
    int age;
}
```

```java
List<Student> students = List.of(
    new Student("Alice", 23),
    new Student("Bob", 26),
    new Student("Charlie", 28)
);
```

---

### 8. 중복된 문자열을 제거하고, 길이가 5 이상인 문자열만 정렬하여 수집하세요.

```java
List<String> words = List.of("spring", "boot", "java", "lambda", "stream", "boot", "java");
```

---

### 9. 아래 리스트에서 홀수의 개수를 세어보세요.

```java
List<Integer> nums = List.of(3, 5, 7, 8, 10, 11, 13, 14);
```

---

### 10. 짝수만 골라 제곱한 뒤, 내림차순 정렬하여 처음 3개만 출력하세요.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```

---

## 🎁 보너스 미션 – 종합 실습

### 사용자 정보를 담은 객체 리스트에서 다음 요구사항을 구현하세요:

1. 20세 이상 사용자만 필터링
2. 성별로 그룹화
3. 각 그룹별 이름만 리스트로 추출
4. `UserFilter` 함수형 인터페이스 정의 및 사용

```java
class User {
    String name;
    int age;
    String gender;
}
```

```java
@FunctionalInterface
interface UserFilter {
    boolean filter(User user);
}
```

---

## 🔧 사용 기술 키워드

- `Lambda Expression`
- `@FunctionalInterface`
- `Stream`, `filter`, `map`, `reduce`, `collect`
- `groupingBy`, `partitioningBy`, `mapping`
- `Optional`, `Comparator`, `Function`, `Predicate`

---

## 💡 팁

- 코드를 직접 실행해보며 흐름을 이해하세요.
- `reduce()`와 `collect()`는 Stream의 **집계 핵심**입니다.
- 문제가 어렵다면 [GPTOnline.ai](https://gptonline.ai/ko/)에서 단계별 힌트를 확인하세요.

---

Happy Coding! 🧑‍💻
