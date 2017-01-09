package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.CategoriePizza;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PizzaDaoJDBC implements PizzaDao {

	private Connection connection;
	private Statement statement;

	public PizzaDaoJDBC() {
		super();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "");
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {

		List<Pizza> ret = new ArrayList<Pizza>();
		ResultSet result;

		try {
			result = statement.executeQuery("SELECT * FROM PIZZA");

			while (result.next()) {
				int id = result.getInt("ID");
				String nom = result.getString("NOM");
				String code = result.getString("CODE");
				Double prix = result.getDouble("PRIX");
				CategoriePizza cat = CategoriePizza.valueOf(result.getString("CATEGORIE"));

				Pizza newPizza = new Pizza();
				newPizza.setId(id);
				newPizza.setNom(nom);
				newPizza.setCode(code);
				newPizza.setPrix(prix);
				newPizza.setCat(cat);

				ret.add(newPizza);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws PizzaException {
		try {
			String req = "INSERT INTO `pizza` (`NOM`, `CATEGORIE`, `PRIX`, `CODE`) VALUES ('" + pizza.getNom() + "', '"
					+ pizza.getCat().toString() + "', " + pizza.getPrix() + ", '" + pizza.getCode() + "');";

			System.out.println(req); // Testing purpose

			Integer nbPizza = statement.executeUpdate(req);

			if (nbPizza != null)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws PizzaException {
		return false;
	}

	@Override
	public Optional<Pizza> getPizzaIdFromCode(String codePizza) {
		return null;
	}

	@Override
	public void migrateFilesToDB() throws PizzaException {

        PizzaDaoFichier dao = new PizzaDaoFichier();
		List<Pizza> pizzas = dao.findAllPizzas();

        System.out.println(pizzas.size());

        for (Pizza p : pizzas) {

			this.saveNewPizza(p);
		}
	}

}
