package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.model.CategoriePizza;
import fr.dta.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ETY5
 */
@Controller
public class ListPizzaFromCat extends Action {

    @Qualifier("enabled")
    @Autowired
    private PizzaDao pizzaDao;

    /**
     * @param
     */
    public ListPizzaFromCat() {
        super();
        this.setDescription("5. Lister les pizzas groupées par catégorie");
    }

    @Override
    public void doAction() throws PizzaException {
        Map<CategoriePizza, List<Pizza>> pizzas = pizzaDao.findAllPizzas().stream()
                .collect(Collectors.groupingBy(Pizza::getCat));
        pizzas.entrySet().stream().forEach(System.out::println);
    }

    @Override
    public void describeAction() {
        System.out.println(this.getDescription());
    }

}
