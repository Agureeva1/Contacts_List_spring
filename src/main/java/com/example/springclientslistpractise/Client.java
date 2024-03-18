package com.example.springclientslistpractise;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
@Scope("prototype")
public class Client {

    private final String name;
    private final String phoneNumber;
    private final String email;

    public Client(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @PostConstruct
    public void saveTxt() throws IOException {
        MapClients.mapClients.put(email, new Client(this.name, this.phoneNumber, this.email));
        FileWriter writer = null;
        try {
            writer = new Writer().getWriter();
            writer.write(name + ";" + phoneNumber + ";" + email + "\n");}
        finally {
           if (writer != null) writer.close();}
    }

    @Override
    public String toString() {
        return name + " | " + phoneNumber + " | " + email;
    }

}
