package examen.services;

public class AutenticacionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147981053893289251L;

	public AutenticacionException() {
	}

	public AutenticacionException(String message) {
		super(message);
	}

	public AutenticacionException(Throwable cause) {
		super(cause);
	}

	public AutenticacionException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutenticacionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
