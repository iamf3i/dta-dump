package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class DeletePizza extends Action {

    @Autowired
    Scanner scan;

	@Qualifier("enabled")
    @Autowired
    PizzaDao pizzaDao;

    public DeletePizza() {
        super();
        this.setDescription("4. Supprimer une pizza");
    }

    private void printPizzaList() throws PizzaException {

        for (Pizza p : pizzaDao.findAllPizzas()) {
            System.out.println(p.getCode() + " - " + p.getNom() + " (" + p.getPrix() + " €)");
        }
        System.out.println("Veuillez choisir la pizza à supprimer.");
        System.out.println("(99 pour abandonner).");
    }

    @Override
    public void doAction() throws PizzaException {
        System.out.println("JE SUPPRIME UNE PIZZA :D");

        while (true) {
            printPizzaList();

            String code = scan.next();

            if (code.equals("99")) {
                break;
            } else if (pizzaDao.getPizzaIdFromCode(code).get().getId() != -1) {
                pizzaDao.deletePizza(code);
                break;
            }
        }
    }

    @Override
    public void describeAction() {
        System.out.println(this.getDescription());
    }

}
