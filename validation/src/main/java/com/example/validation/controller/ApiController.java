package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
        System.out.println(user);

        //1
        /*
        email의 형식을 잡아주지 않음
        {
            "name":"홍길동",
            "age" : 10,
            "email" : "abcdefg",
            "phoneNumber":"01011112222"
        }
        */
        //어떤 에러를 가지고있는지
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach( e -> {
                FieldError field = (FieldError) e;
                String message = e.getDefaultMessage();
                System.out.println("field : " + field.getField());
                System.out.println("error message : " + message);

                sb.append("field : " + field.getField() +"\n");
                sb.append("message : " + message);

            });

            //logic

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }


        return ResponseEntity.ok(user);
    }
}
