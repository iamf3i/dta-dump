package fr.dta.pizzeria.console.ihm.action;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.CategoriePizza;
import fr.dta.pizzeria.model.Pizza;

public class ListPizzaFromCat extends Action {

	private IhmUtil utils;
	private PizzaDao pizzaDao;

	@Override
	public void doAction() throws PizzaException {
		Map<CategoriePizza, List<Pizza>> pizzas = pizzaDao.findAllPizzas().stream()
				.collect(Collectors.groupingBy(Pizza::getCat));
		pizzas.entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

	public ListPizzaFromCat(IhmUtil utils) {
		super();
		this.utils = utils;
		this.setDescription("5. Lister les pizzas group�es par cat�gorie");
		this.pizzaDao = utils.getPizzaDao();
	}

}
