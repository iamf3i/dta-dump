package fr.dta.pizzeria.dao.pizza;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;

public class PizzaDaoJPA implements PizzaDao {

	EntityManagerFactory emf;
	EntityManager em;

	public PizzaDaoJPA() {
		super();
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.emf = Persistence.createEntityManagerFactory("JPAUNIT");
		this.em = this.emf.createEntityManager();
	}

	@Override
	public List<Pizza> findAllPizzas() throws PizzaException {

		TypedQuery<Pizza> q = this.em.createQuery("SELECT p from Pizza p", Pizza.class);

		List<Pizza> pizzas = q.getResultList();

		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws PizzaException {

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
	public void closeResources() {
		try {
			this.em.close();
			this.emf.close();
		} finally {

		}
	}

}
