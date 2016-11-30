package fr.pizzeria.dao.pizza;

import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAllPizzas();

	boolean saveNewPizza(Pizza pizza) throws PizzaException;

	boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException;

	boolean deletePizza(String codePizza) throws PizzaException;

	Optional<Pizza> getPizzaIdFromCode(String codePizza);
}
