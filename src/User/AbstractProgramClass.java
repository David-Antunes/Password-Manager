package User;

public abstract class AbstractProgramClass implements Program {

	protected String program, ID, password;
	protected String[] extra;

	public AbstractProgramClass(String name, String password, String id, String[] extra) {
		program = name;
		this.password = password;
		this.ID = id;
		this.extra = extra;
	}

	@Override
	public String getProgName() {
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
