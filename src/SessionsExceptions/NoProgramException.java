package SessionsExceptions;

/**
 * 
 * @author David-Antunes
 * 
 *         This exception is to be used when there is no program registered in
 *         the user,or when the given id isn't registered.
 */
public class NoProgramException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoProgramException() {
		super();
	}

	public NoProgramException(String msg) {
		super(msg);
	}

}
