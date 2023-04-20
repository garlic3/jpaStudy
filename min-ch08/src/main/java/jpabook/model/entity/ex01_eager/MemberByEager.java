package jpabook.model.entity.ex01_eager;

import jpabook.model.entity.Team;

import javax.persistence.*;

@Entity
public class MemberByEager {


    @Id
    @Column(name = "MEMBER_ID")
    private String username;

    // @JoinColumn nullable = false : null 값 허용하지 않음. 내부조인 사용
    // @JoinColumn nullable = true : null 값 허욤. 외부조인 사용
    // @ManyToOne optional = false : 내부조인 사용
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private TeamByEager team;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TeamByEager getTeam() {
        return team;
    }

    public void setTeam(TeamByEager team) {
        this.team = team;
    }
}
