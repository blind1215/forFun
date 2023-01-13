package com.company.designNew;

import com.company.designNew.adapter.*;
import com.company.designNew.aop.AopBrowser;
import com.company.designNew.decorator.*;
import com.company.designNew.facade.Ftp;
import com.company.designNew.facade.Reader;
import com.company.designNew.facade.SftpClient;
import com.company.designNew.facade.Writer;
import com.company.designNew.observer.Button;
import com.company.designNew.observer.IButtonListener;
import com.company.designNew.proxy.Browser;
import com.company.designNew.proxy.BrowserProxy;
import com.company.designNew.proxy.IBrowser;
import com.company.designNew.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        //strategy  : 스프링의 꽃임
        Encoder encoder = new Encoder();

        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NomalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

        //facade
        /*Ftp fileClient = new Ftp("www.foo.co.kr",22,"/home/etc");
        fileClient.connect();
        fileClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisConnect();
        writer.fileDisConnect();
        fileClient.disConnect();
        //위와 같지만 사용자는 간단하게 사용가능
        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();*/

        //observer
        /*Button button =new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메세지 전달 : click 1");
        button.click("메세지 전달 : click 2");
        button.click("메세지 전달 : click 3");
        button.click("메세지 전달 : click 4");*/

        //decorator
        /*
        ICar audi = new Audi(1000);
        audi.showPrice();
        //A3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        //A4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //A5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
        */


        //signleton
        /* AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();
        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();
        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));*/

        //adapter
        /*HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);

        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);

        connect(airAdapter);*/


        //proxy
        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();


        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */

        //Aop
        /*AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();


        IBrowser aopBrowser  = new AopBrowser("www.naver.com" ,
                () -> {
                    System.out.println("befor");
                    start.set(System.currentTimeMillis());
                },
                () ->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());*/
    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}