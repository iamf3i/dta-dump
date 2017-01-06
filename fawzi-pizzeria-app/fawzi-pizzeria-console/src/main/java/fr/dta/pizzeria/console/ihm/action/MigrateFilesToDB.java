package fr.dta.pizzeria.console.ihm.action;

import fr.dta.pizzeria.dao.exception.PizzaException;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MigrateFilesToDB extends Action {

    @Qualifier("enabled")
    @Autowired
    PizzaDao dao;

    @Override
    public void doAction() throws PizzaException {

        dao.migrateFilesToDB();
    }

    @Override
    public void describeAction() {
        System.out.println(this.getDescription());
    }

    public MigrateFilesToDB() {
        super();
        this.setDescription("7. (Base de données) Importer les données");
    }
}
