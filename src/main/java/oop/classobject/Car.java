package oop.classobject;

// car 객체
public class Car {

    // 속도 최대
    private static final int MAX_SPEED = 200;

    // 필드 brand, speed
    private String brand;
    private int speed;

    // car 생성자
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // 속도 증가
    public void accelerate(int amount) {
        if (amount < 0) {
            System.out.println("가속 값은 음수가 될 수 없습니다.");
            return;
        }
        speed = Math.min(speed + amount, MAX_SPEED);
    }

    // 속도 감소
    public void brake(int amount) {
        if (amount < 0) {
            System.out.println("감속 값은 음수가 될 수 없습니다.");
            return;
        }
        speed = Math.max(speed - amount, 0);
    }

    // 출력
    public void displayInfo() {
        System.out.println("====================");
        System.out.println("🚗 자동차 정보");
        System.out.println("브랜드: " + brand);
        System.out.println("현재 속도: " + speed + " km/h");
        System.out.println("====================");
    }
}
