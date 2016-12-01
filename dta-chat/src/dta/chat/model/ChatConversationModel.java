package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private String login;

	public void setLogin(String login) {
		this.login = login;
	}

	public void sendMessage(String msg) {
		ChatMessage chatMsg = new ChatMessage();
		chatMsg.setLogin(login);
		chatMsg.setText(msg);
		this.notifyObservers(chatMsg);
	}
}
