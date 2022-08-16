package com.bblc.client;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ClientMapper {
    ClientDTO toDomain(Client client);
    Client toEntity(ClientDTO clientDTO);
}
