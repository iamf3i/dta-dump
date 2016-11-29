package fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String nom;
	private Double prix;
	private CategoriePizza cat;
	public static int nbPizzas;

	public Pizza() {
		super();
	}

	public Pizza(int id, String code, String nom, double prix, CategoriePizza cat) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Pizza [code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
