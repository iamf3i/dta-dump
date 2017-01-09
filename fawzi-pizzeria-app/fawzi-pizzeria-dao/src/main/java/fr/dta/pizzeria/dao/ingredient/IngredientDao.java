package fr.dta.pizzeria.dao.ingredient;

import fr.dta.pizzeria.dao.exception.MigrateFilesToDBException;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientDao {

	List<Ingredient> findAllIngredients();

	boolean saveNewIngredient(Ingredient ing);

	boolean updateIngredient(String codeIng, Ingredient ing);

	boolean deleteIngredient(String codeIng);

	Ingredient getIngredientFromId(int id);

	Optional<Ingredient> getIngredientIdFromCode(String codeIng);

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
