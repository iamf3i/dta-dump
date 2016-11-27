package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza>	findAllPizzas();
	boolean saveNewPizza(Pizza pizza) throws PizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException;
	boolean deletePizza(String codePizza) throws PizzaException;

	int getPizzaIdFromCode(String codePizza);
}
