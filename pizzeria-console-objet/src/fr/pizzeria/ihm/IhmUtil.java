package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class IhmUtil {

	private Scanner scanner;
	private PizzaDao pizzaDao;

	public IhmUtil(Scanner scanner, PizzaDao pizzaDao) {

		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

}
