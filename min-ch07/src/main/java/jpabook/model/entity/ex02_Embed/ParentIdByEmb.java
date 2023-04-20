package jpabook.model.entity.ex02_Embed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
    1. 식별자 클래스의 속성명과 엔티티에서 사용하는 식별자의 속성명이 같아야한다
    2. Serializable 구현
    3. hashCode(), equals() 재저으이
    4. 기본 생성자
    5. 클래스 접근 제한자 public
 */

@Embeddable
public class ParentIdByEmb implements Serializable {

    // 기본키를 직접 매핑
    @Column(name = "PARENT_ID1")
    private String id1;
    @Column(name = "PARENT_ID2")
    private String id2;

    // constructor
    public ParentIdByEmb() {

    }

    public ParentIdByEmb(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    // equals(), hashCode() 재정의

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentIdByEmb that = (ParentIdByEmb) o;

        if (id1 != null ? !id1.equals(that.id1) : that.id1 != null) return false;
        return id2 != null ? id2.equals(that.id2) : that.id2 == null;
    }

    @Override
    public int hashCode() {
        int result = id1 != null ? id1.hashCode() : 0;
        result = 31 * result + (id2 != null ? id2.hashCode() : 0);
        return result;
    }

    // getter, setter


}
