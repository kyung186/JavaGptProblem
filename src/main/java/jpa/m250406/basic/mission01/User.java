package jpa.m250406.basic.mission01;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    private int age;

    @Column(unique = true)
    private String email;

    public User() {} // JPA는 기본 생성자 필수

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
