package fr.dta.pizzeria.dao.ingredient;

import fr.dta.pizzeria.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Fawzi NASSIM on 06/01/2017.
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
