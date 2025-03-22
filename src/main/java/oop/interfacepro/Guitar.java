package oop.interfacepro;

public class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("기타를 연주합니다.");
    }
}
