package jpabook.model.entity.ex03_IdClass;

import javax.persistence.*;

@Entity
@IdClass(GrandChildIdById.class)
public class GrandChildById {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private ChildById2 child;
    @Id
    @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;

    public ChildById2 getChild() {
        return child;
    }

    public void setChild(ChildById2 child) {
        this.child = child;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
