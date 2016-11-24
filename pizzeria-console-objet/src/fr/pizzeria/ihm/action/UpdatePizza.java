package fr.pizzeria.ihm.action;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class UpdatePizza extends Action {

	// private IhmUtil utils;
	private Scanner reader;
	private PizzaDao pizzaDao;

	public UpdatePizza(IhmUtil utils) {
		super();
		this.setDescription("3. Mettre à jour une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() {

		for (Pizza p: pizzaDao.findAllPizzas()) {
			System.out.println(p.getCode() + " - " + p.getNom() + " (" + p.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir la pizza à modifier.");
		System.out.println("(99 pour abandonner).");
	}

	@Override
	public void do_action() {

		while (true) {
			printPizzaList();

			String code = reader.next();
			int pizzaId = pizzaDao.getPizzaIdFromCode(code);

			if (pizzaId != -1) {
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next();
				pizzaDao.findAllPizzas()[pizzaId].setCode(newCode);

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizzaDao.findAllPizzas()[pizzaId].setNom(name);

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				try {
					pizzaDao.findAllPizzas()[pizzaId].setPrix(Double.parseDouble(price));
				} catch (Exception e) {
					System.out.println("Invalid price");
				}
				break;
			}
			else if (code.equals("99")) {
				break;
			}
		}
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
