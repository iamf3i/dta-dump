package dta.chat.view.console;

public class ChatConsoleView extends ViewComposite implements Runnable {

	public ChatConsoleView() {
		super();
		children.add(new ChatConsoleTitleView());
		children.add(new ChatConsoleLoginView());
		children.add(new ChatConsoleConversationView());
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

}
