package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    일대다 단방향 연관관계
    with Team03
 */
@Entity
public class Team03 {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    // 일대다 단방향 연관관계 설정
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member03> members = new ArrayList<Member03>();


    // constructor
    public Team03() {

    }

    public Team03(String name) {
        this.name = name;
    }


    // getter, setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member03> getMembers() {
        return members;
    }

    public void setMembers(List<Member03> members) {
        this.members = members;
    }
}
