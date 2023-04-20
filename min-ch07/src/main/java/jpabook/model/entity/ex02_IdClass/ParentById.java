package jpabook.model.entity.ex02_IdClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ParentIdById.class)
public class ParentById {

    // ParentId.id1 과 연결
    @Id
    @Column(name = "PARENT_ID1")
    private String id1;

    // ParentId.id2 과 연결
    @Id
    @Column(name = "PARENT_ID2")
    private String id2;

    private String name;

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
