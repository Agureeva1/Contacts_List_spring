package com.example.springclientslistpractise;

import java.util.HashMap;
import java.util.Map;

public class MapClients {
    static final Map<String, Client> mapClients = new HashMap<String, Client>();
    static final String filePath = "src/main/resources/client.txt";

    public static void showAllClients() {
        mapClients.forEach((String, Client) -> System.out.println(Client));
    }

    public static void dellClient(String str) {
        mapClients.remove(str);
    }
}
