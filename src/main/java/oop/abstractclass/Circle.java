package oop.abstractclass;

// 추상 클래스 Shape를 상속 받은 Circle 객체
public class Circle extends Shape {

    // 반지름 길이
    private double radius;

    // Circle 생성자
    public Circle(double radius) {
        this.radius = radius;
    }

    // 추상 메서드 area() 오버라이딩
    @Override
    void area() {
        System.out.println("원의 넓이 : " + radius * radius * Math.PI);
    }
}
