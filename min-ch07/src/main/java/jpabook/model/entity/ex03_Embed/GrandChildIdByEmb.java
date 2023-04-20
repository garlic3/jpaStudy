package jpabook.model.entity.ex03_Embed;

import javax.persistence.Column;
import java.io.Serializable;

public class GrandChildIdByEmb implements Serializable {

    private ChildIdByEmb2 childIdByEmb2;

    @Column(name = "GRANDCHILD_ID")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrandChildIdByEmb that = (GrandChildIdByEmb) o;

        if (childIdByEmb2 != null ? !childIdByEmb2.equals(that.childIdByEmb2) : that.childIdByEmb2 != null) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = childIdByEmb2 != null ? childIdByEmb2.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
