package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.exception.UpdatePizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * 
 * @author ETY5
 *
 */
@Controller
public class UpdatePizza extends Action {

	@Autowired
	Scanner reader;

	@Autowired
	PizzaDao pizzaDao;

	/**
	 * 
	 * @param
	 */
	public UpdatePizza() {
		super();
		this.setDescription("3. Mettre à jour une pizza");
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
