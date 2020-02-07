package Handler;

public interface UserHandler {

	public String getUser();

	public boolean login(String email, String password);

	public boolean register(String name, String email, String password);
}
