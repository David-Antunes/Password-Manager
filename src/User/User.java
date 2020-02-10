package User;

import java.util.Iterator;
import java.util.List;

import Program.Program;

public interface User {

	/**
	 * Returns the name of the user
	 * 
	 * @return the name of the user
	 */
	public String getName();

	/**
	 * Returns the email of the user
	 * 
	 * @return the email of the user
	 */
	public String getEmail();

	/**
	 * Returns the password of the user
	 * 
	 * @return the password of the user
	 */
	public String getPassword();

	/**
	 * Returns an iterator with the programs with the same name
	 * 
	 * @param name - name of the program
	 * @return an iterator with the programs with the same name
	 */
	public Iterator<Program> getAProgram(String name);

	/**
	 * Returns an iterator with all the programs of the user
	 * 
	 * @return an iterator with all the programs of the user
	 */
	public Iterator<List<Program>> getAllPrograms();

}
