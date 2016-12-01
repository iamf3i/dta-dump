package dta.chat.view.console;

import dta.chat.view.ViewUtils;

public class ChatConsoleTitleView extends ViewComposite {

	private ViewUtils vu;

	public ChatConsoleTitleView(ViewUtils vu) {
		// TODO Auto-generated constructor stub
		this.vu = vu;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("= CHAT APP =");
	}

	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub

	}

}
