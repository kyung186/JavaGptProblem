package oop.m250412.mission02;

import java.util.List;
import java.util.Scanner;

@FunctionalInterface
interface Calculator {
    int Operate(int a, int b);
}

public class Main {
    public static void main(String[] args) {

        /* 4️⃣ 주어진 문자열 리스트에서 4글자 이상인 단어만 대문자로 변환해 리스트로 반환하세요. */
        List<String> list = List.of("Java", "Code", "Ai", "Lambda", "Gpt");
        List<String> streamList = list.stream().filter(num -> num.length() >= 4)
                     .map(String::toUpperCase)
                     .toList();
        for (String str : streamList) {
            System.out.println(str);
        }

        /* 5️⃣ 숫자 리스트의 합계를 Stream과 reduce()를 이용해서 구하세요. */
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        /* 6️⃣ 다음 사용자 정의 함수형 인터페이스를 사용해 "곱셈" 계산기를 람다식으로 구현하세요. */
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int A = sc.nextInt();
        System.out.print("숫자 입력 : ");
        int B = sc.nextInt();
        Calculator cal = (a, b) -> a * b;
        System.out.println("곱하면? " + cal.Operate(A, B));
    }
}
