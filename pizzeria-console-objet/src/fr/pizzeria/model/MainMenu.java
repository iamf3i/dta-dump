package fr.pizzeria.model;
import java.util.Scanner;

import fr.pizzeria.model.Action;

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

	public void displayMenu() {
		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describe_action();
		}
	}
	
	public void parseAndExec() {
		String input = reader.next();

		if (Integer.parseInt(input) < 4)
			this.menu[Integer.parseInt(input) - 1].do_action();
		else if (Integer.parseInt(input) == 99) {
			this.menu[4].do_action();
		}
	}
}
