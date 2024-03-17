package com.example.springclientslistpractise;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class Reader extends FileWriter {

    FileWriter writer;

    public Reader() throws IOException {
        super("src/main/resources/client.txt", true);
    }
}
