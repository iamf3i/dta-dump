package fr.dta.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livreur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String nom;
	String prenom;

	@OneToMany(mappedBy = "livreur")
	private Set<Commande> commandes;
}
