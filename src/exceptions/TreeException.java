package exceptions;

/**
 * 
 * Class description: This exception is thrown when some operations are
 * performed on an empty tree.
 *
 * @author Ivan Okhrimovich
 *
 */
public class TreeException extends Exception
{

	private static final long serialVersionUID = -1401985415652457534L;

	public TreeException()
	{
		super("Tree is currently empty");
	}

	public TreeException(String message)
	{
		super(message);
	}
}
