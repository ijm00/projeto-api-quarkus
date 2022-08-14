package com.bblc.client;

public class ClientDTO {
    
    private final String name;
    private final String email;

    public ClientDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
                               
}
