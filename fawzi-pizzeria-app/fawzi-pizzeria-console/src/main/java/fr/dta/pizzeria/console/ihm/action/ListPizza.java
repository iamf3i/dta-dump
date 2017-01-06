package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ListPizza extends Action {

    @Qualifier("enabled")
    @Autowired
    private PizzaDao dao;

    public ListPizza() {
        super();
        this.setDescription("1. Lister les pizzas");

    }

    @Override
    public void doAction() throws PizzaException {

        for (Pizza p : dao.findAllPizzas()) {
            System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + " €)");
        }
    }

    @Override
    public void describeAction() {
        System.out.println(this.getDescription());
    }

}
