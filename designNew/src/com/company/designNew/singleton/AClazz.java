package com.company.designNew.singleton;

public class AClazz {
    private SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getSocketClient();
        //this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
