package jpabook.model;


import jpabook.model.entity.ex02_Embed.ParentByEmb;
import jpabook.model.entity.ex02_Embed.ParentIdByEmb;
import jpabook.model.entity.ex02_IdClass.ParentById;
import jpabook.model.entity.ex02_IdClass.ParentIdById;
import jpabook.model.entity.ex05.Board;
import jpabook.model.entity.ex05.BoardDetail;

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
//            testByIdClass(em);
//            testByEmbeddedId(em);
            testOneToOne(em);
            tx.commit();//트랜잭션 커밋


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료

    }


    // @IdClass 어노테이션 사용
    static void testByIdClass(EntityManager em){
        // 저장
        ParentById parentById = new ParentById();
        parentById.setId1("myId1");
        parentById.setId2("myId2");
        parentById.setName("parentName");
        // persist() 호출시 영속성 컨텍스트에 엔티티를 등록하기전 내부에서
        // Parent.id1, Parent.id2 를 사용하여 식별자 클래스인 ParentId를 생성하고 키로 사용한다
        em.persist(parentById);

        ParentIdById parentIdById = new ParentIdById("myId1", "myId2");
        ParentById findParentById = em.find(ParentById.class, parentIdById);
        System.out.println("parent = " + findParentById.getName());

    }

    static void testByEmbeddedId(EntityManager em){
        ParentByEmb parent = new ParentByEmb();
        // 식별자 클래스를 직접 생성해서 사용
        ParentIdByEmb parentId = new ParentIdByEmb("myId1", "myId2");
        parent.setId(parentId);
        parent.setName("parentName");
        em.persist(parent);

        ParentIdByEmb parentId02 = new ParentIdByEmb("myId1", "myId2");
        ParentByEmb findParent = em.find(ParentByEmb.class, parentId02);
        System.out.println("parent = " + findParent.getName());
    }


    static void testOneToOne(EntityManager em){
        Board board = new Board();
        board.setTitle("제목");
        em.persist(board);

        BoardDetail boardDetail = new BoardDetail();
        boardDetail.setContent("내용");
        boardDetail.setBoard(board);
        em.persist(boardDetail);

    }

}
