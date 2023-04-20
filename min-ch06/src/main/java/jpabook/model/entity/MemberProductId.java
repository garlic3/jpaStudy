package jpabook.model.entity;

import java.io.Serializable;

/*
    MemberProduct 식별자 클래스
 */
public class MemberProductId implements Serializable {
    private String member07;
    private String product02;

    // equals() 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberProductId that = (MemberProductId) o;

        if (member07 != null ? !member07.equals(that.member07) : that.member07 != null) return false;
        return product02 != null ? product02.equals(that.product02) : that.product02 == null;
    }

    // hashCode() 재정의
    @Override
    public int hashCode() {
        int result = member07 != null ? member07.hashCode() : 0;
        result = 31 * result + (product02 != null ? product02.hashCode() : 0);
        return result;
    }

    public String getMember07() {
        return member07;
    }

    public void setMember07(String member07) {
        this.member07 = member07;
    }

    public String getProduct02() {
        return product02;
    }

    public void setProduct02(String product02) {
        this.product02 = product02;
    }
}
