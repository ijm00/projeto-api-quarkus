package com.bblc.category;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @PostConstruct
    public void initTableCategory() {
        categoryService.init();
    }

    @POST
    public Response categoryCreate(@Valid Category category) {
        return Response.status(Response.Status.CREATED).entity(categoryService.create(category)).build();
    }

    @GET
    @Path("/list-clients")
    public Response listCategories() {
        return Response.status(Response.Status.OK).entity(categoryService.list()).build();
        }

    @PUT 
    @Path("/{id}")
    public Response categoryUpdate(@Valid @PathParam(value = "id") Long id, @Valid Category category) {
        return Response.status(Response.Status.OK).entity(categoryService.update(id, category)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response categoryDelete(@PathParam(value = "id") long id) {
        return Response.status(Response.Status.OK).entity(categoryService.delete(id)).build();
    }

}
