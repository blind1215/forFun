package com.company.designNew.singleton;

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
