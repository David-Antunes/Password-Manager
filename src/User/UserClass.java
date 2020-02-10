package User;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Program.Program;
import Program.ProgramClass;

public class UserClass extends AbstractUserClass implements User, UserModifier, Serializable {

	private static final long serialVersionUID = 1626255755598654713L;

	public UserClass( String name, String email, String password) {

		super(name, email, password);

	}

	@Override
	public void add(String name, String ID, String[] extra, String password) {

		List<Program> prog = programs.get(name);
		Program program = new ProgramClass(name, password, ID, extra);
		if ((prog = programs.get(name)) == null) {
			prog = new LinkedList<Program>();
			programs.put(name, prog);
			prog.add(program);
		}
		prog.add(program);
	}

	public void remove(String name, String ID) {
		List<Program> prog = programs.get(name);
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
