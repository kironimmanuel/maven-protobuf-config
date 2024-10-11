package com.demo.simple;

import java.util.Arrays;

import com.demo.options.AnotherDummy;

import demo.simple.SimpleOuterClass;

public class SimpleMain {
    public static void main(String[] args) {
        AnotherDummy message1 = AnotherDummy.newBuilder().build();

        SimpleOuterClass.Simple message2 = SimpleOuterClass.Simple.newBuilder()
                .setId(42)
                .setIsSimple(true)
                .setName("Finn the human")
                .addSimpleList(1)
                .addSimpleList(2)
                .addSimpleList(3)
                .addAllSimpleList(Arrays.asList(4, 5, 6))
                .build();

        System.out.println(message2);
    }
}
