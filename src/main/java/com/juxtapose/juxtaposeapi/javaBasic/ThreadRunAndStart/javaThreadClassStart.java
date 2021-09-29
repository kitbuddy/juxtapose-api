package com.juxtapose.juxtaposeapi.javaBasic.ThreadRunAndStart;

public class javaThreadClassStart {

    public static void main(String[] args) {
        System.out.println("Begin");
        new ReadInventoryThread().start();
        (new Thread(new PrintData())).start();
        new ReadInventoryThread().start();

        System.out.println("End");
    }
}
