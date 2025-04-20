package spring.m250413.springboot.mission02.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super("중복된 이메일입니다. : " + email);
    }
}