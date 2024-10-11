package com.demo.enumerations;

import demo.enumerations.EnumerationOuterClass;

public class EnumerationsMain {
    public static void main(String[] args) {
        EnumerationOuterClass.Enumeration message = EnumerationOuterClass.Enumeration.newBuilder()
                .setEyeColor(EnumerationOuterClass.EyeColor.EYE_COLOR_BLUE)
                // .setEyeColorValue(2) // This is also possible, but less descriptive
                .build();

        System.out.println(message);
    }
}
