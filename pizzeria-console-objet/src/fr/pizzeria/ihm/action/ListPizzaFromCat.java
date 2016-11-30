package fr.pizzeria.ihm.action;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ListPizzaFromCat extends Action {

	private IhmUtil utils;
	private PizzaDao pizzaDao;

	@Override
	public void doAction() throws PizzaException {
		// TODO Auto-generated method stub
		Map<CategoriePizza, List<Pizza>> pizzas = pizzaDao.findAllPizzas().stream()
				.collect(Collectors.groupingBy(Pizza::getCat));
		pizzas.entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void describeAction() {
		// TODO Auto-generated method stub
		System.out.println(this.getDescription());
	}

	public ListPizzaFromCat(IhmUtil utils) {
		super();
		this.utils = utils;
		this.setDescription("5. Lister les pizzas groupées par catégorie");
		this.pizzaDao = utils.getPizzaDao();
	}

}
