package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.action.Action;
import fr.pizzeria.action.AddPizza;
import fr.pizzeria.action.DeletePizza;
import fr.pizzeria.action.ExitMenu;
import fr.pizzeria.action.ListPizza;
import fr.pizzeria.action.UpdatePizza;

public class MainMenu {

	Action[] menu = new Action[5];
	Scanner reader = new Scanner(System.in);

	public MainMenu() {

		this.menu[0] = new ListPizza();
		this.menu[1] = new AddPizza();
		this.menu[2] = new UpdatePizza();
		this.menu[3] = new DeletePizza();
		this.menu[4] = new ExitMenu();
	}

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describe_action();
		}
	}
	
	private void parseAndExec() {

		String input = reader.next();

		if (Integer.parseInt(input) < menu.length)
			this.menu[Integer.parseInt(input) - 1].do_action();
		else if (Integer.parseInt(input) == 99) {
			this.menu[4].do_action();
		}
	}

	public void start(){

		while (true) {
			this.displayMenu();
			this.parseAndExec();
		}
	}
}