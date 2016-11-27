package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.SavePizzaException;

public abstract class Action {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void do_action() throws PizzaException;
	public abstract void describe_action();
}
