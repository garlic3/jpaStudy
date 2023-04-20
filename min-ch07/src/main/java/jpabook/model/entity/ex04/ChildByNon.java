package jpabook.model.entity.ex04;

import javax.persistence.*;

@Entity
public class ChildByNon {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ParentByNon parentByNon;

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

    public ParentByNon getParent() {
        return parentByNon;
    }

    public void setParent(ParentByNon parentByNon) {
        this.parentByNon = parentByNon;
    }
}
