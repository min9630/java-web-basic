package com.example.demo.tode.dto;


import com.example.demo.tode.entity.ToDo;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    //보여주고 싶은 정보만 들어있음(숨기고 싶은 정보 뺌)
    //회면에 보여주고 싶은 데이터
    private  long id;
    private String title;
    private boolean done;


    //ToDo에서 dto가 필요한 필드를 빼오는 생성자
    public TodoDto(ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();

    }

}
