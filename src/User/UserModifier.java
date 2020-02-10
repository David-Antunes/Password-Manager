package User;

public interface UserModifier extends User {

	void add(String progName, String ID, String[] extra, String password);

	void remove(String progName, String ID);
}
