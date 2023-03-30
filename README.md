# jpaStudy

참고문헌 : 자바 ORM 표준 JPA 프로그래밍

ORM (Object Relational Mapping)
  - 객체와 관계형 데이터베이스 연결
 
JPA (Java Persistence API)
  - 자바 진영의 ORM 기술 표준 명세
  - 기존 객체와 관계형 데이터 베이스의 패러다임 불일치 문제 해소
  - 1. 생산성, 2. 유지보수, 3. 패러다임의 불일치 해결, 4. 성능 향상, 5. 데이터 접근 추상화와 벤더 독립성
  
객체와 관계형 데이터 베이스
  - 객체 : 참조를 통해 다른 객체와 연관관계를 가짐, 연관된 객체를 참조를 통해 조회
  - 테이블 : 외래키(FK)를 통해 다른 테이블과 연관관계를 가짐, 연관된 테이블을 조인을 통해 조회

1. META-INF/persistence.xml를 통해 설정정보 조회 
2. EntityManagerFactory 생성
3. EntityManager 생성
4. EntityManager가 커넥션 풀의 커넥션 사용(트랜잭션 시작)

EntityManagerFactroy(엔티티 매니저 팩토리)
  - 애플리케이션 전체에서 공유
  - EntityManager 생성

EntityManager(엔티티 매니저)
  - 동시성의 문제로 스레드간의 공유하지 않음
  - DB 연결이 필요한 시점에서 커넥션을 얻음
  
영속성 컨텍스트(Persistence Context)
  - 엔티티 영구 저장 환경
  - 엔티티 매니저가 영속성 컨텍스트에 엔티티를 보관하고 관리
  - 1개의 엔티티 매니저 1개의 영속성 컨텍스트
  
엔티티의 생명주기
  - 비영속(new/transient) : 엔티티 객체 생성, 영속성 컨텍스트의 관리전
  - 영속(managed)
  - 준영속(detached)
  - 삭제(removed)
