package jpabook.start;

import javax.persistence.*;  //**
import java.util.Date;

/**
 * User: HolyEyE
 * Date: 13. 5. 24. Time: 오후 7:43
 */
@Entity
// 유니크 제약조건
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint( //추가 //**
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"} )})

//엔티티 데이터 접근 방식
//@Access(AccessType.FIELD) : 필드에 직접 접근(private 이어도 접근 가능)
//@Access(AccessType.PROPERTY) : getter를 통해 접근

public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    // null 값 허용, 길이 제약조건
    @Column(name = "NAME", nullable = false, length = 10) //추가 //**
//    @Column(name = "NAME") //추가 //**
    private String username;

    // 기본 타입 int에는 null 값 입력이 안되므로
    // not null 제약 조건을 추가해서 사용한다
    // @Column(nullable = false)
    private Integer age;

    //=== 추가
    // enum 사용시 @Enumerated 어노테이션으로 매핑
    // EnumType.ORDINAL : enum에 정의된 순서대로
    // EnumType.STRING : enum 이름 그대로(문자)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입 사용시 @Temporal 어노테이션으로 매핑
    // DB 방언에 따라 DDL이 생성된다
    // dateTime: mysql
    // timestamp: h2, oracle, postgreSQL 
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 길이 제한이 없는 필드는 CLOB 타입으로 저장
    // CLOB, BLOB 타입으로 저장하기 위해 @Lob 어노테이션으로 매핑
    // CLOB: String, char[], java.sql.CLOB
    // BLOB: byte[], java.sql.BLOB
    @Lob
    private String description;

    // 해당 필드는 매핑하지 않는다
    // 객체에 임시로 어떤값을 보관하고 싶을때 사용
    @Transient
    private String temp;


    //Getter, Setter

    //@Id : //@Access(AccessType.PROPERTY) : getter를 통해 접근 생략
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
