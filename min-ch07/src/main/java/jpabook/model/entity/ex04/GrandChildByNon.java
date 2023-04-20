package jpabook.model.entity.ex04;

import javax.persistence.*;

@Entity
public class GrandChildByNon {

    @Id
    @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "CHILD_ID")
    private ChildByNon childByNon;
}
