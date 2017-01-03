package fr.pizzeria.admin.api;

import fr.dta.pizzeria.model.Client;
import fr.pizzeria.admin.service.ClientServiceEJB;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.List;

@Path("/clients")
public class ClientResource {

    @EJB
    ClientServiceEJB dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getClientList() {
        System.out.println("IN GET <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        return dao.findAllClients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientById(@PathParam("id") int id) {

        return dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClient(Client c) {

        System.out.println("IN POST <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(c);

        dao.saveClient(c);

        ResponseBuilder builder = Response.ok("OK!");
        builder.language("fr").header("Content-type", "text/html");

        return builder.build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteClientById(@PathParam("id") int id) {

        return dao.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putClient(@PathParam("id") int id, Client c) {

        return dao.putClient(id, c);
    }
}
