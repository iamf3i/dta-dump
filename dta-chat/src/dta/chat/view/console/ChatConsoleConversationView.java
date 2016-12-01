package dta.chat.view.console;

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
}
