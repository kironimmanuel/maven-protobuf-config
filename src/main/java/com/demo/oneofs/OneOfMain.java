package com.demo.oneofs;

import demo.oneofs.Oneofs;

public class OneOfMain {
    public static void main(String[] args) {
        Oneofs.Result message1 = Oneofs.Result.newBuilder().setMessage("a message").build();

        System.out.println("hasMessage: " + message1.hasMessage());
        System.out.println("hasId: " + message1.hasId());
        System.out.println(message1);
        System.out.println("---------------------------------");

        Oneofs.Result message2 = Oneofs.Result.newBuilder(message1).setId(42).build();

        System.out.println(message2);
        System.out.println("hasMessage: " + message2.hasMessage());
        System.out.println("hasId: " + message2.hasId());
        System.out.println("---------------------------------");

        // Only the last set value is stored
        Oneofs.Result message3 = Oneofs.Result.newBuilder(message1).setId(42).setMessage("a message").build();
        System.out.println(message3);
        System.out.println("hasMessage: " + message3.hasMessage());
        System.out.println("hasId: " + message3.hasId());
    }

}
