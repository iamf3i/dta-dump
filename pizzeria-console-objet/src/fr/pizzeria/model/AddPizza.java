package fr.pizzeria.model;

public class AddPizza extends Action {


	public AddPizza() {
		super();
		this.setDescription("2. Ajouter une nouvelle pizza");
	}

	@Override
	public void do_action() {

	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
