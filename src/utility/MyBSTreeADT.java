package utility;

import java.io.Serializable;

/**
 * <p>
 * The <code>BSTreeADT</code> interface is designed to be used as 
 * a binary search tree structure. This structure maintains data 
 * in an ordered tree. The implementors of this interface will 
 * be required to add all the functionality.
 * </p>
 * 
 * @param <E> The type of elements this tree holds.
 *
 * @author Ivan Okhrimovich
 */
public interface MyBSTreeADT <E> extends Serializable
{

	/**
	 * Adds a value to the binary search tree.
	 *
	 * @param toAdd
	 * 			Value to be added to this tree.
	 * @return <code>true</code> if value is added successfully.	
	 */
	public void add(E toAdd);
	
		
	/**
	 * Removes a value which equals to the indicated value. Only one value is removed,
	 * and no guarantee is given on which of duplicate values will be removed.
	 * Value returned is no longer part of the structure.
	 *
	 * @param toRemove
	 * 			Value to be removed from this tree.
	 * @return Actual value removed from this tree, or null if the tree does
	 * 			not contain the specified value.
	 */		
	public E remove(E toRemove);
	
	
	/**
	 * Determines if the binary search tree contains a value. Returns true if this 
	 * tree contains the specified value.
	 *
	 * @param toFind
	 * 			The value whose presence in this tree is to be tested.
	 * @return <code>true</code> if this tree contains the specified value.
	 */			
	public boolean contains(E toFind);

	
	/**
	 * Removes all data from the binary search tree. This tree will be empty after
	 * this call returns.
	 */
	public void clear();
	
	
	/**
	 * The isEmpty method returns <code>true</code> if this tree contains no values.
	 *
	 * @return <code>true</code> if this tree contains no values.
	 */
	public boolean isEmpty();

	
	/**
	 * The size method determines the number of data values within the tree.
	 *
	 * @return The current value count.
	 */
	public int size();
	
	
	/**
	 * The getRoot method returns the root of the tree.
	 *
	 * @return <code>E</code> the root value, or <code>null</code> if the tree is empty.
	 */		
	public E getRoot();

	
	/**
	 * The getHeight method returns the maximum depth of the tree.
	 *
	 * @return The maximum depth of the tree.
	 */
	public int getHeight();
	
	
	/**
	 * Returns an iterator over the elements in this list, in proper (VLR) sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	public Iterator<E> preOrderIterator();
	
	
	/**
	 * Returns an iterator over the elements in this list, in proper (LVR) sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	public Iterator<E> inOrderIterator();
	
	
	/**
	 * Returns an iterator over the elements in this list, in proper (LRV) sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	public Iterator<E> postOrderIterator();	

}
