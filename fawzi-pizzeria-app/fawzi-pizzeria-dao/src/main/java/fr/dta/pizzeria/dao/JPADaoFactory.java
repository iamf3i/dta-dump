package fr.dta.pizzeria.dao;

import fr.dta.pizzeria.dao.pizza.PizzaDaoJPA;

public class JPADaoFactory extends DaoFactory {

	public JPADaoFactory() {
		super(new PizzaDaoJPA());
	}
}
