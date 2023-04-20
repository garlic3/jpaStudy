package jpabook.model.entity.ex01_lazy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamByLazy {

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
