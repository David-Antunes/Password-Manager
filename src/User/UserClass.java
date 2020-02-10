package User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserClass extends AbstractUserClass implements User, UserModifier, Serializable {

	private static final long serialVersionUID = 1626255755598654713L;

	public UserClass(String email, String name, String password) {

		super(email, name, password);

	}

	@Override
	public void add(String progName, String ID, String[] extra, String password) {

		if (!programs.containsKey(progName)) {
			List<Program> prog = new ArrayList<Program>();
			programs.put(progName, prog);
			prog.add(new ProgramClass(progName, password, ID, extra));
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
