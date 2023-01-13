package com.company.design.signleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient(){

    }

    public static SocketClient getSocketClient() {

        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
