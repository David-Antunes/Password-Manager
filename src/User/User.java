package User;
import java.util.Iterator;
import java.util.List;

public interface User {
	
	public String getName();
	
	public String getEmail();
	
	public String getPassword();
	
	public Iterator<Program> getAProgram(String progName);
	
	public Iterator<List<Program>> getAllPrograms();
	
	public void add(String progName, String ID, String[] extra, String password);
	
	public void remove(String progName, String ID);
}
