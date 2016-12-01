package dta.chat.view;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;

public class ViewUtils {
	private Scanner sc;
	private ChatAuthController authCtl;

	public ViewUtils() {
		super();
		this.sc = new Scanner(System.in);
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ChatAuthController getAuthCtl() {
		return authCtl;
	}

	public void setAuthCtl(ChatAuthController authCtl) {
		this.authCtl = authCtl;
	}
}
