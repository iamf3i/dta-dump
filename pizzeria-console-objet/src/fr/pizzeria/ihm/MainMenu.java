package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu {

	Action[] menu = new Action[5];

	IhmUtil utils;

	public MainMenu(IhmUtil utils) {

		this.menu[0] = new ListPizza(utils);
		this.menu[1] = new AddPizza(utils);
		this.menu[2] = new UpdatePizza(utils);
		this.menu[3] = new DeletePizza(utils);
		this.menu[4] = new ExitMenu();

		this.utils = utils;
	}

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describe_action();
		}
	}

	private boolean parseAndExec() {

		String input = utils.getScanner().next();

		if (Integer.parseInt(input) < menu.length) {
			this.menu[Integer.parseInt(input) - 1].do_action();
			return true;
		}
		else if (Integer.parseInt(input) == 99)
			this.menu[4].do_action();
		return false;
	}

	public void start(){

		do {
			this.displayMenu();
		} while (this.parseAndExec());
	}
}