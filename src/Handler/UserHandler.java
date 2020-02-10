package Handler;

import SessionsExceptions.InSessionException;

public interface UserHandler {

	public String getUser();

	public boolean login(String email, String password) throws InSessionException;

	public boolean register(String name, String email, String password) throws InSessionException;
}
