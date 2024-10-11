package com.demo.maps;

import demo.maps.Maps;
import java.util.Map;

public class MapsMain {

    private static Maps.IdWrapper createIdWrapper(int id) {
        return Maps.IdWrapper.newBuilder().setId(id).build();
    }

    public static void main(String[] args) {
        Maps.MapExample message = Maps.MapExample.newBuilder().putIds("my id 1", createIdWrapper(11))
                .putAllIds(Map.of("my id 2", createIdWrapper(22), "my id 3", createIdWrapper(33))).build();

        System.out.println(message);
    }
}
