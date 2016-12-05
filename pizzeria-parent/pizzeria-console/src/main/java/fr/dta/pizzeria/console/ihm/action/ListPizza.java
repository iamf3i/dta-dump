package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;

public class ListPizza extends Action {

	private IhmUtil utils;

	public ListPizza(IhmUtil utils) {
		super();
		this.setDescription("1. Lister les pizzas");
		this.utils = utils;
	}

	@Override
	public void doAction() throws PizzaException {

		for (Pizza p : utils.getPizzaDao().findAllPizzas()) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + " €)");
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
