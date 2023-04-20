package jpabook.model.entity.ex05;

import javax.persistence.*;

// 자식
@Entity
public class BoardDetail {

    @Id
    private Long boardId;

    // 자식의 기본키 값으로 부모 테이블의 기본키 값만 사용한다
    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    private String content;

    public Long getBoardId() {
        return boardId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
