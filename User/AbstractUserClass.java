package User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Program.Program;
import SessionsExceptions.NoProgramException;

/**
 * 
 * @author David-Antunes
 *
 *
 *         This class holds the information regarding of a user. It holds its
 *         name, email and password.
 */
public abstract class AbstractUserClass implements User, Serializable {

	private static final long serialVersionUID = 1L;
	protected String email, name, password;
	protected Map<String, List<Program>> programs;

	public AbstractUserClass(String name, String email, String password) {

		this.email = email;
		this.name = name;
		this.password = password;

		programs = new TreeMap<String, List<Program>>();

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
	public Iterator<Program> getAProgram(String progName) throws NoProgramException {

		if (programs.isEmpty())
			throw new NoProgramException();

		List<Program> programList = programs.get(progName);

		if (programList == null)
			throw new NoProgramException();

		return programList.iterator();
	}

	@Override
	public Iterator<List<Program>> getAllPrograms() throws NoProgramException {

		if (programs.isEmpty())
			throw new NoProgramException();

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

}
