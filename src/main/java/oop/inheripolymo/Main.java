package oop.inheripolymo;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        Animal animalDog = new Dog();
        Animal animalCat = new Cat();

        animal.makeSound(); // 동물이 소리를 냅니다.
        animalDog.makeSound(); // 멍멍
        animalCat.makeSound(); // 야옹
        dog.makeSound(); // 멍멍
        cat.makeSound(); // 야옹
    }
}
