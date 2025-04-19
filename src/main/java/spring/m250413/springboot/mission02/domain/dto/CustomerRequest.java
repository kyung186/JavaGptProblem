package spring.m250413.springboot.mission02.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank(message = "이름은 필수 입력입니다.")
    String name;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력입니다.")
    String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
