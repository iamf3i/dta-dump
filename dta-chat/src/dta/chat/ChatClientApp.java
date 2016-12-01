package dta.chat;

import dta.chat.exception.ChatException;
import dta.chat.view.ViewUtils;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try {
			final ViewUtils vu = new ViewUtils();
			final ChatConsoleView core = new ChatConsoleView(vu);

			core.setAuthController((login) -> {
				core.setLogin(login);
			});

			core.run();
			vu.getSc().close();
		} catch (ChatException e) {
			System.out.println("Oops! Something went wrong: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
