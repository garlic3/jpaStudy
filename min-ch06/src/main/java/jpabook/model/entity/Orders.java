package jpabook.model.entity;

import javax.persistence.*;


/*
    다대일 연관관계
    with Member08
    다대일 연관관계
    with Product03
    기본키 생성 전략 : 대리키 사용
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member08 member08;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product03 product03;

    private int orderAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member08 getMember08() {
        return member08;
    }

    public void setMember08(Member08 member08) {
        this.member08 = member08;
    }

    public Product03 getProduct03() {
        return product03;
    }

    public void setProduct03(Product03 product03) {
        this.product03 = product03;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
