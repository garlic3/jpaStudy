package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/*
    다대다 양방향 연관관계
    with Member06

 */
@Entity
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    // 다대다 양방향 연관관계 설정
    @ManyToMany(mappedBy = "products")
    private List<Member06> members;


    // constructor
    public Product() {
    }

    public Product(String id, String name) {
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

    public List<Member06> getMembers() {
        return members;
    }

    public void setMembers(List<Member06> members) {
        this.members = members;
    }


}
