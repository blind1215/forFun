package com.example.springioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

//객체로 관리 하는
@Component
public class Base64Encoder implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
