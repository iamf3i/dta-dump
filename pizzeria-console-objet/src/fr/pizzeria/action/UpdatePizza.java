package fr.pizzeria.action;

public class UpdatePizza extends Action {

	public UpdatePizza() {
		super();
		this.setDescription("3. Mettre � jour une pizza");
	}

	@Override
	public void do_action() {
		System.out.println("JE MODIFIE UNE PIZZA :D YOLOOOOO :O");
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
