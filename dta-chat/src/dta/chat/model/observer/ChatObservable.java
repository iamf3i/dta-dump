package dta.chat.model.observer;

import java.util.List;

public abstract class ChatObservable<T> {

	List<ChatObserver<T>> observers;

	public void addObserver(ChatObserver<T> observer) {

	}

	public void removeObserver(ChatObserver<T> observer) {

	}

	public void notifyObservers(T msg) {

	}
}
