package fr.dta.pizzeria.client.ihm.action;

import fr.dta.pizzeria.client.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;

public class MigrateFilesToDB extends Action {

	private IhmUtil utils;

	@Override
	public void doAction() throws PizzaException {

		utils.getPizzaDao().migrateFilesToDB();
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

	public MigrateFilesToDB(IhmUtil utils) {
		super();
		this.setDescription("7. (Base de données) Importer les données");
		this.utils = utils;
	}
}
