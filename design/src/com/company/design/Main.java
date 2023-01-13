package com.company.design;

import com.company.design.adapter.*;
import com.company.design.signleton.AClazz;
import com.company.design.signleton.BClazz;
import com.company.design.signleton.SocketClient;

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

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdaper(cleaner);

        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdaper(airConditioner);

        connect(airAdapter);


    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}