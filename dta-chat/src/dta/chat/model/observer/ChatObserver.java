package dta.chat.model.observer;

public interface ChatObserver<T> {

	void update(T obj);
}
