package com.example.demo.tode.api;

import com.example.demo.tode.dto.FindAllDTO;
import com.example.demo.tode.entity.ToDo;
import com.example.demo.tode.repository.TodoRepository;
import com.example.demo.tode.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {
    private final TodoService service;

    //할 일 목록 전체조회 요청
    @GetMapping
    public ResponseEntity<?> todos() {
        log.info("/api/todos GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }


    //할 일 목록 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDo newTodo){

        newTodo.setUserId("noname");
        log.info("/api,todos POST request - {}", newTodo);

        try {
            FindAllDTO dto = service.createServ(newTodo);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    //할 일 개별 조회 요청
    //URI : /api/todos/3 : GET
    // => 3번 할 일만 조회해서 클라이언트에게 리턴




    //할 일 삭제 요청
    //URI : /api/todos/3 : DELETE
    // => 3번 할 일만 조회해서 클라이언트에게 리턴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){

        log.info("/api/tods/{} DELETE request",id);
        //에러날 가능성 있으면 try, catch로 감싸줌
        try {
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
