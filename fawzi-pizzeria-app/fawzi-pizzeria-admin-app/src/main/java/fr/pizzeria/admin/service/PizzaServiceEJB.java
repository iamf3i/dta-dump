package fr.pizzeria.admin.service;

import fr.dta.pizzeria.model.Pizza;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PizzaServiceEJB {

    @PersistenceContext(name=("PizzaService"))
    EntityManager em;

    public List<Pizza> findAllPizzas() {

        TypedQuery<Pizza> pizzas = em.createQuery("SELECT p from Pizza p", Pizza.class);
        return pizzas.getResultList();
    }

    public boolean savePizza(Pizza p) {

        em.persist(p);
        return true;
    }

    public Pizza getById(int id) {

        return em.find(Pizza.class, id);
    }

    public boolean deleteById(int id) {

        em.remove(em.find(Pizza.class, id));
        return true;
    }

    public boolean putPizza(int id, Pizza p) {

        Pizza old = em.find(Pizza.class, id);

        old.setCat(p.getCat());
        old.setCode(p.getCode());
        old.setNom(p.getNom());
        old.setPrix(p.getPrix());
        em.persist(old);

        return true;
    }
}
