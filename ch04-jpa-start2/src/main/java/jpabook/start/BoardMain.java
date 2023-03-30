package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardMain {

	public static void main(String[] args) {

		// 엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); // 트랜잭션 기능 획득

		try {

			tx.begin(); // 트랜잭션 시작
			logic(em); // 비즈니스 로직
			tx.commit();// 트랜잭션 커밋

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 트랜잭션 롤백
		} finally {
			em.close(); // 엔티티 매니저 종료
		}

		emf.close(); // 엔티티 매니저 팩토리 종료

	}

	private static void logic(EntityManager em) {
		Board board = new Board();
		em.persist(board);
		// DB가 생성한 값을 조회
		// 엔티티를 DB에 저장해야 식별자를 구할 수 있으므로 쓰기 지연이 동작하지 않음

		System.out.println("board.id =" + board.getId());
	}
}
