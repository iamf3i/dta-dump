package fr.pizzeria.ihm;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;
import fr.pizzeria.model.Pizza;

public class MainMenu {

	Map<Integer, Action> menu = new HashMap<Integer, Action>();

	IhmUtil utils;

	public MainMenu(IhmUtil utils) {

		this.menu.put(1, new ListPizza(utils));
		this.menu.put(2, new AddPizza(utils));
		this.menu.put(3, new UpdatePizza(utils));
		this.menu.put(4, new DeletePizza(utils));
		this.menu.put(5, new ExitMenu());

		this.utils = utils;
	}

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		for (Entry<Integer, Action> entry : menu.entrySet()) {
			entry.getValue().describe_action();
		}
	}

	private boolean parseAndExec() {

		try {
			String input = utils.getScanner().next();
			if (Integer.parseInt(input) == 99)
				this.menu.get(4).do_action();
			else
				this.menu.get(Integer.parseInt(input)).do_action();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void start(){

		do {
			this.displayMenu();
		} while (this.parseAndExec());
	}
}