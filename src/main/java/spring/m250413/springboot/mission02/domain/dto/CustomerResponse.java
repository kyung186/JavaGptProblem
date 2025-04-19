package spring.m250413.springboot.mission02.domain.dto;

import java.time.LocalDate;

public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;

    public CustomerResponse(Long id, String name, String email, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
