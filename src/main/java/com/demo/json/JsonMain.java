package com.demo.json;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.io.FileWriter;
import java.util.Arrays;

import demo.simple.SimpleOuterClass;

public class JsonMain {
    private static String toJSON(SimpleOuterClass.Simple message) throws InvalidProtocolBufferException {
        String jsonString = JsonFormat.printer()
                .omittingInsignificantWhitespace()
                .includingDefaultValueFields() // example: id: 0
                .print(message);

        try (FileWriter fileWrite = new FileWriter("simple_message.json")) {
            fileWrite.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    private static SimpleOuterClass.Simple fromJSON(String json) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple.Builder builder = SimpleOuterClass.Simple.newBuilder();

        JsonFormat.parser().merge(json, builder);

        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
                .setId(42)
                .setName("A Name")
                .setIsSimple(true)
                .addAllSimpleList(Arrays.asList(1, 2, 3))
                .build();

        String json = toJSON(message);

        System.out.println(json);
        System.out.println(fromJSON(json));
    }

}
