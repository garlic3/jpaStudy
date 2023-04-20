package jpabook.model.entity.ex03_Embed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildIdByEmb2 implements Serializable {
    private String parentId;
    @Column(name = "CHILD_ID")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildIdByEmb2 childIdByEmb2 = (ChildIdByEmb2) o;

        if (parentId != null ? !parentId.equals(childIdByEmb2.parentId) : childIdByEmb2.parentId != null) return false;
        return id != null ? id.equals(childIdByEmb2.id) : childIdByEmb2.id == null;
    }

    @Override
    public int hashCode() {
        int result = parentId != null ? parentId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
