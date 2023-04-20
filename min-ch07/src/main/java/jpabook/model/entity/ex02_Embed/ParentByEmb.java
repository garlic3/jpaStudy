package jpabook.model.entity.ex02_Embed;

import javax.persistence.*;

@Entity
public class ParentByEmb {


    @EmbeddedId
    private ParentIdByEmb id;
    private String name;


    public ParentIdByEmb getId() {
        return id;
    }

    public void setId(ParentIdByEmb id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
