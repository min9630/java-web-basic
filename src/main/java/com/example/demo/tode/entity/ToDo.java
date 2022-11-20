package com.example.demo.tode.entity;

import lombok.*;

@Setter @Getter @ToString
//@NoArgsConstructor //기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자

//역할 : 하나의 할 일 데이터의 집합 객체
//DB에 그대로 들어갈 데이터
public class ToDo {

    private long id; //할일들을 식별하는 번호
    private String userId; //할일을 등록한 회원의 식별자
    private String title; // 할일 내용
    private boolean done; // 할일 완료 여부

    //일련번호
    private static long seq;
    //static 없으면 객체 하나당 하나
    //static 있으면 seq는 하나만 있으므로 메모리 누적

    public ToDo() {
        this.id = ++seq;
    }

    public ToDo(String title) {
        this(); //나의 또 다른 기본 생성자 호출 , 맨 첫줄에 써야함
        //super(); 부모 생성자 호출
        this.title = title;
        this.userId = "noname";
    }
}
