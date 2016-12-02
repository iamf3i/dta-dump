package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.ListPizzaFromCat;
import fr.pizzeria.ihm.action.ShowMostExpensivePizza;
import fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu implements Runnable {

	Map<Integer, Action> menu = new HashMap<Integer, Action>();

	IhmUtil utils;

	public MainMenu(IhmUtil utils) {

		this.menu.put(1, new ListPizza(utils));
		this.menu.put(2, new AddPizza(utils));
		this.menu.put(3, new UpdatePizza(utils));
		this.menu.put(4, new DeletePizza(utils));
		this.menu.put(5, new ListPizzaFromCat(utils));
		this.menu.put(6, new ShowMostExpensivePizza(utils));
		this.menu.put(7, new ExitMenu());

		this.utils = utils;
	}

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		menu.entrySet().forEach(p -> p.getValue().describeAction());
	}

	private boolean parseAndExec() {

		try {
			String input = utils.getScanner().next();
			if (Integer.parseInt(input) == 99) {
				this.menu.get(7).doAction();
				return false;
			} else if (Integer.parseInt(input) <= 7 && Integer.parseInt(input) > 0)
				this.menu.get(Integer.parseInt(input)).doAction();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public void run() {

		do {
			this.displayMenu();
		} while (this.parseAndExec());
	}
}