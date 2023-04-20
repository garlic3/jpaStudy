package jpabook.model.entity.ex01_inheritance;

import javax.persistence.*;

@Entity
// 상속 매핑과 매핑 전략 조인전략으로 사용
@Inheritance(strategy = InheritanceType.JOINED)
// 부모 클래스에 구분 컬럼 지정. 이 컬럼으로 저장된 자식테이블을 구분한다
@DiscriminatorColumn(name = "DTYPE")
public abstract  class ItemWithJoin {

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
