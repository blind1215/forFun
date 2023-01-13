package com.company.designNew;

import com.company.designNew.adapter.*;
import com.company.designNew.proxy.Browser;
import com.company.designNew.proxy.BrowserProxy;
import com.company.designNew.proxy.IBrowser;

public class Main {
    public static void main(String[] args) {
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
        */

        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}