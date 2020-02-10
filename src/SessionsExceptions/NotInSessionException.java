package SessionsExceptions;

public class NotInSessionException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotInSessionException() {
		super();
	}

	public NotInSessionException(String msg) {
		super(msg);
	}

}
