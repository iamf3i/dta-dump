package fr.dta.pizzeria.dao;

import fr.dta.pizzeria.dao.pizza.PizzaDaoFichier;

public class FichierDaoFactory extends DaoFactory {

	public FichierDaoFactory() {
		super(new PizzaDaoFichier());
	}

}
