package oop.abstractclass;

// 추상 클래스 Shape를 상속 받은 Rectangle 객체
public class Rectangle extends Shape {

    // 사각형 가로, 세로
    private double width;
    private double height;

    // Rectangle 생성자
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 추상 메서드 area() 오버라이딩
    @Override
    void area() {
        System.out.println("사각형의 넓이 : " + width * height);
    }
}
