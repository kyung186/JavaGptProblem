package oop.interfacepro;

public class Piano implements Playable {

    @Override
    public void play() {
        System.out.println("피아노를 연주합니다.");
    }
}
