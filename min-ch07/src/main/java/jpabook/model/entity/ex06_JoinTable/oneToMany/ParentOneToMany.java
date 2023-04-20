package jpabook.model.entity.ex06_JoinTable.oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    일대다 조인 테이블 매핑
    다와 관련된 컬럼에 유니크 제약조건을 걸어야 한다
    Parent : OneToMany
    Child : ManyToOne
 */
@Entity
public class ParentOneToMany {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    // name : 매핑할 조인 테이블 이름
    // joinColumns : 현재 엔티티를 참조하는 외래키
    // inverseJoinColumns : 반대방향 엔티티를 참조하는 외래키
    @OneToMany
    @JoinTable(name = "PARENT_CHILD",
    joinColumns = @JoinColumn(name = "PARENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private List<ChildOneToMany> child = new ArrayList<ChildOneToMany>();


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

    public List<ChildOneToMany> getChild() {
        return child;
    }

    public void setChild(List<ChildOneToMany> child) {
        this.child = child;
    }
}
