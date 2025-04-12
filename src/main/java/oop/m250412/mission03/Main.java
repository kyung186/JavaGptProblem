package oop.m250412.mission03;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* 7️⃣ 학생 리스트에서 평균 나이가 25세 이상인 학생들만 이름을 출력하세요. */
        List<Student> students = List.of(
                new Student("Alice", 23),
                new Student("Bob", 26),
                new Student("Charlie", 28)
        );
        students.stream().filter(student -> student.getAge() >= 25)
                .forEach(student -> System.out.println(student.getName()));

        /* 8️⃣ 아래 리스트에서 중복 없이, 길이가 4 이하인 문자열만 정렬하여 수집하세요. */
        List<String> words = List.of("spring", "boot", "java", "lambda", "stream", "boot", "java");
        words.stream().filter(word -> word.length() <= 5)
                      .distinct()
                      .forEach(System.out::println);

        /* 9️⃣ 숫자 리스트에서 홀수의 개수가 몇 개인지 세어보세요. (조건 검사 + count) */
        List<Integer> nums = List.of(3, 5, 7, 8, 10, 11, 13, 14);
        long cnt = nums.stream().filter(num -> num % 2 == 1)
                                .count();
        System.out.println(cnt);

        /* 1️⃣ ️0️⃣ 함수형 프로그래밍 스타일로 다음을 구현해보세요. */
        /* 짝수만 골라서
        제곱한 후
        내림차순 정렬해서
        처음 3개만 출력 */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(num -> num % 2 == 0)
                        .map(num -> num * num)
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .forEach(System.out::println);
    }
}
