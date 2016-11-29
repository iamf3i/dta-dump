package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;

public class ExitMenu extends Action {

	
	public ExitMenu() {
		super();
		this.setDescription("99. Sortir");
	}

	@Override
	public void doAction() {
		System.out.println("AU REVOIR :'(");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
