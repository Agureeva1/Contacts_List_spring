package com.example.springclientslistpractise;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Client {

    private final String name;
    private final String phoneNumber;
    private final String email;
    static final Map<String, Client> mapClients = new HashMap<String, Client>();

    public Client(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @PostConstruct
    public void saveTxt() throws IOException {
        mapClients.put(email, new Client(this.name, this.phoneNumber, this.email));
        Reader writer = new Reader();
        try {
            writer.write(name + ";" + phoneNumber + ";" + email + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAllClients() {
        mapClients.forEach((String, Client) -> System.out.println(Client));
    }

    public static void dellClient(String str) {
        mapClients.remove(str);
    }

    @Override
    public String toString() {
        return name + " | " + phoneNumber + " | " + email;
    }

}
