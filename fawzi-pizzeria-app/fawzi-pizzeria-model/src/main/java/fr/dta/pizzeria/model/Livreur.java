package fr.dta.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livreur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String nom;
	String prenom;

}
