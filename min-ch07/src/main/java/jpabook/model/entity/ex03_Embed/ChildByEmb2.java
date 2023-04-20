package jpabook.model.entity.ex03_Embed;

import javax.persistence.*;

@Entity
public class ChildByEmb2 {

    @EmbeddedId
    private ChildIdByEmb2 id;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public ParentByEmb2 parentByEmb2;

    private String name;
}
