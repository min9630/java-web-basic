package com.example.demo.tode.repository;


import com.example.demo.tode.dto.FindAllDTO;
import com.example.demo.tode.entity.ToDo;

import java.util.List;

//interface (역할 ) : 할 일 데이터를 CRUD(생성, 조회, 수정, 삭제)한다.
public interface TodoRepository {

    //할일 생성 기능

    /**
     *할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공시 true, 실패시 false 반환
     */
    boolean save(ToDo todo);

    //할일 목록조회 기능
    List<ToDo> findAll();
    //ToDO는 할일 하나를 뜻함 -> 할일 들을 받아와야되니까 리스트로 받기


    //할일 개별조회 기능
    ToDo findOne(long id);

    //할일 삭제 기능
    boolean remove(long id);


}
