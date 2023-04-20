package jpabook.model.entity;

import javax.persistence.*;

/*
    일대다 단방향 연관관계
    with Team03
 */
@Entity
public class Member03 {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String userName;

    // constructor

    public Member03(String userName) {
        this.userName = userName;
    }

    public Member03() {
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

}
