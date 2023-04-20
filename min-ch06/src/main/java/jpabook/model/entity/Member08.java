package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/*
 * 일대다 연관관계
 * with Order
 */

@Entity
public class Member08 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "member08")
    private List<Orders> orders = new ArrayList<Orders>();

    // constructor
    public Member08() {;
    }

    public Member08(String id, String name) {
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


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
