package fr.dta.pizzeria.client.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;

public abstract class Action {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void doAction() throws PizzaException;

	public abstract void describeAction();
}
