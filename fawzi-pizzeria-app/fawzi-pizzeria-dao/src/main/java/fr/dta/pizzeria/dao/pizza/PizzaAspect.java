package fr.dta.pizzeria.dao.pizza;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
@Aspect
@Component
public class PizzaAspect {

    @Before("execution(* fr.dta.pizzeria.dao.pizza.PizzaDao.findAll*(..))")
    private void toutesLesMethodesfindAll() {
        System.out.println("BEFORE FINDDDDDDD LOLZ");
    }

    @Before("execution(* fr.dta.pizzeria.dao.pizza.PizzaDao.saveNewPizza(..))")
    private void toutesLesMethodessaveNewPizza(JoinPoint jp) {

        System.out.println(jp.getArgs()[0]);

        System.out.println("BEFORE SAVE LOLZ");
    }
}