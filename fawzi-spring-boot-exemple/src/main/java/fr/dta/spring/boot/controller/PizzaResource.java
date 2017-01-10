package fr.dta.spring.boot.controller;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Fawzi NASSIM on 10/01/2017.
 */
@RestController
@RequestMapping("/api/pizzas")
public class PizzaResource {

    @Autowired
    @Qualifier("enabled")
    PizzaDao dao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Pizza>> getPizzaList() throws PizzaException {
        return new ResponseEntity<List<Pizza>>(dao.findAllPizzas(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) throws PizzaException {

        dao.saveNewPizza(pizza);
        return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void generatePizzas(@RequestBody Pizza pizza, HttpServletResponse resp) throws PizzaException {

        Pizza p1 = new Pizza();
        p1.setNom("PEPERONI");
        p1.setCode("PEP");
        p1.setPrix(187.0);

        Pizza p2 = new Pizza();
        p2.setNom("MARG");
        p2.setCode("MAR");
        p2.setPrix(188.0);

        Pizza p3 = new Pizza();
        p3.setNom("FROMAGES");
        p3.setCode("FRO");
        p3.setPrix(189.0);

        dao.saveNewPizza(p1);
        dao.saveNewPizza(p2);
        dao.saveNewPizza(p3);

        resp.setStatus(HttpStatus.CREATED.value());
    }
}
