package fr.pizzeria.dao.pizza;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao {

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {

		List<Pizza> ret = new ArrayList<Pizza>();
		File dir = new File("C:\\Users\\ETY5\\Documents\\WORKSPACE\\src\\pizzeria-console-objet\\data");

		dir.mkdir();

		if (dir.exists()) {
			File[] directoryListing = dir.listFiles();

			if (directoryListing != null) {
				int i = 0;
				for (File child : directoryListing) {
					// System.out.println(i++);
					Pizza p = new Pizza();
					p.setId(i++);
					Properties props = new Properties();
					try {
						props.load(new FileInputStream(child));
					} catch (IOException e) {
						throw new PizzaException("InputStream: Fail");
					}
					p.setCode(props.getProperty("code"));
					p.setNom(props.getProperty("nom"));
					p.setPrix(Double.parseDouble(props.getProperty("prix")));
					ret.add(p);
				}
			} else
				return null;
		}

		return ret;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws PizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Pizza> getPizzaIdFromCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

}
