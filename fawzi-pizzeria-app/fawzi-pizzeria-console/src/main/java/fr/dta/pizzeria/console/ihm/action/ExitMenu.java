package fr.dta.pizzeria.console.ihm.action;

import org.springframework.stereotype.Controller;

@Controller
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
