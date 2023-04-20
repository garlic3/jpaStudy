package jpabook.model.entity.ex01_inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends ItemWithJoin {

    private String director;
    private String actor;
}
