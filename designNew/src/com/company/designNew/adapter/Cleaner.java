package com.company.designNew.adapter;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("청소기 220v on");
    }
}
