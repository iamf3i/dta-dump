package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoArray implements PizzaDao {

	private Pizza[] pizzas = {
			new Pizza(0, "PEP", "Pépéroni", 12.50),
			new Pizza(1, "MAR", "Margherita", 14.00),
			new Pizza(2, "REI", "La Reine", 11.50),
			new Pizza(3, "FRO", "La 4 fromages", 12.00),
			new Pizza(4, "CAN", "La cannibale", 12.50),
			new Pizza(5, "SAV", "La savoyarde", 13.00),
			new Pizza(6, "ORI", "L’orientale", 13.50),
			new Pizza(7, "IND", "L’indienne", 14.00),
	};

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {

		Pizza[] newMenu = new Pizza[pizzas.length + 1];

		for (int i = 0; i < pizzas.length; ++i) {
			newMenu[i] = new Pizza();
			newMenu[i].setId(pizzas[i].getId());
			newMenu[i].setCode(pizzas[i].getCode());
			newMenu[i].setNom(pizzas[i].getNom());
			newMenu[i].setPrix(pizzas[i].getPrix());
		}

		newMenu[pizzas.length] = new Pizza();
		newMenu[pizzas.length].setId(pizza.getId());
		newMenu[pizzas.length].setCode(pizza.getCode());
		newMenu[pizzas.length].setNom(pizza.getNom());
		newMenu[pizzas.length].setPrix(pizza.getPrix());

		pizzas = newMenu;
		Pizza.nbPizzas++;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {

		Pizza[] newMenu = new Pizza[pizzas.length - 1];

		for (int i = 0; i < pizzas.length - 1; i++) {

			if (!codePizza.equals(pizzas[i].getCode())) {
				newMenu[i] = new Pizza();
				newMenu[i].setId(pizzas[i].getId());
				newMenu[i].setCode(pizzas[i].getCode());
				newMenu[i].setNom(pizzas[i].getNom());
				newMenu[i].setPrix(pizzas[i].getPrix());
			}
		}

		pizzas = newMenu;

		Pizza.nbPizzas--;
		return true;
	}

	@Override
	public int getPizzaIdFromCode(String codePizza) {

		for (int i = 0; i < this.pizzas.length; ++i) {
			if (this.pizzas[i].getCode().equals(codePizza)) {
				return this.pizzas[i].getId();
			}
		}
		return -1;
	}
}
