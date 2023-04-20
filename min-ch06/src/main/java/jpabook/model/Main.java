package jpabook.model;

import jpabook.model.entity.*;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;

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

//            testSave(em);
//            queryLogicJoin(em);
//            updateRelation(em);
//            deleteRelation(em);
//            biDirection(em);
//            testSaveWithTwoWay(em);
//            testSaveNonOwner(em);
//            testORM(em);
//            testSaveOneWay(em);
//            testSaveWithMany(em);
//            findInverse(em);
//            saveWithConnectTable(em);
//            findWithMany(em);
//            saveWithAlternateKey(em);
//            findWithAlternateKey(em);
            tx.commit();//트랜잭션 커밋




        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료

    }


    // 회원과 팀 저장 (단방향)
    static void testSave(EntityManager em) {
        // 팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        // 회원1 저장
        Member member1 = new Member("member1", "회원1");
        // 연관관계 설정 (참조한 팀의 식별자 Team.id를 외래키로 사용하여 등록쿼리 생성)
        member1.setTeam(team1);
        em.persist(member1);

        // 회원2 저장
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }

    // 회원과 팀 조인 검색 (단방향)
    static void queryLogicJoin(EntityManager em) {
        String jpql = "select m from Member m join m.team t where t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1").getResultList();

        for (Member member : resultList) {
            System.out.println("[query] member.username =" + member.getName());
        }

    }

    // 회원과 팀 수정 (단방향)
    static void updateRelation(EntityManager em) {
        // 새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        // 회원1 연관관계 수정
        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    // 회원과 팀 연관관계 제거 (단방향)
    static void deleteRelation(EntityManager em) {
        Member member1 = em.find(Member.class, "member1");
        // 연관관계 제거
        member1.setTeam(null);
    }

    // 일대다 방향으로 객체 그래프 검색 (양방향)
    static void biDirection(EntityManager em) {
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for (Member member : members
        ) {
            System.out.println("member.username = " + member.getName());

        }
    }


    static void testSaveWithTwoWay(EntityManager em){
        // 팀3 저장
        Team team3 = new Team("team3", "팀3");
        em.persist(team3);

        // 회원3 저장
        Member member3 = new Member("member3", "회원3");
        member3.setTeam(team3); // 연관관계 설정
        em.persist(member3);

        // 회원4 저장
        Member member4 = new Member("member4", "회원4");
        member4.setTeam(team3);
        em.persist(member4);

    }

    static void testSaveNonOwner(EntityManager em){
        // 회원 저장
        Member member5 = new Member("member5", "회원5");
        em.persist(member5);

        Member member6 = new Member("member6", "회원6");
        em.persist(member6);

        Team team5 = new Team("team5", "팀5");
        team5.getMembers().add(member5);
        team5.getMembers().add(member6);
        em.persist(team5);

        // member5, member6의 team_id가 null 값으로 입력된다
        // 연관관계의 주인이 아니기때문에 외래키의 값을 변경할수 없다

    }

    static void testORM(EntityManager em){
        // 팀 저장
        Team team6 = new Team("team6", "팀6");
        em.persist(team6);

        Member member7 = new Member("member7", "회원7");

        // 양방향 연관관계 설정
        // member7.setTeam(team6);
        // team6.getMembers().add(member7);
        // 두줄의 코드를 Member의 setTeam 코드를 변경하여 하나로 사용한다
        member7.setTeam(team6);
        em.persist(member7);

        Member member8 = new Member("member8", "회원8");

        // 양방향 연관관계 설정
        member8.setTeam(team6);
        em.persist(member8);
    }


    // 일대다 단방향 설정 테스트
    static void testSaveOneWay(EntityManager em){
        Member03 member1 = new Member03("member1");
        Member03 member2 = new Member03("member2");

        Team03 team1 = new Team03("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team1);

        // 단방향 연관관계로 MEMBER 엔티티는 TEAM 엔티티를 모르고
        // 연관관계는 TEAM 엔티티의 members가 관리하므로 INSERT-> UPDATE 순서로 진행된다

    }


    static void testSaveWithMany(EntityManager em){
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member06 member = new Member06();
        member.setId("member1");
        member.setName("회원1");
        member.getProducts().add(productA); // 연관관계 설정(다대다 단방향)
        em.persist(member);

        // INSERT PRODUCT -> INSERT MEMBER06-> INSERT MEMBER_PRODUCT


    }

    static void findInverse(EntityManager em){
        Product product = em.find(Product.class, "productA");
        List<Member06> members = product.getMembers();
        for (Member06 member:members
             ) {
            System.out.println("member = " + member.getName());

        }
    }


    static void saveWithConnectTable(EntityManager em){
        // 회원저장
        Member07 member = new Member07();
        member.setId("member1");
        member.setName("회원1");
        em.persist(member);

        // 상품저장
        Product02 productA = new Product02();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 회원 상품 저장
        MemberProduct memberProduct = new MemberProduct();
        memberProduct.setMember07(member); // 연관관계 설정
        memberProduct.setProduct02(productA); // 연관관계 설정
        memberProduct.setOrderAmount(2);

        em.persist(memberProduct);

    }

    static void findWithMany(EntityManager em){
        // 기본키값 생성
        MemberProductId memberProductId = new MemberProductId();
        memberProductId.setMember07("member1");
        memberProductId.setProduct02("productA");

        MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);

        Member07 member = memberProduct.getMember07();
        Product02 product = memberProduct.getProduct02();

        System.out.println("member = " + member.getName());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + memberProduct.getOrderAmount());
    }

    // 다대다 대리키 사용
    static void saveWithAlternateKey(EntityManager em){
        // 회원 저장
        Member08 member = new Member08();
        member.setId("member1");
        member.setName("회원1");
        em.persist(member);

        // 상품저장
        Product03 productA = new Product03();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 주문저장
        Orders order = new Orders();
        order.setMember08(member);
        order.setProduct03(productA);
        order.setOrderAmount(2);
        em.persist(order);
    }


    static void findWithAlternateKey(EntityManager em){

        Long orderId = 1L;
        Orders order = em.find(Orders.class, orderId);

        Member08 member = order.getMember08();
        Product03 product = order.getProduct03();

        System.out.println("member = " + member.getName());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + order.getOrderAmount());


    }



}
