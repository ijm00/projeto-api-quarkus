package com.bblc.client;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client>{
    
    public List<Client> listWithTypes() {
        return find("FROM Client c JOIN FETCH c.category cat ").list();
    }
}
