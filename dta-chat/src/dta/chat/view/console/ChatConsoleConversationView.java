package dta.chat.view.console;

import dta.chat.model.ChatMessage;

public class ChatConsoleConversationView extends ViewComposite {

	private String username;

	@Override
	public void print() {
		System.out.println("= Conversations =");
		if (username != null)
			System.out.println("Welcome : " + this.username);
	}

	public void setLogin(String login) {
		this.username = login;
	}

	public void update(ChatMessage msg) {
		System.out.println(msg.getLogin() + ": " + msg.getText());
	}
}
