package com.example.demo.tode.repository;

import com.example.demo.tode.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//역할 : 할일 데이털르 메모리에 CRUD하는 역할
public class TodoRepositoryMemoryImpl implements TodoRepository{

    //메모리 저장소
    /**
     * key : 할일의 식별 id값
     * value : 할일 집합객체
     */
    private static final Map<Long, ToDo> toDoMap = new HashMap<>();
    //final : 안전장치 , 불변성을 줌

    static {
        //정적 초기화
        toDoMap.put(1L,new ToDo(1L,"김철수","저녁밥 만들기",false)) ;
        toDoMap.put(2L,new ToDo(2L,"박영희","산책",false)) ;
        toDoMap.put(3L,new ToDo(3L,"김철수","노래",true)) ;

    }

    @Override
    public boolean save(ToDo todo) {
        if (todo != null) return false;

        toDoMap.put(todo.getId(), todo);
        return true;
    }

    @Override
    public List<ToDo> findAll() {

        List<ToDo> toDoList = new ArrayList<>(); //map에 있는 todo를 옮기기 위한 리스트

        for (Long id : toDoMap.keySet()) {
            ToDo toDo = toDoMap.get(id); //get으로 toDo를 뽑음
            toDoList.add(toDo); //뽑은 ToDo를 List에 넣음

        }
        return toDoList;
    }

    @Override
    public ToDo findOne(long id) {
        return toDoMap.get(id);
    }

    @Override
    public boolean remove(long id) {
        ToDo todo = toDoMap.remove(id);
        return todo != null;
        //null이면 false, 아니면 true
    }
}
