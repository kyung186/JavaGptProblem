package jpa.m250406.basic.mission05.model;

import jakarta.persistence.*;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String tag;

    public Tag() {}

    public Tag(String tag) {
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }
}
