package jpa.m250406.basic.mission04.dto;

public class NameDTO {

    private String memberName;
    private String teamName;

    public NameDTO(String memberName, String teamName) {
        this.memberName = memberName;
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "NameDTO{" +
                "memberName='" + memberName + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
