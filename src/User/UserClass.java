package User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserClass implements User, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1626255755598654713L;
	
	String email, name, password;
	Map<String, List<Program>> programs;

	public UserClass(String email, String name, String password) {

		this.email = email;
		this.name = name;
		this.password = password;

		programs = new HashMap<String, List<Program>>();

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Iterator<Program> getAProgram(String progName) {
		return programs.get(progName).iterator();
	}

	@Override
	public Iterator<List<Program>> getAllPrograms() {

		Iterator<String> keys = programs.keySet().iterator();
		List<List<Program>> progSets = new ArrayList<List<Program>>();

		while (keys.hasNext()) {
			progSets.add(programs.get(keys.next()));
		}
		return progSets.iterator();
	}

	public boolean equals(Object object) {
		if (this == object)
			return true;
		else {
			User userTemp = (User) object;
			if (email.equals(userTemp.getEmail()))
				return true;
			else
				return false;
		}
	}

	@Override
	public void add(String progName, String ID, String[] extra, String password) {

		if (!programs.containsKey(progName)) {
			List<Program> prog = new ArrayList<Program>();
			programs.put(progName, prog);
			prog.add(new ProgramClass(progName, ID, extra, password));
		}
	}

	public void remove(String progName, String ID) {
		List<Program> prog = programs.get(progName);

		Iterator<Program> it = prog.iterator();

		boolean found = false;
		int pos = 0;
		while (it.hasNext() && !found) {
			Program aux = it.next();
			if (aux.getID().equals(ID))
				found = true;
			else
				pos++;
		}
		prog.remove(pos);
	}
}
