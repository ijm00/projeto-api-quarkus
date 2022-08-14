package com.bblc.client;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;


@Path("/client")
public class ClientResource {

    @Inject
    ClientService clientService;

    @POST
    public Response clientCreate(@Valid Client client) {
        return Response.status(Response.Status.CREATED).entity(clientService.create(client)).build();
    }

    @GET
    @Path("/list")
    public Response listClients() {
        return Response.status(Response.Status.OK).entity(clientService.list()).build();
        }

    @PUT 
    @Path("/{id}")
    public Response clientUpdate(@Valid @PathParam(value = "id") Long id, @Valid Client client) {
        return Response.status(Response.Status.OK).entity(clientService.update(id, client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response clientDelete(@PathParam(value = "id") long id) {
        return Response.status(Response.Status.OK).entity(clientService.delete(id)).build();
    }

}
