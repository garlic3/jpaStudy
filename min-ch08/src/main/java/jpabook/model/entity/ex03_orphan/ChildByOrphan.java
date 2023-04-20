package jpabook.model.entity.ex03_orphan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChildByOrphan {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private ParentByOrphan parent;


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

    public ParentByOrphan getParent() {
        return parent;
    }

    public void setParent(ParentByOrphan parent) {
        this.parent = parent;
    }
}
