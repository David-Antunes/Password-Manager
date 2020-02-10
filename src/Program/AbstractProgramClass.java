package Program;

import java.io.Serializable;

/**
 * 
 * @author David-Antunes
 *
 *
 *         This class holds the information regarding a program. It holds its
 *         name, the id and password inside the program, and also holds any
 *         extra parameters the user might want to add.
 */
public abstract class AbstractProgramClass implements Program, Serializable {

	private static final long serialVersionUID = 1L;
	// Name of the program, identifier inside the program and program password.
	protected String program, ID, password;
	// Extra parameters the user want to add
	protected String[] extra;

	public AbstractProgramClass(String name, String id, String password, String[] extra) {
		program = name;
		this.password = password;
		this.ID = id;
		this.extra = extra;
	}

	@Override
	public String getName() {
		return program;
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public String[] getExtra() {
		return extra;
	}

	@Override
	public String getPassword() {
		return password;
	}

}
