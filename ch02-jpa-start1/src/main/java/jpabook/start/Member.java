package jpabook.start;

// JPA 어노테이션 패키지
import javax.persistence.*;  //**

/**
 * User: HolyEyE
 * Date: 13. 5. 24. Time: 오후 7:43
 */
@Entity // 이 클래스를 테이블과 매핑한다는 어노테이션
@Table(name="MEMBER") // 매핑할 테이블 정보( 네임 속성 생략시 클래스 이름을 테이블 이름으로 매핑)
public class Member { // 엔티티 클래스

    @Id // 필드를 긱본키에 매핑
    @Column(name = "ID") // 필드를 컬럼에 매핑 
    private String id; // 식별자 필드

    @Column(name = "NAME")
    private String username;

    // 매핑 정보가 없는 필드
    // 매핑 어노테이션 생략시 필드명을 사용해서 컬럼명 매핑
    private Integer age;

    // getter, setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
