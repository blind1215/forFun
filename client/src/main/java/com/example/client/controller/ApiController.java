package com.example.client.controller;

import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/client")
@RestController
public class ApiController {

    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public UserResponse getHello(){

        return restTemplateService.hello();
    }

   /* @PostMapping("/hello")
    public UserResponse postHello(){
        //return restTemplateService.post();
        return restTemplateService.exchange();
        //return restTemplateService.genericExchange();
    }*/


    @PostMapping("/hello")
    public Req<UserResponse> postHello(){
        //return restTemplateService.post();
        //return restTemplateService.exchange();
        return restTemplateService.genericExchange();
    }
}
