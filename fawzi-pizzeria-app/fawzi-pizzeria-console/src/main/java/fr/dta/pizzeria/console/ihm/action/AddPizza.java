package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.CategoriePizza;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AddPizza extends Action {

    @Autowired
    Scanner scan;

    @Autowired
    PizzaDao dao;

	public AddPizza() {
		super();
		this.setDescription("2. Ajouter une nouvelle pizza");
	}

	@Override
	public void doAction() throws PizzaException {

		System.out.println("Veuillez saisir le code");
		String code = scan.next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = scan.next();

		System.out.println("Veuillez saisir la catégorie");
		String cat = scan.next();

		System.out.println("Veuillez saisir le prix");
		String price = scan.next();

		Pizza newPizza = new Pizza();

		newPizza.setCode(code);
		newPizza.setNom(name);
		newPizza.setCat(CategoriePizza.valueOf(cat));
		newPizza.setPrix(Double.parseDouble(price));

		dao.saveNewPizza(newPizza);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
