package fr.pizzeria.admin.service;

import fr.dta.pizzeria.model.Pizza;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class PizzaServiceEJB {

    @PersistenceContext(name=("PizzaService"))
    EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Pizza> findAllPizzas() {

        TypedQuery<Pizza> pizzas = em.createQuery("SELECT p from Pizza p", Pizza.class);
        System.out.println(em.find(Pizza.class, 1));
        return pizzas.getResultList();
    }
}
