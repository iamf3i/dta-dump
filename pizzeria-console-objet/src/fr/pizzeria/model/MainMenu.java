package fr.pizzeria.model;
import fr.pizzeria.model.Action;

public class MainMenu {

	Action[] menu = new Action[5];

	MainMenu() {

		this.menu[0] = new ListPizza();
		this.menu[1] = new AddPizza();
		this.menu[2] = new UpdatePizza();
		this.menu[3] = new DeletePizza();
		this.menu[4] = new ExitMenu();
	}

}
