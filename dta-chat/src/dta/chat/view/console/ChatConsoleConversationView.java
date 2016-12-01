package dta.chat.view.console;

import dta.chat.view.ViewUtils;

public class ChatConsoleConversationView extends ViewComposite {

	private ViewUtils vu;
	private String username;

	public ChatConsoleConversationView(ViewUtils vu) {
		this.vu = vu;
	}

	@Override
	public void print() {
		System.out.println("= Conversations =");
		if (username != null)
			System.out.println("Welcome : " + this.username);
	}

	@Override
	public void setLogin(String login) {
		setUsername(login);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
