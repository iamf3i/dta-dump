package fr.dta.pizzeria.console;

import fr.dta.pizzeria.console.ihm.action.*;
import fr.dta.pizzeria.dao.pizza.PizzaDao;
import fr.dta.pizzeria.dao.pizza.PizzaDaoJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ETY5 on 04/01/2017.
 */
@Configuration
@ComponentScan("fr.dta.pizzeria.console")
public class PizzeriaAppSpringConfig {

    @Bean
    public PizzaDao getDao(){
        return new PizzaDaoJDBC();
    }

    @Bean
    public Scanner getScanner(){
        return new Scanner(System.in);
    }

    @Bean
    public Map<Integer, Action> getActionList(ApplicationContext context) {

        Map<Integer, Action> menu = new HashMap<Integer, Action>();

        menu.put(1, context.getBean(ListPizza.class));
        menu.put(2, context.getBean(AddPizza.class));
        menu.put(3, context.getBean(UpdatePizza.class));
        menu.put(4, context.getBean(DeletePizza.class));
        menu.put(5, context.getBean(ListPizzaFromCat.class));
        menu.put(6, context.getBean(ShowMostExpensivePizza.class));
        menu.put(7, context.getBean(MigrateFilesToDB.class));
        menu.put(8, context.getBean(ExitMenu.class));

        return menu;
    }
}
