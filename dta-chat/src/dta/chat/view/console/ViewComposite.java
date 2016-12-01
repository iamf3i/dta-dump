package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {

	List<ViewComposite> children = new ArrayList<ViewComposite>();

	public abstract void print();

	public abstract void setLogin(String login);
}
