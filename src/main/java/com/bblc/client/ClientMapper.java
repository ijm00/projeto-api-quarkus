package com.bblc.client;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
//TODO @ApplicationScoped ??
public interface ClientMapper {
    ClientDTO toDomain(Client client);
    Client toEntity(ClientDTO clientDTO);
}
