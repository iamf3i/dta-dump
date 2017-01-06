package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Fawzi NASSIM on 06/01/2017.
 */
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
