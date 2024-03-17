package com.example.springclientslistpractise;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@Profile("init")
public class MapLoader {

    String filePath = "src/main/resources/client.txt";

    public void loadMap() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String key = parts[2];
                String value = parts[1];
                Client.mapClients.put(key, new Client(parts[0], parts[1], parts[2]));
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
//        for (String key : Client.mapClients.keySet())
//        {
//            System.out.println(key + ":" + Client.mapClients.get(key));
//        }
        reader.close();
    }
}
