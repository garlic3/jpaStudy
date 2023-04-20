package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 단방향 연관관계
 */

@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String name;

    // 다대일 연관 관계 매핑
    // Member.team 으로 팀 엔티티를 참조한다(FK TEAM_ID 관리)
    // 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    // constructor
    public Member() {;
    }

    public Member(String id, String name) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        // 기존 팀과 연관관계를 제거
        if(this.team != null){
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);

    }


}
