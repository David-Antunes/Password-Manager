package SessionsExceptions;

/**
 * 
 * @author David-Antunes
 * 
 *         This exception is to be used when there is no user in Session
 */
public class NotInSessionException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotInSessionException() {
		super();
	}

	public NotInSessionException(String msg) {
		super(msg);
	}

}
