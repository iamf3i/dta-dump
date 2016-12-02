package fr.pizzeria.ihm.action;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ShowMostExpensivePizza extends Action {

	private PizzaDao pizzaDao;

	@Override
	public void doAction() throws PizzaException {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();

		final Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Pizza expensive = pizzas.stream().max(comp).get();

		System.out.println(expensive);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

	public ShowMostExpensivePizza(IhmUtil utils) {
		super();
		this.setDescription("6. Afficher la pizza au tarif le plus élevé");
		this.pizzaDao = utils.getPizzaDao();
	}

}
