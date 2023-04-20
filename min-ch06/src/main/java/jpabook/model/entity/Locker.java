package jpabook.model.entity;

import javax.persistence.*;

/*
    일대일 양방향 연관관계
    with Member04
 */
@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    // MEMBER 테이블에 외래키가 존재하므로
    // Member.locker가 연관관계의 주인이다
    // 연관관계 주인이 아니므로 mappedBy 사용
    @OneToOne(mappedBy = "locker")
    private Member04 member04;

    // constructor
    public Locker() {
    }

    public Locker(String name) {
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

    public Member04 getMember04() {
        return member04;
    }

    public void setMember04(Member04 member04) {
        this.member04 = member04;
    }
}
