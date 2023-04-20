package jpabook.model.entity.ex06_JoinTable.manyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    다대일 조인 테이블 매핑
    Parent : oneToMany
    Child : ManyToOne

 */
@Entity
public class ParentManyToOne {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parent")
    private List<ChildManyToOne> child = new ArrayList<ChildManyToOne>();

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

    public List<ChildManyToOne> getChild() {
        return child;
    }

    public void setChild(List<ChildManyToOne> child) {
        this.child = child;
    }
}
