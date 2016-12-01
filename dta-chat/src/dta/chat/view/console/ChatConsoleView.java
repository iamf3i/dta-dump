package dta.chat.view.console;

import dta.chat.controller.ChatAuthController;
import dta.chat.view.ViewUtils;

public class ChatConsoleView extends ViewComposite implements Runnable {

	private ViewUtils vu;

	public ChatConsoleView(ViewUtils vu) {
		this.vu = vu;
		children.add(new ChatConsoleTitleView(vu));
		children.add(new ChatConsoleLoginView(vu));
		children.add(new ChatConsoleConversationView(vu));
	}

	@Override
	public void print() {

		for (ViewComposite child : children) {
			child.print();
		}
	}

	@Override
	public void run() {

		this.print();
	}

	public void setAuthController(ChatAuthController c) {
		this.vu.setAuthCtl(c);
	}

	@Override
	public void setLogin(String login) {

		for (ViewComposite child : children) {
			child.setLogin(login);
		}
	}
}
