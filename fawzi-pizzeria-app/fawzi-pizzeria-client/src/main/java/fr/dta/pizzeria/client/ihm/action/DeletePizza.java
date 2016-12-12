package fr.dta.pizzeria.client.ihm.action;

import java.util.Scanner;

import fr.dta.pizzeria.client.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;

public class DeletePizza extends Action {

	private Scanner reader;
	private PizzaDao pizzaDao;

	public DeletePizza(IhmUtil utils) {
		super();
		this.setDescription("4. Supprimer une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
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

			String code = reader.next();

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
