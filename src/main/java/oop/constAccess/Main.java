package oop.constAccess;

// 메인 클래스
public class Main {
    public static void main(String[] args) {

        // 은행 계좌 객체 선언
        BankAccount ba = new BankAccount("12345-67890", 10000);

        // 메서드 호출
        ba.deposit(5000);
        ba.withdraw(20000);
        ba.withdraw(3000);
        System.out.println("계좌 번호 : " +ba.getAccountNumber());
        System.out.println("현재 잔액 : " + ba.getBalance());
    }
}
