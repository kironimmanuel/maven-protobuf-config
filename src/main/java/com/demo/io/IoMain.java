package com.demo.io;

import demo.simple.SimpleOuterClass;
import java.io.*;
import java.io.IOException;

public class IoMain {
    private static void writeTo(SimpleOuterClass.Simple message, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            message.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFrom(String path) {
        // Try with resources will automatically close the file
        try (FileInputStream fis = new FileInputStream(path)) {
            SimpleOuterClass.Simple message = SimpleOuterClass.Simple.parseFrom(fis);
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
                .setId(42)
                .setName("A Name")
                .setIsSimple(true)
                .build();

        String path = "simple_message.bin";

        writeTo(message, path);
        readFrom(path);
    }
}
