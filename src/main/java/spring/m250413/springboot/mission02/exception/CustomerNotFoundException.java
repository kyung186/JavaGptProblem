package spring.m250413.springboot.mission02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("고객을 찾을 수 없습니다. ID : " + id);
    }
}
