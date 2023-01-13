package com.company.designNew.singleton;

public class BClazz {
    private SocketClient socketClient;

    public BClazz(){
        this.socketClient = SocketClient.getSocketClient();
        //this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
