package com.juxtapose.juxtaposeapi.javaBasic.ThreadRunAndStart;

public class ReadInventoryThread extends Thread{
    public void run() {
        for (int i = 0; i <3; i++) {
            System.out.println("ReadInventory - " + i);
        }
    }

    public static void main(String[] args) {
        new ReadInventoryThread().start();
    }
}
