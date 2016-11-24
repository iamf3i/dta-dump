package fr.pizzeria.console;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.plaf.synth.SynthSpinnerUI;

import fr.pizzeria.dao.PizzaDaoArray;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		IhmUtil utils = new IhmUtil(new Scanner(System.in), new PizzaDaoArray());
		MainMenu core = new MainMenu(utils);

		core.start();
	}
}
