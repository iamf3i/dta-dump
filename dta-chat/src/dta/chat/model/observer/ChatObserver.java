package dta.chat.model.observer;

public interface ChatObserver<T> {

	void update(ChatObservable<T> observable, T obj);
}
