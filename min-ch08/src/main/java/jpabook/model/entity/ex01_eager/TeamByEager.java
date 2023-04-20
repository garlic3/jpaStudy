package jpabook.model.entity.ex01_eager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamByEager {

    @Id
    @Column(name = "TEAM_ID")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
