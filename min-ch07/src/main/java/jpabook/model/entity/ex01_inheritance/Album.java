package jpabook.model.entity.ex01_inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// 엔티티를 저장할때 구분 컬럼에 입력할 값을 지정
@DiscriminatorValue("A")
public class Album extends ItemWithJoin {

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
