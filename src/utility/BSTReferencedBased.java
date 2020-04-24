package utility;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;

/**
 * 
 * Class description: my version of BSTReferencedBased.
 *
 * @author Ivan Okhrimovich
 *
 */
public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT<E>
{
	private static final long serialVersionUID = 1169336436341394106L;
	private BSTreeNode<E> root;
	private int size;

	public BSTReferencedBased()
	{
		root = null;
		size = 0;
	}

	public BSTReferencedBased(E value)
	{
		root = new BSTreeNode<E>(value);
		size = 1;
	}

	/**
	 * The node at the root of the Binary Search Tree will be returned.
	 * 
	 * @return node stored at the root of tree is returned
	 * @throws TreeException
	 *             if the root is empty.
	 * @Override
	 */
	public BSTreeNode<E> getRoot() throws TreeException
	{
		if (root == null)
		{
			throw new TreeException();
		} else
		{
			return root;
		}
	}

	/**
	 * Determines the row height of the tree and returns that value as an integer
	 * value.
	 * 
	 * @return the height of the tree.
	 * @Override
	 */
	public int getHeight()
	{
		return getNodeHeight(this.root);
	}

	/**
	 * 
	 *
	 * @param node
	 * @return
	 */
	private int getNodeHeight(BSTreeNode<E> node)
	{
		if (node == null)
		{
			return -1;
		} else
		{
			return Math.max(getNodeHeight(node.getRight()), getNodeHeight(node.getLeft())) + 1;
		}
	}

	/**
	 * The number of elements currently stored in the tree is counted and the value
	 * is returned.
	 * 
	 * @return number of elements currently stored in tree.
	 * @Override
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Checks if the tree is currently empty.
	 * 
	 * @return returns boolean true if the tree is empty otherwise false.
	 * @Override
	 */
	public boolean isEmpty()
	{
		if (root == null)
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 * 
	 * @Override
	 */
	public void clear()
	{
		root = null;
		size = 0;
	}

	/**
	 * Checks the current tree to see if the element passed in is stored in the
	 * tree. If the element is found in the tree the method returns true and if the
	 * element is not in the tree the method returns false.
	 * 
	 * @param entry
	 *            the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and false if
	 *         the element is not found in the tree
	 * @throws TreeException
	 *             if the tree is empty.
	 * @Override
	 */
	public boolean contains(E entry) throws TreeException
	{
		if (root == null)
		{
			throw new TreeException();
		}

		if (search(entry) != null)
		{
			return true;
		}

		return false;
	}

	/**
	 * Retrieves a node from the tree given the object to search for.
	 * 
	 * @param entry
	 *            element object being searched
	 * @return the node with the element located in tree, null if not found
	 * @throws TreeException
	 *             if the tree is empty
	 * @Override
	 */
	public BSTreeNode<E> search(E entry) throws TreeException
	{
		if (root == null)
		{
			throw new TreeException();
		}

		BSTreeNode<E> temp = new BSTreeNode<E>(null);
		BSTreeNode<E> tempRoot = root;
		temp.setValue(entry);

		while (tempRoot != null)
		{
			// pass right subtree as new tree
			if (temp.getValue().compareTo(tempRoot.getValue()) > 0)
			{
				tempRoot = tempRoot.getRight();
			}
			// pass left subtree as new tree
			else if (temp.getValue().compareTo(tempRoot.getValue()) < 0)
			{
				tempRoot = tempRoot.getLeft();
			}
			// if the key is found
			else
			{
				return tempRoot;
			}
		}
		return null;
	}

	/**
	 * Adds a new element to the tree according to the natural ordering established
	 * by the Comparable implementation.
	 * 
	 * @param newEntry
	 *            the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException
	 *             if the element being added is null
	 * @Override
	 */
	public boolean add(E newEntry) throws NullPointerException
	{
		BSTreeNode<E> temp = new BSTreeNode<E>();
		BSTreeNode<E> tempRoot = root;
		temp.setValue(newEntry);

		if (newEntry == null)
		{
			throw new NullPointerException();
		}
		else if(root == null)
		{
			root = new BSTreeNode<E>(newEntry);
		}

		while (tempRoot != null)
		{
			// pass right subtree as new tree
			if (temp.getValue().compareTo(tempRoot.getValue()) > 0)
			{
				if (tempRoot.getRight() == null)
				{
					tempRoot.setRight(temp);
					size++;
					return true;
				}
				tempRoot = tempRoot.getRight();

			}
			// pass left subtree as new tree
			else if (temp.getValue().compareTo(tempRoot.getValue()) <= 0)
			{
				if (tempRoot.getLeft() == null)
				{
					tempRoot.setLeft(temp);
					size++;
					return true;
				}
				
				tempRoot = tempRoot.getLeft();
			}
		}

		return false;
	}


	/**
	 * Generates an in-order iteration over the contents of the tree. Elements are
	 * in their natural order.
	 * 
	 * @return an iterator with the elements in the natural order
	 * @Override
	 */
	public Iterator<E> inorderIterator()
	{
		ArrayList<BSTreeNode> list = new ArrayList<>();
		Stack<BSTreeNode> stack = new Stack<BSTreeNode>();
		BSTreeNode tempRoot = root;

		if (tempRoot != null)
		{
			stack.push(tempRoot);

			while (!stack.isEmpty())
			{
				if (tempRoot.getLeft() != null)
				{
					tempRoot = tempRoot.getLeft();
					stack.push(tempRoot);
				} 
				else
				{
					list.add(stack.pop()); // add left most node to list

					if (tempRoot.getRight() != null)
					{
						tempRoot = tempRoot.getRight();
						stack.push(tempRoot);
					}
					else
					{
						if (!stack.isEmpty())
						{
							tempRoot = stack.peek();
							tempRoot.setLeft(null);
						}
					}
				}
			}
		}

		Iterator o = new Iterator(list);
		return o;
	}

	/**
	 * Generates a pre-order iteration over the contents of the tree. Elements are
	 * order in such a way as the root element is first.
	 * 
	 * @return an iterator with the elements in a root element first order
	 * @Override
	 */
	public Iterator<E> preorderIterator()
	{
		ArrayList<BSTreeNode> list = new ArrayList<>();
		Stack<BSTreeNode> stack = new Stack<BSTreeNode>();
		BSTreeNode temp;
		BSTreeNode tempRoot = root;

		if (tempRoot != null)
		{
			stack.push(tempRoot);

			while (!stack.isEmpty())
			{
				tempRoot = stack.pop();
				list.add(tempRoot);

				if ((temp = tempRoot.getRight()) != null)
				{
					stack.push(temp);
				}
				if ((temp = tempRoot.getLeft()) != null)
				{
					stack.push(temp);
				}
			}
		}

		Iterator o = new Iterator(list);
		return o;
	}

	/**
	 * Generates a post-order iteration over the contents of the tree. Elements are
	 * order in such a way as the root element is last.
	 * 
	 * @return an iterator with the elements in a root element last order
	 * @Override
	 */
	public Iterator<E> postorderIterator()
	{
		ArrayList<BSTreeNode> list = new ArrayList<>();
		Stack<BSTreeNode> stack = new Stack<BSTreeNode>();
		Stack<BSTreeNode> stack2 = new Stack<BSTreeNode>();
		BSTreeNode temp;
		BSTreeNode tempRoot = root;
		
		if (tempRoot != null)
		{
			stack.push(tempRoot);

			while (!stack.isEmpty())
			{
				stack2.push(stack.pop());
				
				if(tempRoot.getLeft() != null)
				{
					stack.push(tempRoot.getLeft());
				}
				
				if(tempRoot.getRight() != null)
				{
					stack.push(tempRoot.getRight());
				}
				
				if (tempRoot.getRight() == null)
				{
					if(!stack.empty())
					{
						tempRoot = stack.peek();
					}
				}
				else
				{
					tempRoot = tempRoot.getRight();
				}		
			}
			
			while (!stack2.isEmpty())
			{
				list.add(stack2.pop());
			}
				
		}

		Iterator o = new Iterator(list);
		return o;
	}

	/**
	 * Returns an iterator over the elements in this tree in proper sequence.
	 * 
	 * @return an iterator over the elements in this tree in proper sequence.
	 * @Override
	 */
	private class Iterator<E extends Comparable<? super E>> implements utility.Iterator<E>
	{
		ArrayList<BSTreeNode> list = new ArrayList<>();
		int position = 0;

		public Iterator(ArrayList<BSTreeNode> list)
		{
			this.list = list;
			position = 0;

		}

		/**
		 * Returns <code>true</code> if the iteration has more elements. (In other
		 * words, returns <code>true</code> if <code>next()</code> would return an
		 * element rather than throwing an exception.)
		 * 
		 * @return <code>true</code> if the iterator has more elements.
		 * @Override
		 */
		public boolean hasNext()
		{
			if (position < list.size())
			{
				return true;
			} else
			{
				return false;
			}
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException
		 *             If the iteration has no more elements.
		 * @Override
		 */
		public E next() throws NoSuchElementException
		{
			if (this.hasNext())
			{
				return (E) list.get(position++).getValue();
			}

			else
			{
				throw new NoSuchElementException();
			}
		}
	}
}
