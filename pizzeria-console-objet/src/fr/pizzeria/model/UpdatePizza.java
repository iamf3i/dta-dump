package fr.pizzeria.model;

public class UpdatePizza extends Action {

	public UpdatePizza() {
		super();
		this.setDescription("3. Mettre � jour une pizza");
	}

	@Override
	public void do_action() {

	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
