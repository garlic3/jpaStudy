package jpabook.model.entity;

import javax.persistence.*;

/*
    다대일 양방향 연관관계
    with Team02
 */
@Entity
public class Member02 {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String userName;

    // 다대일 연관관계 양방향 연관관계 설정
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team02 team;

    // constructor

    public Member02(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Member02() {
    }

    // getter, setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team02 getTeam() {
        return team;
    }

    public void setTeam(Team02 team) {
        this.team = team;
        // 무한 루프에 빠지지 않도록 체크
        if(!team.getMembers().contains(this)){
            team.getMembers().add(this);
        }

    }
}
