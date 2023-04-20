package jpabook.model.entity.ex01_Mapped;

import javax.persistence.Entity;

@Entity
public class Seller extends BaseEntity {

    // BaseEntity의 매핑정보를 상속받는다

    private String shopName;

}
