package jpabook.model.entity.ex03_IdClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParentById2 {

    @Id
    @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
