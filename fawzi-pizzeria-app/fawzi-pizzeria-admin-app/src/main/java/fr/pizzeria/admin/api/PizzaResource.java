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
    public List<Pizza> getPizzaList() {

        return dao.findAllPizzas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pizza getPizzaById(@PathParam("id") int id) {

        return dao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPizza(Pizza p) {

        dao.savePizza(p);

        ResponseBuilder builder = Response.ok("OK!");
        builder.language("fr").header("Content-type", "text/html");

        return builder.build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deletePizzaById(@PathParam("id") int id) {

        return dao.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putPizza(@PathParam("id") int id, Pizza p) {

        return dao.putPizza(id, p);
    }
}
