package fr.dta.pizzeria.client;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.dta.pizzeria.client.ihm.IhmUtil;
import fr.dta.pizzeria.client.ihm.MainMenu;
import fr.dta.pizzeria.dao.DaoFactory;

public class PizzeriaClientConsoleApp {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		DaoFactory daoFactory = (DaoFactory) Class.forName(daoConfig).newInstance();

		IhmUtil utils = new IhmUtil(new Scanner(System.in), daoFactory);
		MainMenu core = new MainMenu(utils);

		core.run();
	}
}
