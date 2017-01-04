package fr.dta.pizzeria.console.ihm;

import fr.dta.pizzeria.console.ihm.action.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainMenu implements Runnable {

	Map<Integer, Action> menu = new HashMap<Integer, Action>();

	@Autowired
    IhmUtil utils;

    @PostConstruct
    public void init() {

        this.menu.put(1, new ListPizza(utils));
        this.menu.put(2, new AddPizza(utils));
        this.menu.put(3, new UpdatePizza(utils));
        this.menu.put(4, new DeletePizza(utils));
        this.menu.put(5, new ListPizzaFromCat(utils));
        this.menu.put(6, new ShowMostExpensivePizza(utils));
        this.menu.put(7, new MigrateFilesToDB(utils));
        this.menu.put(8, new ExitMenu());
    }

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		menu.entrySet().forEach(p -> p.getValue().describeAction());
	}

	private boolean parseAndExec() {

		try {
			String input = utils.getScanner().next();
			if (Integer.parseInt(input) == 99) {
				this.menu.get(8).doAction();
				this.utils.getPizzaDao().closeResources(); // Will do nothing
															// for DAOs with no
															// resources
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