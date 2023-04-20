package jpabook.model.entity.ex03_orphan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParentByOrphan {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // orphanRemoval : 고아 객체 제거 여부
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<ChildByOrphan> children = new ArrayList<ChildByOrphan>();

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

    public List<ChildByOrphan> getChildren() {
        return children;
    }

    public void setChildren(List<ChildByOrphan> children) {
        this.children = children;
    }
}
