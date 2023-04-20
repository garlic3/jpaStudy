package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 일대다 연관관계
 * with MemberProduct
 */

@Entity
public class Member07 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "member07")
    private List<MemberProduct> memberProducts;

    // constructor
    public Member07() {;
    }

    public Member07(String id, String name) {
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

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }

}
