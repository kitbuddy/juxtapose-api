package com.juxtapose.juxtaposeapi.javaBasic.ThreadRunAndStart;

public class javaThreadClassRun {


    public static void main(String[] args) {
        System.out.println("Begin");
        new ReadInventoryThread().run();
        (new Thread(new PrintData())).run();
        new ReadInventoryThread().run();

        System.out.println("End");

    }
}
