package jpabook.model.entity;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
 * 단방향 연관관계
 */

@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    // 양방향 연관관계 설정
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();


    // constructor
    public Team() {
        ;
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter, setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 양방향 연관관계 설정
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
