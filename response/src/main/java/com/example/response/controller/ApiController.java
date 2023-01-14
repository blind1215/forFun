package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    //text
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return  account;
    }

    /*
        "name" : "steve",
        "age" : 10,
        "phoneNumber" : "010-1111-2222",
        "address" : "서울어딘가"
     */

    // JSON
    // req -> object mapper -> object -> object-> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user; //200 OK
    }

    //ResponseEntity 활용
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
