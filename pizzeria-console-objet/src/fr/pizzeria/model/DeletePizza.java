package fr.pizzeria.model;

public class DeletePizza extends Action {

	
	public DeletePizza() {
		super();
		this.setDescription("4. Supprimer une pizza");
	}

	@Override
	public void do_action() {
		System.out.println("JE SUPPRIME UNE PIZZA :D");
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
