package jpabook.model.entity.ex02_IdClass;

import javax.persistence.*;

@Entity
public class ChildById {

    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="PARENT_ID1", referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    })
    private ParentById parent;


}
