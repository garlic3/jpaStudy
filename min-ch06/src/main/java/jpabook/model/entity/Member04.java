package jpabook.model.entity;

import javax.persistence.*;

/*
 * 일대일 양방향 연관관계
 * with Locker
 * 연관관계 주인
 */

@Entity
public class Member04 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    // constructor
    public Member04() {;
    }

    public Member04(String username) {
        this.username = username;
    }

    // getter, setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}
