package oop.abstractclass;

public class Main {
    public static void main(String[] args) {

        // Circle, Rectangle 객체 선언
        Circle circle = new Circle(1.0);
        Rectangle rectangle = new Rectangle(2.0, 3.0);

        // Circle, Rectangle 객체 메서드 선언
        circle.area();
        rectangle.area();
    }
}
