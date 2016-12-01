package dta.chat.exception;

public class ChatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -990965831794662588L;

	public ChatException(String message) {
		super(message);
	}

	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChatException(Throwable cause) {
		super(cause);
	}

}
