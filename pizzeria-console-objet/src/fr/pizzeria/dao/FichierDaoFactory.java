package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.PizzaDaoFichier;

public class FichierDaoFactory extends DaoFactory {

	public FichierDaoFactory() {
		super(new PizzaDaoFichier());
	}

}
