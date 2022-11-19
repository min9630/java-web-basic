package com.example.demo.tode.repository;

import com.example.demo.tode.entity.ToDo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//스프링 컨테이너를 테스트 클래스에서 사용가능
class TodoRepositoryMemoryImplTest {


    @Autowired
    TodoRepository repository;

    //단언 : 강력하게 주장
    @Test
    @DisplayName("저장소에서 목록을 조회했을 때 할 일의 개수가 3개여야 한다")
    void findAllTest(){
        //given : 테스트시 필요한 데이터
        //넣어줄 데이터 없으므로 생략

        //when : 테스트의 실제 상황
        List<ToDo> toDoList = repository.findAll();

        //then : 테스트 결과 단언
        assertEquals(3, toDoList.size());
        assertNotNull(toDoList);
    }

    @Test
    @DisplayName("아이디가 2번인 할일 데이터를 조회했을 때 그 작성자 이름이 박영희이어야 한다")
    void findOneTest(){
        //given
        long id = 2L;

        //when
        ToDo toDo = repository.findOne(id);

        //then
        assertEquals("박영희",toDo.getUserId());
        assertFalse(toDo.isDone());
    }

    @Test
    @DisplayName("1번 할일을 삭제한 후 다시 조회했을 때 null이 나와야 한다")
    void removeTest() {
        // given
        long id = 1L;

        // when
        boolean flag = repository.remove(id);
        ToDo toDo = repository.findOne(id);

        // then
        assertTrue(flag);
        assertNull(toDo);
        assertEquals(2,repository.findAll().size());
    }

    @Test
    @DisplayName("새로운 4번 할일을 등록했을 때 전체목록의 개수가 4개여야 한다")
    void saveTest() {
        // given
        ToDo newTodo = new ToDo(4L,"말똥이","낮잠",false);

        // when
        boolean flag = repository.save(newTodo);

        List<ToDo> toDoList = repository.findAll();

        // then
        assertTrue(flag);
        assertEquals(4, toDoList.size());


    }
}