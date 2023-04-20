package jpabook.model.entity.ex01_inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
// 자식테이블은 부모테이블의 ID 컬럼명을 그대로 사용한다. 변경하려면 지정
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends ItemWithJoin {

    private String author;
    private String isbn;

}
