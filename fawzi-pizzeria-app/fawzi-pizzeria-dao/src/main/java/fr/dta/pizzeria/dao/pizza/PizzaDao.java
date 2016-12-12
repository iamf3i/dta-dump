package fr.dta.pizzeria.dao.pizza;

import java.util.List;
import java.util.Optional;

import fr.dta.pizzeria.dao.exception.MigrateFilesToDBException;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAllPizzas() throws PizzaException;

	boolean saveNewPizza(Pizza pizza) throws PizzaException;

	boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException;

	boolean deletePizza(String codePizza) throws PizzaException;

	Optional<Pizza> getPizzaIdFromCode(String codePizza);

	default void migrateFilesToDB() throws PizzaException {
		throw new MigrateFilesToDBException(
				"Veuillez configurer l’application avec une implémentation base de données");
	}

	/**
	 * Do nothing for pizza Daos with no resources
	 */
	default void closeResources() {
	}
}
