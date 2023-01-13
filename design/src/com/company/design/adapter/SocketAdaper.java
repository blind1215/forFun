package com.company.design.adapter;

public class SocketAdaper implements Electronic110V{

    private  Electronic220V electronic220V;

    public SocketAdaper(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
