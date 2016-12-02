package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoArray implements PizzaDao {

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoArray() {
		super();

		pizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.POISSON));
		pizzas.add(new Pizza(6, "ORI", "L’orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(7, "IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		if (pizza == null) {
			throw new SavePizzaException("Error: ");
		}

		pizzas.add(pizza);
		Pizza.nbPizzas++;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {

		if (codePizza == null) {
			throw new DeletePizzaException("Error: ");
		}

		Pizza.nbPizzas--;
		return true;
	}

	@Override
	public Optional<Pizza> getPizzaIdFromCode(String codePizza) {
		//
		// for (int i = 0; i < this.pizzas.size(); ++i) {
		// if (this.pizzas.get(i).getCode().equals(codePizza)) {
		// return this.pizzas.get(i).getId();
		// }
		// }

		return this.pizzas.stream().filter(p -> p.getId() == Integer.parseInt(codePizza)).findFirst();
	}
}
