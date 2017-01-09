package fr.dta.pizzeria.model;

import javax.persistence.*;

/**
 * Created by Fawzi NASSIM on 09/01/2017.
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private Double prix;
    private Integer qte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
