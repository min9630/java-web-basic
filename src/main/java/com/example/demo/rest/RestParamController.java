package com.example.demo.rest;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user") //URL : /param/user?name=홍길동
    public String userName(HttpServletRequest request){

        //홍길동을 읽어줌
        //getParameter 반환값 -> String
        String name = request.getParameter("name");
        return String.format("당신의 이름은 %s입니다",name);
    }

    @GetMapping("/user2")  //  /param/user2?name=짹짹이&age=25
    public String userName(
            //변수값 키값이랑 똑같이 쓰기 싫을 때
            @RequestParam("name") String nm,
            int age
    ) {

        return String.format(
                "당신의 이름은 %s님이고, 나이는 %d세입니다."
                , nm, age);
    }

    @GetMapping("/user3") // /param/user3?name=김철수&age=30&address=서울&height=171.88&hobby=축구&hobby=농구

    public String user3(UserDTO userInfo){
        return String.format("당신의 이름은 %s님이고, 나이는 %d세이고, 주소는 %s이며, 키는%.2f며 취미는 %s들이다"
                , userInfo.getName()
                , userInfo.getAge()
                , userInfo.getAddress()
                , userInfo.getHeight()
                , userInfo.getHobby()
        );
    }


    //너무 많으면 DTO객체 만들어 나열
    @Setter//필수
    @Getter
    @ToString
    @NoArgsConstructor //필수
    @AllArgsConstructor
    public static class UserDTO {

        private String name;
        private int age;
        private String address;
        private double height;
        private List<String> hobby;
    }


    @GetMapping("/user4/{userNum}")
    public String user4(@PathVariable int userNum) {
        //@PathVariable 경로를 읽을 때 사용

        return String.format("회원번호는 %d번입니다",userNum);

    }
}
