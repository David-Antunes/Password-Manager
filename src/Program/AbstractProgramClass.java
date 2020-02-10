package Program;

import java.io.Serializable;

public abstract class AbstractProgramClass implements Program, Serializable {

	private static final long serialVersionUID = 1L;
	protected String program, ID, password;
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
