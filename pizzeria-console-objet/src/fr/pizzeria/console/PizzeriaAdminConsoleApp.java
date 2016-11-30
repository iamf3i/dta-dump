package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.ArrayDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		IhmUtil utils = new IhmUtil(new Scanner(System.in), new ArrayDaoFactory());
		MainMenu core = new MainMenu(utils);

		core.run();
	}
}
