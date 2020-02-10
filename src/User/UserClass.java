package User;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Program.Program;
import Program.ProgramClass;
import SessionsExceptions.NoProgramException;

public class UserClass extends AbstractUserClass implements User, UserModifier {

	private static final long serialVersionUID = 1626255755598654713L;

	public UserClass(String name, String email, String password) {

		super(name, email, password);

	}

	@Override
	public void add(String name, String ID, String password, String[] extra) {

		List<Program> prog = programs.get(name);
		Program program = new ProgramClass(name, ID, password, extra);
		if ((prog = programs.get(name)) == null) {
			prog = new LinkedList<Program>();
			programs.put(name, prog);
		}
		prog.add(program);
	}

	public void remove(String name, String id) throws NoProgramException {
		List<Program> prog = programs.get(name);

		if (prog == null)
			throw new NoProgramException();

		Iterator<Program> it = prog.iterator();

		boolean found = false;
		int pos = 0;
		while (it.hasNext() && !found) {
			Program aux = it.next();
			if (aux.getID().equals(id))
				found = true;
			else
				pos++;
		}
		if (found)
			prog.remove(pos);
		else
			throw new NoProgramException();
	}
}
