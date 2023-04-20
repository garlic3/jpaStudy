package jpabook.model.entity.ex01_Mapped;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
// 상속받은 id 속성의 컬럼명, name 속성의 컬럼명을 재정의
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "MEMBER_NAME"))

})
public class Member extends BaseEntity {

    // BaseEntity의 매핑정보를 상속받는다
    private String email;


}
