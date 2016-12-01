package dta.chat.view;

import java.util.Scanner;

public class ViewUtils {
	private Scanner sc;

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
}
