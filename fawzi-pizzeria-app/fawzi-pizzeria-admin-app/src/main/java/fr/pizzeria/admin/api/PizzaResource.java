package fr.pizzeria.admin.api;

import fr.dta.pizzeria.model.Pizza;
import fr.pizzeria.admin.service.PizzaServiceEJB;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.List;

@Path("/pizzas")
public class PizzaResource {

    @EJB
    PizzaServiceEJB dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pizza> read() {

        return dao.findAllPizzas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza getById(@PathParam("id") int id) {

        return dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Pizza p) {

        dao.savePizza(p);

        ResponseBuilder builder = Response.ok("OK!");
        builder.language("fr").header("Content-type", "text/html");

        return builder.build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteById(@PathParam("id") int id) {

        return dao.deleteById(id);
    }
}
