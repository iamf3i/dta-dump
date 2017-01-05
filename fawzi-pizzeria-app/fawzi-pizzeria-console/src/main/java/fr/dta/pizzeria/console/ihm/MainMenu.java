package fr.dta.pizzeria.console.ihm;

import fr.dta.pizzeria.console.ihm.action.*;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Scanner;

@Controller
public class MainMenu implements Runnable {

    @Autowired
	Map<Integer, Action> menu;

    @Autowired
    PizzaDao dao;

	@Autowired
    ApplicationContext context;

	@Autowired
    Scanner scan;

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
		menu.entrySet().forEach(p -> p.getValue().describeAction());
	}

	private boolean parseAndExec() {

		try {
			String input = scan.next();
			if (Integer.parseInt(input) == 99) {
				this.menu.get(8).doAction();
				dao.closeResources(); // Will do nothing
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