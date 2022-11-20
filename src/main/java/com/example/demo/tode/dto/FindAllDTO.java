package com.example.demo.tode.dto;

import com.example.demo.tode.entity.ToDo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    //전체 목록 조회 가능한 데이터

    private int count; //할 일 목록의 개수
    private List<TodoDto> todos; //userId가 빠진 할 일 목록

    public FindAllDTO(List<ToDo> toDoList) {
        this.count = toDoList.size();
        this.convertDtoList(toDoList);
    }

    //List<ToDo>를 받으면 List<TodoDto>로 반환하는 메서드
    public void convertDtoList(List<ToDo> toDoList){
        List<TodoDto> dtos = new ArrayList<>();

        for( ToDo toDo : toDoList){
            dtos.add(new TodoDto(toDo));
        }

        this.todos = dtos;

    }

}
