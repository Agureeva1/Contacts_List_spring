package com.example.springclientslistpractise;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class Writer{

    FileWriter writer;

    public Writer() throws IOException {
       this. writer = new FileWriter(MapClients.filePath, true);
    }

    public FileWriter getWriter() {
        return writer;
    }
}
