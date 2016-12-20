package fr.dta.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.dta.pizzeria.console.ihm.IhmUtil;
import fr.dta.pizzeria.console.ihm.MainMenu;
import fr.dta.pizzeria.dao.DaoFactory;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		System.out.println(Class.forName(daoConfig));
		DaoFactory daoFactory = (DaoFactory) Class.forName(daoConfig).newInstance();

		IhmUtil utils = new IhmUtil(new Scanner(System.in), daoFactory);
		MainMenu core = new MainMenu(utils);

		core.run();
	}
}
