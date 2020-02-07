package User;

public class ProgramClass implements Program{
	
	String progName, ID, password;
	String[] extra;
	
	public ProgramClass(String progName, String ID, String[] extra, String password) {
		this.progName = progName;
		this.ID = ID;
		this.extra = extra;
		this.password = password;
	}

	@Override
	public String getProgName() {
		return progName;
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
