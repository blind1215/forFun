package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http:localhost:8080/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get 예전에 사용하던 방식
    public String hi(){
        return "hi";
    }

    //http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName ){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // search?q=intellij
    // &oq=intellij
    // &aqs=chrome.0.69i59l3j0i512l3j0i433i512j0i512l3.2057j0j15
    // &sourceid=chrome
    // &ie=UTF-8

    //http://localhost:8080/api/get/query-param?user=steve&email=steve@gamil.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb = new StringBuilder();


        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+ " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    //명시적으로 받겠다
    @GetMapping("/query-param02")
    public String queryParam02(@RequestParam String name, @RequestParam String email ,@RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age ;
    }

    //?user=steve&email=steve@gamil.com&age=30
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString() ;
    }

    /*
     JSON
     String : value
     number : value
     boolean : value{}
     object : value
     array : value[]
     {
        "phone_number" : "010-1111-2222",
        "age" : 10 ,
        "isAgree" : false,
        "account" : {
            "email: "steve@gmail.com",
            "password":"1234"
        }
     }

     // user 조회 하는 경우
     {
        "user_list" : [
            {
                "account" : "abcd",
                "password" : "1234"
            },
            {
                "account" : "aaaa",
                "password" : "1111"
            },
            {
                "account" : "bbbb",
                "password" : "2222"
            }
        ]
     }
     {
        "account" : "",
        "email" : "",
        "password" : "",
        "address" : ""
     }
     */

}
