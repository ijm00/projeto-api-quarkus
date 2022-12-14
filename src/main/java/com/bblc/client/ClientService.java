package com.bblc.client;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bblc.category.CategoryRepository;

@RequestScoped
public class ClientService {
    @Inject
    ClientRepository clientRepository;

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private CategoryRepository categoryRepository;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ClientDTO create(Client client) {
        categoryRepository.persist(client.getCategory());
        clientRepository.persist(client);
        return clientMapper.toDomain(client);
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientDTO> list() {
        return clientMapper.toDomainList(clientRepository.listWithTypes());
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Client update(Long id, Client client) {
        Client dataClient = clientRepository.findById(id);
        dataClient.setName(client.getName())
                .setAge(client.getAge())
                .setEmail(client.getEmail())
                .setVatNumber(client.getVatNumber());

        clientRepository.persist(dataClient);
        return dataClient;
    }

    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(long id) {
        clientRepository.deleteById(id);
        return "Client " + id + " deleted";
    }
    
}
