package com.example.demo.tode.entity;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자

//역할 : 하나의 할 일 데이터의 집합 객체
public class ToDo {

    private long id; //할일들을 식별하는 번호
    private String userId; //할일을 등록한 회원의 식별자
    private String title; // 할일 내용
    private boolean done; // 할일 완료 여부

}
