package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.PizzaException;

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
