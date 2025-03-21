package oop.constaccess;

// 은행 계좌 객체
public class BankAccount {

    // 필드
    private String accountNumber; // 계좌번호
    private double balance; // 잔액

    // 생성자
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // 입금 기능
    public void deposit(double amount) {
        balance += amount;
    }

    // 출금 기능
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("잔액 부족");
            return;
        }

        balance -= amount;
    }

    // 잔액 반환
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
