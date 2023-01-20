package com.company.ioc;

public class Main {

    public  static  void main(String[] args){
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base 64 encoding
        //1
        //Base64Encoder base64Encoder = new Base64Encoder();
        //IEncoder base64Encoder = new Base64Encoder();
        //String result = base64Encoder.encode(url);
        //url encoding
        //UrlEncoder urlEncoder = new UrlEncoder();
        //IEncoder urlEncoder = new UrlEncoder();
        //String urlResult = urlEncoder.encode(url);
        //System.out.println(urlResult);
        //2
        //할때마다 생성자에서 바꿔줘야함
        /*Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);*/
        //3 di 주입후
        //넘겨주는 외부 iEncoder 부분만 바꿔서 관리 ,재사용용이함
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println(result);



        // 추상화로 interface를 만든다
        // Base64Encoder , UrlEncoder 를 IEncoder에서 가져올수있게한다.


    }
}
