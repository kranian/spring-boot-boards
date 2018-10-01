package com.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Setter
@Getter
public class Board {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String writer;

    //조회수 증가
    private int hit;

    @Column(nullable = false, columnDefinition = "date default sysdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Lob        //큰 사이즈의 데이터 저장하기 위한 타입
    private String content;

}
