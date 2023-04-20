package jpabook.model.entity.ex03_IdClass;

import javax.persistence.*;

@Entity
@IdClass(ChildIdById2.class)
public class ChildById2 {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public ParentById2 parent;

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    private String name;

    public ParentById2 getParent() {
        return parent;
    }

    public void setParent(ParentById2 parent) {
        this.parent = parent;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
