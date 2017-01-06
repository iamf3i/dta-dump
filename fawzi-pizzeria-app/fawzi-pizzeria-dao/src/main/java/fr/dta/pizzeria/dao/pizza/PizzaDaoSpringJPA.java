package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by Fawzi NASSIM on 06/01/2017.
 */
@Repository
@Transactional
public class PizzaDaoSpringJPA implements PizzaDao {

    @PersistenceContext(name=("PizzaService"))
    EntityManager em;

    @Override
    public List<Pizza> findAllPizzas() throws PizzaException {

        TypedQuery<Pizza> q = this.em.createQuery("SELECT p from Pizza p", Pizza.class);

        List<Pizza> pizzas = q.getResultList();

        return pizzas;
    }

    @Override
    public boolean saveNewPizza(Pizza pizza) throws PizzaException {
        this.em.persist(pizza);

        return true;
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
}
