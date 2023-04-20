package jpabook.model.entity.ex02_cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChildByCascade {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private ParentByCascade parent;


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

    public ParentByCascade getParent() {
        return parent;
    }

    public void setParent(ParentByCascade parent) {
        this.parent = parent;
    }
}
