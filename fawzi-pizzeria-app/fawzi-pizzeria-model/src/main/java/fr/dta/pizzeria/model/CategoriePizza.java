package fr.dta.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans_Viande");

	@SuppressWarnings("unused")
	private String cat;

	private CategoriePizza(String categorie) {
		this.cat = categorie;
	}

}
