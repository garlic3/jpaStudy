package jpabook.model;


import jpabook.model.entity.Member;
import jpabook.model.entity.Team;
import jpabook.model.entity.ex01_eager.MemberByEager;
import jpabook.model.entity.ex01_eager.TeamByEager;
import jpabook.model.entity.ex01_lazy.MemberByLazy;
import jpabook.model.entity.ex01_lazy.TeamByLazy;
import jpabook.model.entity.ex02_cascade.ChildByCascade;
import jpabook.model.entity.ex02_cascade.ParentByCascade;
import jpabook.model.entity.ex03_orphan.ChildByOrphan;
import jpabook.model.entity.ex03_orphan.ParentByOrphan;

import javax.persistence.*;


/**
 * Created by 1001218 on 15. 4. 5..
 */
public class Main {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
//            testMethod(em);
//            testProxyMethod(em);
//            testEager(em);
//            testLazy(em);
//            saveWithCascade(em);
            testOrphan(em);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료

    }


    static void testMethod(EntityManager em){
        Team team = new Team();
        team.setName("team1");
        em.persist(team);

        Member member = new Member();
        member.setUsername("member1");
        member.setTeam(team);
        em.persist(member);

        // 영속성 컨텍스트에 존재하지 않을경우 데이터베이스를 조회
        // Member member1 = em.find(Member.class, "member1");

        // 엔티티를 실제 사용하는 시점까지 데이터베이스 조회 연기
        // 데이터베이스 접근을 위임한 프록시 객체 반환
        // Member member2 = em.getReference(Member.class, "member1");

    }

    static void testProxyMethod(EntityManager em){
        Member member = em.find(Member.class, "member1");
        // SQL을 실행하지 않는다
        // 연관관계를 설정할때는 식별자 값만 사용하므로 프록시를 사용하여 데이터베이스 접근 횟수를 줄일수 있음
        Team team = em.getReference(Team.class, "team1");
        member.setTeam(team);
    }

    // 즉시로딩 실행
    static void testEager(EntityManager em){
        // 조인쿼리가 사용된다
        MemberByEager member = em.find(MemberByEager.class, "member1");
        TeamByEager team = member.getTeam();
    }

    // 지연로딩 실행
    static void testLazy(EntityManager em){
        MemberByLazy member = em.find(MemberByLazy.class, "member1");
        TeamByLazy team = member.getTeam();
        // 팀 객체 실제 사용
        team.getName();

    }

    // 영속성 전이
    static void saveWithCascade(EntityManager em){
        ChildByCascade child1 = new ChildByCascade();
        ChildByCascade child2 = new ChildByCascade();

        ParentByCascade parent = new ParentByCascade();
        // 연관관계 설정
        child1.setParent(parent);
        child2.setParent(parent);

        parent.getChildren().add(child1);
        parent.getChildren().add(child2);

        // 부모, 연관된 자식 저장
        // 바로 전이가 발생하지 않고 플러시 호출시 전이가 발생
        em.persist(parent);

    }

    // 고아 객체 제거 사용
    static void testOrphan(EntityManager em){
        ParentByOrphan parent = em.find(ParentByOrphan.class, 7L);
        parent.getChildren().remove(0);

    }

}
