package jpabook.model.entity;

import javax.persistence.*;

/*
 * 일대일 양방향 연관관계
 * with Locker02
 */

@Entity
public class Member05 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @OneToOne(mappedBy = "member05")
    private Locker02 locker02;

    // constructor
    public Member05() {;
    }

    public Member05(String username) {
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

    public Locker02 getLocker02() {
        return locker02;
    }

    public void setLocker02(Locker02 locker02) {
        this.locker02 = locker02;
    }
}
