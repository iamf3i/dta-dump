package fr.dta.pizzeria.console.ihm.action;

import java.util.Scanner;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.exception.UpdatePizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;

/**
 * 
 * @author ETY5
 *
 */
public class UpdatePizza extends Action {

	private Scanner reader;
	private PizzaDao pizzaDao;

	/**
	 * 
	 * @param utils
	 */
	public UpdatePizza(IhmUtil utils) {
		super();
		this.setDescription("3. Mettre à jour une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() throws PizzaException {

		for (Pizza p : pizzaDao.findAllPizzas()) {
			System.out.println(p.getCode() + " - " + p.getNom() + " (" + p.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir la pizza à modifier.");
		System.out.println("(99 pour abandonner).");
	}

	@Override
	public void doAction() throws PizzaException {

		boolean flag = true;

		while (flag) {
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
				} catch (NumberFormatException e) {
					throw new UpdatePizzaException(e.getMessage());
				}
				flag = false;
			} else if (("99").equals(code)) {
				flag = false;
			}
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
