package com.company.ioc;

import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    //di로 주입시킴
    /*public Encoder(){
        this.iEncoder = new Base64Encoder();
    }*/

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
