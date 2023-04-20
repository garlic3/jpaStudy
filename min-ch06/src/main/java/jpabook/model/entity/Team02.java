package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    일대다 양방향 연관관계
    with Member02
 */
@Entity
public class Team02 {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    // 일대다 양방향 연관관계 설정
    @OneToMany(mappedBy = "team")
    private List<Member02> members = new ArrayList<Member02>();


    // constructor
    public Team02() {

    }

    public Team02(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public void addMember(Member02 member){
        this.members.add(member);
        // 무한 루프에 빠지지 않도록 체크
        if(member.getTeam() != this){
            member.setTeam(this);
        }
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

    public List<Member02> getMembers() {
        return members;
    }

    public void setMembers(List<Member02> members) {
        this.members = members;
    }
}
