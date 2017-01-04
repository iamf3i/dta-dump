package fr.dta.pizzeria.console.ihm;

import fr.dta.pizzeria.dao.DaoFactory;
import fr.dta.pizzeria.dao.pizza.PizzaDao;

import java.util.Scanner;

public class IhmUtil {

	private Scanner scanner;
	private DaoFactory pizzaDaoFactory;

	public IhmUtil(Scanner scanner, DaoFactory pizzaDao) {

		this.scanner = scanner;
		this.pizzaDaoFactory = pizzaDao;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PizzaDao getPizzaDao() {
		return pizzaDaoFactory.getPizzaDao();
	}

	public void setPizzaDao(DaoFactory pizzaDao) {
		this.pizzaDaoFactory = pizzaDao;
	}
}
