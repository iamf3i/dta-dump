package fr.dta.pizzeria.console.ihm;

import fr.dta.pizzeria.dao.DaoFactory;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class IhmUtil {

    @Autowired
    private Scanner scanner;

    @Autowired
	private DaoFactory pizzaDaoFactory;

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
