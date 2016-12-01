package dta.chat;

import dta.chat.exception.ChatException;
import dta.chat.model.ChatConversationModel;
import dta.chat.view.ViewUtils;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try {
			final ViewUtils vu = new ViewUtils();

			ChatConversationModel model = new ChatConversationModel();

			final ChatConsoleView core = new ChatConsoleView(vu);

			core.setAuthController((login) -> {
				model.setLogin(login);
			});

			model.addObserver(core);

			core.run();

			model.sendMessage("Bonjour");
			model.sendMessage("C'est moi !");

			vu.getSc().close();
		} catch (ChatException e) {
			System.out.println("Oops! Something went wrong: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
