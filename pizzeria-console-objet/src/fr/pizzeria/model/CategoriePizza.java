package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String cat;

	private CategoriePizza(String catégorie) {
		this.cat = catégorie;
	}

}
