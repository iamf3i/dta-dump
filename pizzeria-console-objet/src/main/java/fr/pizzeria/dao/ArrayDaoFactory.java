package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoArray;

public class ArrayDaoFactory extends DaoFactory {

	public ArrayDaoFactory() {
		super(new PizzaDaoArray());
	}
}
