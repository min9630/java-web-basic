package com.example.demo.tode.service;

import com.example.demo.tode.dto.FindAllDTO;
import com.example.demo.tode.dto.TodoDto;
import com.example.demo.tode.entity.ToDo;
import com.example.demo.tode.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//역할: 컨트롤러와 저장소 사이의 잡일 처리 역할
@Service
@Slf4j
@RequiredArgsConstructor //final 초기화
public class TodoService {

    private final TodoRepository repository;

    /**
     * - 할 일 목록조회 중간처리
     * 1. 컨트롤러에게 userId를 뺀 할 일 리스트를 전달
     * 2. 할 일 목록의 카운트를 세서 따로 추가해서 전달
     *
     */

    public FindAllDTO findAllServ(){

        return new FindAllDTO(repository.findAll());
    }

    public FindAllDTO createServ(final ToDo newTodo) {

        //null이 됐을때 강제에러
        if(newTodo == null){
            log.warn(("newTodo cannot be null"));
            throw new RuntimeException("newTodo cannot be null");
        }

        boolean flag = repository.save(newTodo);
        if (flag) log.info("새로운 할일 [Id: {}] 이 저장되었습니다",newTodo.getId());

        return flag ? findAllServ() : null;
    }

    //삭제 서비스 메서드
    public FindAllDTO deleteServ(long id) {

        boolean flag = repository.remove(id);

        //삭제 실패한 경우
        if(!flag){
            log.warn("delete fail not found [{}]",id);
            throw new RuntimeException("delete fail");
        }

        return findAllServ();
    }
}
