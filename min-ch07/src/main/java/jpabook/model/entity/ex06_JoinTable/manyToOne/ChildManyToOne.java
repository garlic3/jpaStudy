package jpabook.model.entity.ex06_JoinTable.manyToOne;

import javax.persistence.*;

@Entity
public class ChildManyToOne {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    @ManyToOne(optional = false)
    @JoinTable(name = "PARENT_CHILD"
            , joinColumns = @JoinColumn(name = "CHILD_ID")
            , inverseJoinColumns = @JoinColumn(name = "PARENT_ID"))
    private ParentManyToOne parent;

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
}
