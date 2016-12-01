package dta.chat.view.console;

import dta.chat.controller.ChatAuthController;
import dta.chat.view.ViewUtils;

public class ChatConsoleLoginView extends ViewComposite {

	private ViewUtils vu;
	private ChatAuthController authCtl;

	public ChatConsoleLoginView(ViewUtils vu) {

		this.vu = vu;
	}

	@Override
	public void print() {

		System.out.println("= Authentification =");
		System.out.println("Veuillez saisir votre login : ");
		authCtl.authenticate(vu.getSc().next());
	}

	public void setAuthCtl(ChatAuthController c) {

		this.authCtl = c;
	}
}
