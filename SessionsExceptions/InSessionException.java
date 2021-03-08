package SessionsExceptions;

/**
 * 
 * @author David-Antunes
 * 
 *         This exception is to be used when there is a user in session
 */
public class InSessionException extends Exception {

	private static final long serialVersionUID = 1L;

	public InSessionException() {
		super();
	}

	public InSessionException(String msg) {
		super(msg);
	}

}
