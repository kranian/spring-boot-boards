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
    private int id;             //ID
    private String title;       //제목
    private String writer;      //작성자
    private int hit;            //조회수

    @Column(nullable = false, columnDefinition = "date default sysdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Lob        //큰 사이즈의 데이터 저장하기 위한 타입
    private String content;

}
