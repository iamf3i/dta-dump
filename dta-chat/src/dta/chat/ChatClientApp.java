package dta.chat;

import dta.chat.exception.ChatException;
import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClientApp {

	public static void main(String[] args) {

		try {
			ViewComposite core = new ChatConsoleView();

			((ChatConsoleView) core).run();
			throw new ChatException("TMP");
		} catch (ChatException e) {
			System.out.println("Oops! Something went wrong: " + e.getMessage());
		}
	}

}
