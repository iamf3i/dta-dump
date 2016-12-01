package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public class ChatConsoleView extends ViewComposite {

	List<ViewComposite> children = new ArrayList<ViewComposite>();

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

}
