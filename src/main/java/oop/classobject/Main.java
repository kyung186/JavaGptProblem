package oop.classobject;

// 메인 클래스
public class Main {
    public static void main(String[] args) {

        // Car 객체 선언
        Car car = new Car("현대", 10);

        // Car 메서드 선언
        car.accelerate(10);
        car.brake(-30);
        car.brake(5);
        car.displayInfo();
    }
}
