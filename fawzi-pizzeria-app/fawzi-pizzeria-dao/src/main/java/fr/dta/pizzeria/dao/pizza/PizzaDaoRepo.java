package fr.dta.pizzeria.dao.pizza;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Fawzi NASSIM on 06/01/2017.
 */
@Repository
public class PizzaDaoRepo implements PizzaDao {


    @Autowired
    PizzaRepository dao;

    @Override
    public List<Pizza> findAllPizzas() throws PizzaException {
        return dao.findAll();
    }

    @Override
    public boolean saveNewPizza(Pizza pizza) throws PizzaException {
       dao.save(pizza);
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
}
