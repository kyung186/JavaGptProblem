package oop.m250412.mission01;

import java.util.List;
import java.util.Scanner;

@FunctionalInterface
interface StringPrinter {
    void print(String s);
}

public class Main {
    public static void main(String[] args) {

        /* 1️⃣ 문자열 리스트를 받아 모든 문자열의 길이를 출력하세요. */
        List<String> list = List.of("Java", "Spring", "GPT", "Lambda");
        list.forEach(len -> System.out.println(len + "의 길이 : " + len.length()));

        /* 2️⃣ 다음 인터페이스를 람다식으로 구현하세요. */
//        Scanner sc = new Scanner(System.in);
//        System.out.print("\n이름을 입력하세요. : ");
//        String name = sc.nextLine();
//        StringPrinter sp = s -> System.out.println("Hello, " + s);
//        sp.print(name);

        /* 3️⃣ 숫자 리스트에서 짝수만 필터링하고 출력하세요. */
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().filter(num -> num % 2 == 0)
                     .forEach(System.out::println);
    }
}
