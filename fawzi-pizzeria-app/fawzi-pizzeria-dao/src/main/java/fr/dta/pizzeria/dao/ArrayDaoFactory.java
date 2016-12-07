package fr.dta.pizzeria.dao;

import fr.dta.pizzeria.dao.pizza.PizzaDaoArray;

public class ArrayDaoFactory extends DaoFactory {

	public ArrayDaoFactory() {
		super(new PizzaDaoArray());
	}
}
