package dta.chat.view.console;

import dta.chat.controller.ChatAuthController;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObserver;
import dta.chat.view.ViewUtils;

public class ChatConsoleView extends ViewComposite implements Runnable, ChatObserver<ChatMessage> {

	private ViewUtils vu;
	private ChatAuthController authCtl;

	private ChatConsoleTitleView chatConsoleTitleView;
	private ChatConsoleLoginView chatConsoleLoginView;
	private ChatConsoleConversationView chatConsoleConversationView;;

	public ChatConsoleView(ViewUtils vu) {
		this.vu = vu;

		chatConsoleTitleView = new ChatConsoleTitleView();
		chatConsoleLoginView = new ChatConsoleLoginView(this.vu);
		chatConsoleConversationView = new ChatConsoleConversationView();

		children.add(chatConsoleTitleView);
		children.add(chatConsoleLoginView);
		children.add(chatConsoleConversationView);
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
		this.authCtl = c;
		this.chatConsoleLoginView.setAuthCtl(this.authCtl);
	}

	@Override
	public void update(ChatMessage msg) {
		chatConsoleConversationView.update(msg);
	}
}
