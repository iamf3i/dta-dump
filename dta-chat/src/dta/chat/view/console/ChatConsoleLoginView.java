package dta.chat.view.console;

import dta.chat.view.ViewUtils;

public class ChatConsoleLoginView extends ViewComposite {

	private ViewUtils vu;
	private String username;

	public ChatConsoleLoginView(ViewUtils vu) {
		// TODO Auto-generated constructor stub
		this.vu = vu;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("= Authentification =");
		System.out.println("Veuillez saisir votre login : ");
		vu.getAuthCtl().authenticate(vu.getSc().next());
	}

	@Override
	public void setLogin(String login) {
		this.username = login;
	}
}
