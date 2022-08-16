package com.bblc.client;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ClientMapper {
    ClientDTO toDomain(Client client);

    Client toEntity(ClientDTO clientDTO);

    default List<ClientDTO> toDomainList(List<Client> list) {
        return list.stream()
                .map(c -> toDomain(c))
                .collect(Collectors.toList());
    }

}
