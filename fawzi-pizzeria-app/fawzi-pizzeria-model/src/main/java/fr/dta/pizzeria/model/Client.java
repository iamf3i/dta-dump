package fr.dta.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String nom;
	String prenom;
	@Column(name = "mot_de_passe")
	String motDePasse;

	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;
}
