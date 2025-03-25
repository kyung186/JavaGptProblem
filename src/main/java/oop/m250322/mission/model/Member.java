package oop.m250322.mission.model;

public class Member {

    private String id;
    private String name;
    private String preferGenre;

    public Member(String id, String name, String preferGenre) {
        this.id = id;
        this.name = name;
        this.preferGenre = preferGenre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreferGenre() {
        return preferGenre;
    }
}
