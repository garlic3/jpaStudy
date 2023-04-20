package jpabook.model.entity.ex03_Embed;

import javax.persistence.*;

@Entity
public class GrandChildByEmb {

    @EmbeddedId
    private GrandChildIdByEmb id;

    // @MapsId : 외래키와 매핑한 연관관계를 기본키에도 매핑
    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private ChildByEmb2 childByEmb2;
}
