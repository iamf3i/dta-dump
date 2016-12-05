package fr.dta.pizzeria.console;

import java.util.Scanner;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.console.ihm.MainMenu;
import fr.dta.pizzeria.dao.ArrayDaoFactory;
import fr.dta.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		IhmUtil utils = new IhmUtil(new Scanner(System.in), new ArrayDaoFactory());
		MainMenu core = new MainMenu(utils);

		core.run();

		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		System.out.println("p1=p2 ? " + p1.equals(p2));
	}
}
