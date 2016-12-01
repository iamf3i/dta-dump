package dta.chat;

import dta.chat.exception.ChatException;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try {
			ChatConsoleView core = new ChatConsoleView();
			core.run();
		} catch (ChatException e) {
			System.out.println("Oops! Something went wrong: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
