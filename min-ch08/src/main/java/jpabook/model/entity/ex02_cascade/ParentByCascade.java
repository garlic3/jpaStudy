package jpabook.model.entity.ex02_cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParentByCascade {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // cascade 영속성 전이 사용
    // CascadeType.REMOVE : 부모 엔티티 삭제시 자식 엔티티도 삭제
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private List<ChildByCascade> children = new ArrayList<ChildByCascade>();


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

    public List<ChildByCascade> getChildren() {
        return children;
    }

    public void setChildren(List<ChildByCascade> children) {
        this.children = children;
    }
}
