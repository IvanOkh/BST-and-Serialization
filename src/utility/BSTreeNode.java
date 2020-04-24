package utility;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Class description: my version of a BSTreeNode.
 *
 * @author Ivan Okhrimovich
 *
 */
public class BSTreeNode<E extends Comparable<? super E>> implements Serializable
{
	private static final long serialVersionUID = 2343603393127143058L;
	private E value;
	private BSTreeNode <E> right;
	private BSTreeNode <E> left;
	private ArrayList <E> instances;

	public BSTreeNode(E value)
	{
		this.value = value;
		right = null;
		left = null;
		instances = new ArrayList <E>();
	}
	
	public BSTreeNode()
	{
		value = null;
		right = null;
		left = null;
		instances = new ArrayList <E>() ;
	}
	
	/**
	 * Adds the value to array list.
	 * @param value the value to set
	 */
	public void addInstance (String record)
	{
		instances.add((E) record);
	}
	
	/**
	 * Returns the array list.
	 * @return the instances
	 */
	public ArrayList <E> getInstances ()
	{
		return instances;
	}
	
	/**
	 * Returns the value.
	 * @return the value
	 */
	public E getValue()
	{
		return value;
	}

	/**
	 * Returns the right.
	 * @return the right
	 */
	public BSTreeNode<E> getRight()
	{
		return right;
	}

	/**
	 * Returns the left.
	 * @return the left
	 */
	public BSTreeNode<E> getLeft()
	{
		return left;
	}

	/**
	 * Sets the value of value.
	 * @param value the value to set
	 */
	public void setValue(E value)
	{
		this.value = value;
	}

	/**
	 * Sets the value of right.
	 * @param right the right to set
	 */
	public void setRight(BSTreeNode<E> right)
	{
		this.right = right;
	}

	/**
	 * Sets the value of left.
	 * @param left the left to set
	 */
	public void setLeft(BSTreeNode<E> left)
	{
		this.left = left;
	}

}
