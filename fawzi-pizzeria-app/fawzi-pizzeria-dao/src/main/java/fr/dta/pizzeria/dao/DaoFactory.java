package fr.dta.pizzeria.dao;

import fr.dta.pizzeria.dao.pizza.PizzaDao;

public abstract class DaoFactory {

	PizzaDao pizzaDao;

	public DaoFactory(PizzaDao pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}
}
