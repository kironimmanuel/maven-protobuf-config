package com.demo.complex;

import demo.complex.ComplexOuterClass;
import java.util.Arrays;

public class ComplexMain {

    private static ComplexOuterClass.Dummy createDummy(int id, String name) {
        return ComplexOuterClass.Dummy.newBuilder().setId(id).setName(name).build();
    }

    public static void main(String[] args) {
        ComplexOuterClass.Complex message = ComplexOuterClass.Complex.newBuilder()
                .setOneDummy(createDummy(55, "One Dummy"))
                .addAllDummies(Arrays.asList(createDummy(66, "Two Dummy"), createDummy(77, "Three Dummy")))
                .build();

        System.out.println(message);
    }
}
