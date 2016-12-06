package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;

public class AddPizza extends Action {

	private IhmUtil utils;

	public AddPizza(IhmUtil utils) {
		super();
		this.setDescription("2. Ajouter une nouvelle pizza");
		this.utils = utils;
	}

	@Override
	public void doAction() throws PizzaException {

		System.out.println("Veuillez saisir le code");
		String code = this.utils.getScanner().next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = this.utils.getScanner().next();

		System.out.println("Veuillez saisir le prix");
		String price = this.utils.getScanner().next();

		Pizza newPizza = new Pizza();
		newPizza.setId(this.utils.getPizzaDao().findAllPizzas().size());
		newPizza.setCode(code);
		newPizza.setNom(name);

		newPizza.setPrix(Double.parseDouble(price));
		utils.getPizzaDao().saveNewPizza(newPizza);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
