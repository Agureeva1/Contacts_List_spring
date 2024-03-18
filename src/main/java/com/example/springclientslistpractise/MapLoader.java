package com.example.springclientslistpractise;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@Profile("init")
public class MapLoader {

    public void loadMap() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(MapClients.filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String key = parts[2];
                    MapClients.mapClients.put(key, new Client(parts[0], parts[1], parts[2]));
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
        }

    }
}
