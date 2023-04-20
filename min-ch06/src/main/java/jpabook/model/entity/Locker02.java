package jpabook.model.entity;

import javax.persistence.*;

/*
    일대일 양방향 연관관계
    with Member05
    연관관계 주인
 */
@Entity
public class Locker02 {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;


    // 일대일 양방향 연관관계 설정
    // 대상 테이블에 외래키를 둔다
    // 연관관계의 주인
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member05 member05;

    // constructor
    public Locker02() {
    }

    public Locker02(String name) {
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

    public Member05 getMember04() {
        return member05;
    }

    public void setMember04(Member05 member05) {
        this.member05 = member05;
    }
}
