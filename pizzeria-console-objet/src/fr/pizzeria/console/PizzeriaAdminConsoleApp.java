package fr.pizzeria.console;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	/*
	 *	Ci-dessous les variables sont déclarées en "Global"
	 *	Cela permet d'y accéder à partir de n'importe quelle fonction
	 */
	public static String[] menu = {							// Phrases du menu principal
			"***** Pizzeria Administration *****",
			"1. Lister les pizzas",
			"2. Ajouter une nouvelle pizza",
			"3. Mettre à jour une pizza",
			"4. Supprimer une pizza",
			"99. Sortir",
	};
	public static Scanner reader = new Scanner(System.in);  // Déclaration du "Reader" pour les saisies utilisateur
	public static Pizza[] pizzas = new Pizza[8];			// Tableau répertoriant les pizzas


	/**
	 * Recopie intégralement le tableau de pizzas
	 * En y ajoutant la pizza passée en paramètre
	 * La copie du tableau est alors affectée au tableau initial
	 * Cela permet la création
	 * @param newPizza
	 */
	public static void pushPizzaToArray(Pizza newPizza) {

		Pizza[] newMenu = new Pizza[pizzas.length + 1];

		for (int i = 0; i < pizzas.length; ++i) {
			newMenu[i] = new Pizza();
			newMenu[i].id = pizzas[i].id;
			newMenu[i].code = pizzas[i].code;
			newMenu[i].nom = pizzas[i].nom;
			newMenu[i].prix = pizzas[i].prix;
		}

		newMenu[pizzas.length] = new Pizza();
		newMenu[pizzas.length].id = pizzas.length;
		newMenu[pizzas.length].code = newPizza.code;
		newMenu[pizzas.length].nom = newPizza.nom;
		newMenu[pizzas.length].prix = newPizza.prix;

		pizzas = newMenu;
	}

	/**
	 * Recopie intégralement le tableau de pizzas
	 * En laissant de côté la pizza dont le code est passé en paramètre
	 * La copie du tableau est alors affectée au tableau initial
	 * Cela permet la suppression
	 * @param code
	 */
	public static void removePizzaFromArray(String code) {

		Pizza[] newMenu = new Pizza[pizzas.length - 1];

		int index = 0;
		for (int i = 0; i < pizzas.length; i++) {

			if (!code.equals(pizzas[i].code)) {
				newMenu[index].id = pizzas[i].id;
				newMenu[index].code = pizzas[i].code;
				newMenu[index].nom = pizzas[i].nom;
				newMenu[index].prix = pizzas[i].prix;
			}
		}
		pizzas = newMenu;
	}

	/**
	 * Une fonction utile qui va permettre d'afficher le tableau de pizzas
	 * Formaté en fonction des paramètres
	 * @param initial
	 * @param action
	 */
	public static void printPizzaList(boolean initial, String action) {

		if (initial) {
			for (Pizza p: pizzas)
			{
				System.out.println(p.code + " -> " + p.nom + " (" + p.prix + " €)");
			}	
		}
		else {
			for (Pizza p: pizzas)
			{
				System.out.println(p.code + " - " + p.nom + " (" + p.prix + " €)");
			}
			System.out.println("Veuillez choisir la pizza à " + action + ".");
			System.out.println("(99 pour abandonner).");
		}
	}

	/**
	 * La fonction qui va lancer la création d'une pizza
	 */
	public static void createPizza() {

		System.out.println("Veuillez saisir le code");
		String code = reader.next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = reader.next();

		System.out.println("Veuillez saisir le prix");
		String price = reader.next();

		Pizza newPizza = new Pizza();
		newPizza.code = code;
		newPizza.nom = name;
		newPizza.prix = Double.parseDouble(price);
		pushPizzaToArray(newPizza);
	}

	/**
	 * Une fonction utile qui récupère l'ID d'une pizza dans le tableau
	 * en fonction de son code
	 * @param code
	 * @return
	 */
	public static int getIdFromCode(String code) {

		for(int i = 0; i < pizzas.length; i++) {
			if (pizzas[i].code.equals(code))
				return pizzas[i].id;
		}

		return -1;	
	}

	/**
	 * La fonction qui affiche le menu de modification des pizzas en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void updatePizza() {

		while (true) {
			printPizzaList(false, "modifier");

			String code = reader.next();
			int pizzaId = getIdFromCode(code);

			if (pizzaId != -1) {
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next();
				pizzas[pizzaId].code = newCode;

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizzas[pizzaId].nom = name;

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				pizzas[pizzaId].prix = Double.parseDouble(price);

				break;
			}
			else if (code.equals("99")) {
				break;
			}
		}	
	}

	/**
	 * La fonction qui affiche le menu de suppression des pizzas en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void deletePizza() {

		while (true) {
			printPizzaList(false, "supprimer");

			String code = reader.next();

			if (code.equals("99")) {
				break;
			}
			else if (getIdFromCode(code) != -1) {
				removePizzaFromArray(code);
				break;
			}
		}
	}

	/**
	 * Affichage du message de fin de programme
	 */
	public static void printBye() {
		System.out.println("Aurevoir :(");
	}

	/**
	 * La fonction qui affiche le menu principal en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void printMenu() {

		boolean flag = false;

		while (true) {
			for (String s: menu)
			{
				System.out.println(s);
			}

			int choice = reader.nextInt();

			switch (choice) {
			case 1:
				printPizzaList(true, null);
				break;
			case 2:
				createPizza();
				break;
			case 3:
				updatePizza();
				break;
			case 4:
				deletePizza();
				break;
			case 99:
				printBye();
				flag = true;
				break;
			}
			if (flag) {
				reader.close();
				break;
			}
		}
	}

	public static void initPizzas() {
		
		String[][] pizzas = {
				{"0", "PEP", "Pépéroni", "12.50"},
				{"1", "MAR", "Margherita", "14.00"},
				{"2", "REI", "La Reine", "11.50"},
				{"3", "FRO", "La 4 fromages", "12.00"},
				{"4", "CAN", "La cannibale", "12.50"},
				{"5", "SAV", "La savoyarde", "13.00"},
				{"6", "ORI", "L’orientale", "13.50"},
				{"7", "IND", "L’indienne", "14.00"},
		};
		
		int i = 0;
		for (String[] p: pizzas)
		{
			Pizza newPizza = new Pizza();
			newPizza.id = Integer.parseInt(p[0]);
			newPizza.code = p[1];
			newPizza.nom = p[2];
			newPizza.prix = Double.parseDouble(p[3]);
			PizzeriaAdminConsoleApp.pizzas[i] = newPizza;
			i++;
		}
	}

	/**
	 * Point d'entrée du programme
	 * On execute la fonction qui va afficher le menu principal
	 * en boucle
	 * @param args
	 */
	public static void main(String[] args) {
		initPizzas();
		printMenu();
	}
}
