package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class ShowMostExpensivePizza extends Action {

	@Autowired
	PizzaDao dao;

	@Override
	public void doAction() throws PizzaException {
		List<Pizza> pizzas = dao.findAllPizzas();

		final Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Pizza expensive = pizzas.stream().max(comp).get();

		System.out.println(expensive);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

	public ShowMostExpensivePizza() {
		super();
		this.setDescription("6. Afficher la pizza au tarif le plus élevé");
	}

}
