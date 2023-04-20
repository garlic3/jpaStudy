package jpabook.model.entity.ex03_IdClass;

import java.io.Serializable;

public class ChildIdById2 implements Serializable {

    // ChildById2.parent 매핑
    private String parent;

    // ChildById2.childId 매핑
    private String childId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildIdById2 childIdById21 = (ChildIdById2) o;

        if (parent != null ? !parent.equals(childIdById21.parent) : childIdById21.parent != null) return false;
        return childId != null ? childId.equals(childIdById21.childId) : childIdById21.childId == null;
    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + (childId != null ? childId.hashCode() : 0);
        return result;
    }


}
