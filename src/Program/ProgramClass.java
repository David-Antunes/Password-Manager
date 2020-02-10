package Program;

/**
 * 
 * @author David-Antunes
 *
 *
 *         This class extends its abstract class, that only returns values.
 */
public class ProgramClass extends AbstractProgramClass implements Program, ProgramModifier {

	private static final long serialVersionUID = 1L;

	public ProgramClass(String name, String id, String password, String[] extra) {
		super(name, id, password, extra);
	}

}
