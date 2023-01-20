package com.example.springioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Encoder {

    private IEncoder encoder;

    //di로 주입시킴
    /*public Encoder(){
        this.iEncoder = new Base64Encoder();
    }*/

    public Encoder(@Qualifier("base64Encoder") IEncoder encoder){
        this.encoder = encoder;
    }

    public void setEncoder(IEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String message){
        return encoder.encode(message);
    }
}
