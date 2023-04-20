package jpabook.model.entity.ex01_inheritance;

import javax.persistence.*;

/*
    단일 테이블 전략 사용
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 부모 클래스에 구분 컬럼 지정. 이 컬럼으로 저장된 자식테이블을 구분한다
@DiscriminatorColumn(name = "DTYPE")
public abstract  class ItemWithSingle {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
