package User;

import java.util.Iterator;
import java.util.List;

public interface User {

	public String getName();

	public String getEmail();

	public String getPassword();

	public Iterator<Program> getAProgram(String progName);

	public Iterator<List<Program>> getAllPrograms();

}
