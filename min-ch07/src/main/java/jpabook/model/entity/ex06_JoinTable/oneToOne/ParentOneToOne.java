package jpabook.model.entity.ex06_JoinTable.oneToOne;

import javax.persistence.*;

/*
    일대일 조인 테이블 매핑
 */
@Entity
public class ParentOneToOne {

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    // name : 매핑할 조인 테이블 이름
    // joinColumns : 현재 엔티티를 참조하는 외래키
    // inverseJoinColumns : 반대방향 엔티티를 참조하는 외래키
    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
    joinColumns = @JoinColumn(name = "PARENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private ChildOneToOne child;

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

    public ChildOneToOne getChild() {
        return child;
    }

    public void setChild(ChildOneToOne child) {
        this.child = child;
    }
}
