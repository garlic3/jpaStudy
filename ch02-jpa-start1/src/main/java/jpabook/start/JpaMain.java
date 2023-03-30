package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {
    	
    	
    	// 엔티티 매니저 설정
    	// 트랜잭션 관리
    	// 비즈니스 로직

        //엔티티 매니저 팩토리 생성
    	// META-INF/persistence.xml 에서 jpabook 영속성 유닛을 찾아 엔티티 매니저 팩토리 생성
        // 엔티티 매니저 팩토리는 애플리케이션 전체에서 딱 한번만 생성하고 공유해서 사용해야 한다(static 사용)
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        // 엔티티 매니저를 통해 데이터베이스에 등록, 수정, 삭제 조회
        // 내부에 데이터소스(데이터베이스 커넥션)을 유지하며 데이터 베이스와 통신
        // 스레드간에 공유하거나 재사용하면 안된다
        
        // JPA를 사용하면 항상 트랜잭션 안에서 데이터를 변경해야 한다 -> 예외 발생
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        // 엔티티 생성후 메소드에게 전달하여 엔티티 저장
        em.persist(member);

        //수정
        // JPA는 어떤 엔티티가 변경되었는지 추적 기능을 가지고 있기때문에
        // 자동으로 update 쿼리를 생성하여 실행한다
        // UPDATE MEMBER SET AGE=20 WHERE ID='id1'
        member.setAge(20);

        //한 건 조회
        // 엔티티 타입과 테이블의 PK와 매핑한 식별자 값으로
        // 엔티티 하나 조회
        // SELECT * FROM MEMBER WHERE ID='id1'
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        // JPQL : 엔티티 객체를 대상으로 쿼리
        // SQL : 데이터베이스 테이블을 대상으로 쿼리
        
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        // 삭제할 엔티티 메소드에게 전달
        // DELETE FROM MEMBER WHERE ID = 'id1'
        em.remove(member);

    }
}
