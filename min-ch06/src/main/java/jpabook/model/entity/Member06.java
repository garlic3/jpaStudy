package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 다대다 연관관계
 * with Product
 */

@Entity
public class Member06 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String name;


    // @JoinTable : 연결 테이블 지정
    // oinColumns : 현재 방향인 회원과 매핑할 조인 컬럼 지정
    // inverseJoinColumns : 반대 방향인 상품과 매핑할 조인 컬럼 지정
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT", joinColumns = @JoinColumn(name = "MEMBER_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<Product>();

    // constructor
    public Member06() {;
    }

    public Member06(String id, String name) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // 연관관계 편의 메소드
    public void addProduct(Product product){
        products.add(product);
        product.getMembers().add(this);
    }
}
