package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	Pizza[]	findAllPizzas();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(String codePizza);

	int getPizzaIdFromCode(String codePizza);
}
