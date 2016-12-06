package fr.dta.pizzeria.console.ihm.action;

import java.util.Scanner;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;

public class UpdatePizza extends Action {

	// private IhmUtil utils;
	private Scanner reader;
	private PizzaDao pizzaDao;

	public UpdatePizza(IhmUtil utils) {
		super();
		this.setDescription("3. Mettre � jour une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() throws PizzaException {

		for (Pizza p : pizzaDao.findAllPizzas()) {
			System.out.println(p.getCode() + " - " + p.getNom() + " (" + p.getPrix() + " �)");
		}
		System.out.println("Veuillez choisir la pizza � modifier.");
		System.out.println("(99 pour abandonner).");
	}

	@Override
	public void doAction() throws PizzaException {

		while (true) {
			printPizzaList();

			String code = reader.next();
			int pizzaId = pizzaDao.getPizzaIdFromCode(code).get().getId();

			if (pizzaId != -1) {
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next();
				pizzaDao.findAllPizzas().get(pizzaId).setCode(newCode);

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizzaDao.findAllPizzas().get(pizzaId).setNom(name);

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				try {
					pizzaDao.findAllPizzas().get(pizzaId).setPrix(Double.parseDouble(price));
				} catch (Exception e) {
					System.out.println("Invalid price");
				}
				break;
			} else if (code.equals("99")) {
				break;
			}
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
