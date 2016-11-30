package fr.pizzeria.ihm.action;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class DeletePizza extends Action {

	private Scanner reader;
	private PizzaDao pizzaDao;

	public DeletePizza(IhmUtil utils) {
		super();
		this.setDescription("4. Supprimer une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() {

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
