package jpabook.model.entity.ex01_lazy;

import jpabook.model.entity.Team;
import jpabook.model.entity.ex01_eager.TeamByEager;

import javax.persistence.*;

@Entity
public class MemberByLazy {


    @Id
    @Column(name = "MEMBER_ID")
    private String username;

    // @JoinColumn nullable = false : null 값 허용하지 않음. 내부조인 사용
    // @JoinColumn nullable = true : null 값 허욤. 외부조인 사용
    // @ManyToOne optional = false : 내부조인 사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private TeamByLazy team;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TeamByLazy getTeam() {
        return team;
    }

    public void setTeam(TeamByLazy team) {
        this.team = team;
    }
}
