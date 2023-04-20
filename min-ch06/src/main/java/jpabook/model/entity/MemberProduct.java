package jpabook.model.entity;

import javax.persistence.*;

/*
    다대일 연관관계
    with Member07
    다대일 연관관계
    with Product
 */
@Entity
@IdClass(MemberProductId.class)
// 복합 기본키 매핑
// JPA에서 복합키를 사용하려면 식별자 클래스를 만들어야 한다
// 식별자 클래스(Serialize 구현, equals(), hashCode() 재정의, 기본 생성자, public)
public class MemberProduct {

    // 부모 테이블의 기본키를 자신의 기본키 + 외래키로 사용하는것 -> 식별관계
    // MemberProductId.member07와 연결
    @Id
    @ManyToOne()
    @JoinColumn(name = "MEMBER_ID")
    private Member07 member07;

    // MemberProductId.product와 연결
    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product02 product02;

    private int orderAmount;

    public MemberProduct() {
    }

    public Member07 getMember07() {
        return member07;
    }

    public void setMember07(Member07 member07) {
        this.member07 = member07;
    }

    public Product02 getProduct02() {
        return product02;
    }

    public void setProduct02(Product02 product02) {
        this.product02 = product02;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
