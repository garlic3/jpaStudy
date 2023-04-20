package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
    일대다 연관관계
    with Order
 */
@Entity
public class Product03 {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;


    // constructor
    public Product03() {
    }

    public Product03(String id, String name) {
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

}
