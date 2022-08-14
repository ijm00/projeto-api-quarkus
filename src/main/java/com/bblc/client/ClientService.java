package com.bblc.client;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class ClientService {
              
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Client create(Client client) {
        client.persist();
        return client;
    }

    public List<Client> list() {
        return Client.listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Client update(Long id, Client client) {
        Client dataClient = Client.findById(id);
            dataClient.setCompleteName(client.getCompleteName())
                .setAge(client.getAge())
                .setEmail(client.getEmail())
                .setVatNumber(client.getVatNumber());

        Client.persist(dataClient);
        return dataClient;
    }

    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(long id) {
        Client.deleteById(id);
        return "Client " + id + " deleted";
    }
}
