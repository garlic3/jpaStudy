package jpabook.model.entity.ex03_IdClass;

import java.io.Serializable;

public class GrandChildIdById implements Serializable {

    private ChildIdById2 child;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrandChildIdById that = (GrandChildIdById) o;

        if (child != null ? !child.equals(that.child) : that.child != null) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = child != null ? child.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
