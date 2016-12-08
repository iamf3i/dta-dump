package fr.dta.pizzeria.dao;

import fr.dta.pizzeria.dao.pizza.PizzaDaoJDBC;

public class JDBCDaoFactory extends DaoFactory {

	public JDBCDaoFactory() {
		super(new PizzaDaoJDBC());
	}
}
