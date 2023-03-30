package jpabook.start;

import javax.persistence.*;

@Entity
//@SequenceGenerator(
//		
//		name = "BOARD_SEQ_GENERATOR", // 식별자 생성기 이름
//		sequenceName = "BOARD_SEQ", // DB 시퀀스 이름
//		initialValue = 1, // DDL 생성시 초기화 값 
//		allocationSize = 1 // 시퀀스 한번 호출에 증가하는 수
//		
//		)

@TableGenerator(
		
		name = "BOARD_SEQ_GENERATOR", // 식별자 키 생성기 이름
		table = "MY_SEQUENCES", // 테이블 이름
		pkColumnValue = "BOARD_SEQ",  // 키로 사용할 값 이름
		allocationSize = 1
		
		)
public class Board {

	
	
	// IDENTITY : 엔티티 DB 저장 -> 식별자 조회 -> 조회한 식별자 엔티티 할당
	// SEQUENCE : persist() 호출. DB 시퀀스 사용 식별자 조회 -> 조회한 식별자 엔티티 할당 -> 엔티티 역속성 컨텍스트에 저장
	// -> 트랜잭션 커밋 -> flush -> 엔티티 DB 저장
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키생성을 DB에 위임
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR") // 시퀀스를 기본키로 사용
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.AUTO) // oracle = SEQUENCE, mysql : IDENTITY
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
