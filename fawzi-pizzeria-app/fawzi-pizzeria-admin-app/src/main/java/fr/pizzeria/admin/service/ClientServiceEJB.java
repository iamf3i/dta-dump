package fr.pizzeria.admin.service;

import fr.dta.pizzeria.model.Client;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ClientServiceEJB {

    @PersistenceContext(name=("ClientService"))
    EntityManager em;

    public List<Client> findAllClients() {

        TypedQuery<Client> clients = em.createQuery("SELECT c from Client c", Client.class);
        return clients.getResultList();
    }

    public boolean saveClient(Client c) {

        em.persist(c);
        return true;
    }

    public Client getById(int id) {

        return em.find(Client.class, id);
    }

    public boolean deleteById(int id) {

        em.remove(em.find(Client.class, id));
        return true;
    }

    public boolean putClient(int id, Client c) {

        Client old = em.find(Client.class, id);

        old.setNom(c.getNom());
        old.setMotDePasse(c.getMotDePasse());
        old.setPrenom(c.getPrenom());
        em.persist(old);

        return true;
    }
}
