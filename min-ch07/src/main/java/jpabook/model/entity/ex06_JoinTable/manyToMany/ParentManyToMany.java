package jpabook.model.entity.ex06_JoinTable.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParentManyToMany {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "PARENT_CHILD", joinColumns = @JoinColumn(name = "PARENT_ID"), inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private List<ChildManyToMany> child = new ArrayList<ChildManyToMany>();

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

    public List<ChildManyToMany> getChild() {
        return child;
    }

    public void setChild(List<ChildManyToMany> child) {
        this.child = child;
    }
}
