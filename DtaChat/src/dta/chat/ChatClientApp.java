package dta.chat;

import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClientApp {

	public static void main(String[] args) {

		ViewComposite core = new ChatConsoleView();

		core.print();
	}

}
