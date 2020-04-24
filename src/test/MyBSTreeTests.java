/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.TreeException;
import utility.BSTReferencedBased;
import utility.BSTreeNode;

/**
 * Class description: set of tests for BSTReferencedBased.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyBSTreeTests
{
	BSTReferencedBased one;
	BSTReferencedBased two;
	static BSTReferencedBased zero;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new BSTReferencedBased (null);
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}
	

	@Before
	public void setUp() throws Exception
	{
		one = new BSTReferencedBased(null);
		two = new BSTReferencedBased(2);
	}


	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}

	
	@Test
	public void testGetRoot() throws TreeException
	{
		BSTReferencedBased u = new BSTReferencedBased("Y");
		u.add("T");
		BSTreeNode actual = u.getRoot();
	
		assertEquals("tesGetRoot() method did not return root node correctly", "Y", actual.getValue());	

	}

	@Test
	public void testGetHeight()
	{
		BSTReferencedBased u = new BSTReferencedBased(50); //50
		
		u.add(50);
		u.add(30);
		u.add(20);
		u.add(40);
		u.add(70);
		u.add(45);
		u.add(65);
		
		int actual = u.getHeight();

		assertEquals("testgetHeight() method did not return tree height correctly", 4, actual);
	}


	@Test
	public void testSize()
	{
		BSTReferencedBased u = new BSTReferencedBased("Y");
		u.add("T");
		int actual = u.size();
		u.clear();
		int actual2 = u.size();
		
		assertEquals("testSize() method did not return integer correctly", 2, actual);	
		assertEquals("testSize() method did not return integer correctly", 0, actual2);	
	}


	@Test
	public void testIsEmpty()
	{
		BSTReferencedBased u = new BSTReferencedBased("Y");
		u.add("T");
		boolean actual = u.isEmpty();
		u.clear();
		boolean actual2 = u.isEmpty();
		
		assertEquals("testIsEmpty() method did not return boolean correctly", false, actual);	
		assertEquals("testIsEmpty() method did not return boolean correctly", true, actual2);	
	}


	@Test
	public void testClear()
	{
		BSTReferencedBased u = new BSTReferencedBased("Y");
		u.add("T");
		boolean actual = u.isEmpty();
		u.clear();
		boolean actual2 = u.isEmpty();
		
		assertEquals("testClear() method did not return boolean correctly", false, actual);	
		assertEquals("testClear() method did not return boolean correctly", true, actual2);	
	}


	@Test
	public void testContains() throws TreeException
	{
		BSTReferencedBased u = new BSTReferencedBased("Y"); //50
		
		BSTreeNode first = new BSTreeNode ("W"); //30 
		BSTreeNode second = new BSTreeNode ("V"); //20
		BSTreeNode third = new BSTreeNode ("X"); //40 
		BSTreeNode fourth = new BSTreeNode ("Z"); //70
		
		u.getRoot().setLeft(first);
		u.getRoot().setRight(fourth);
		u.getRoot().getLeft().setLeft(second);
		u.getRoot().getLeft().setRight(third);
				
		boolean actual = u.contains("V");
		boolean actualNull = u.contains("O");
		
		assertEquals("testContains() method did not return boolean correctly", true, actual);	
		assertEquals("testContains() method did not return boolean correctly", false, actualNull);	
	}

	@Test
	public void testSearchString() throws TreeException
	{		
		BSTReferencedBased u = new BSTReferencedBased("Y"); //50
		
		BSTreeNode first = new BSTreeNode ("W"); //30 
		BSTreeNode second = new BSTreeNode ("V"); //20
		BSTreeNode third = new BSTreeNode ("X"); //40 
		BSTreeNode fourth = new BSTreeNode ("Z"); //70
		
		u.getRoot().setLeft(first);
		u.getRoot().setRight(fourth);
		u.getRoot().getLeft().setLeft(second);
		u.getRoot().getLeft().setRight(third);
		
		BSTreeNode actual;
		actual = u.search("X");
		
		assertEquals("testSearchString() method did not return BSTreeNode correctly", "X", actual.getValue());			
	}
	
	@Test
	public void testSearchString2() throws TreeException
	{		
		BSTReferencedBased u = new BSTReferencedBased("Y"); //50
		
		String w = "w"; //30 
		String v = "v"; //20
		String x = "x"; //40 
		String z = "z"; //70
		
		u.add(w);
		u.add(v);
		u.add(x);
		u.add(z);
		
		BSTreeNode actual;
		BSTreeNode actual2;
		BSTreeNode actual3;
		BSTreeNode actual4;
		actual = u.search("w");
		actual2 = u.search("v");
		actual3 = u.search("x");
		actual4 = u.search("z");
		
		assertEquals("testSearchString2() method did not return BSTreeNode correctly", w, actual.getValue());	
		assertEquals("testSearchString2() method did not return BSTreeNode correctly", v, actual2.getValue());	
		assertEquals("testSearchString2() method did not return BSTreeNode correctly", x, actual3.getValue());	
		assertEquals("testSearchString2() method did not return BSTreeNode correctly", z, actual4.getValue());	

	}
	
	@Test
	public void testSearchNumber() throws TreeException
	{
		BSTReferencedBased u = new BSTReferencedBased(50); //50
		
		BSTreeNode first = new BSTreeNode (30); //30 
		BSTreeNode second = new BSTreeNode (20); //20
		BSTreeNode third = new BSTreeNode (40); //40 
		BSTreeNode fourth = new BSTreeNode (70); //70
		
		u.getRoot().setLeft(first);
		u.getRoot().setRight(fourth);
		u.getRoot().getLeft().setLeft(second);
		u.getRoot().getLeft().setRight(third);
		
		BSTreeNode actual;
		actual = u.search(30);
				
		assertEquals("testSearchNumber() method did not return BSTreeNode correctly", first.getValue(), actual.getValue());	
	}

	@Test
	public void testAdd() throws TreeException
	{
		BSTReferencedBased u = new BSTReferencedBased("Y"); //50
		
		u.add("Y");
		u.add("W");
		u.add("V");
		u.add("X");
		u.add("Z");
				
		boolean actual = u.contains("V");
		boolean actualNull = u.contains("O");
		
		assertEquals("testAdd() method did not return boolean correctly", true, actual);	
		assertEquals("testAdd() method did not return boolean correctly", false, actualNull);	
	}
	
	@Test
	public void testAddtoEmpty() throws TreeException
	{
		BSTReferencedBased u = new BSTReferencedBased(); //50
		
		u.add("Y");
		u.add("W");
		u.add("V");
		u.add("X");
		u.add("Z");

		String actual = (String) u.getRoot().getValue();
		String actual2 = (String)u.getRoot().getRight().getValue();
		
		assertEquals("testAddtoEmpty() method did not return boolean correctly", "Y", actual);	
		assertEquals("testAddtoEmpty() method did not return boolean correctly", "Z", actual2);	
	}

	@Test
	public void testInorderIterator()
	{
		BSTReferencedBased u = new BSTReferencedBased(50); //50
		
		u.add(50);
		u.add(30);
		u.add(20);
		u.add(40);
		u.add(70);
		u.add(45);
		u.add(65);
		
		utility.Iterator<Integer> foo = u.inorderIterator();
		int actual =  foo.next();
		int actual2 = foo.next();
		int actual3 = foo.next();
		int actual4 = foo.next();
		int actual5 = foo.next();
		int actual6 = foo.next();
		int actual7 = foo.next();
		int actual8 = foo.next();
			//System.out.println(actual +" "+ actual2+" "+actual3+" "+ actual4
					//+" "+actual5+" "+actual6+" "+actual7+" "+actual8);


		assertEquals("testInorderIterator() method did not return object correctly", 20, actual);
		assertEquals("testInorderIterator() method did not return object correctly", 30, actual2);
		assertEquals("testInorderIterator() method did not return object correctly", 40, actual3);
		assertEquals("testInorderIterator() method did not return object correctly", 70, actual8);
	}

	@Test
	public void testPreorderIterator()
	{
		BSTReferencedBased u = new BSTReferencedBased("Y"); //50
		
		u.add("Y");
		u.add("W");
		u.add("V");
		u.add("X");
		u.add("Z");
		
		utility.Iterator<String> foo = u.preorderIterator();
		String actual = (String) foo.next();
		String actual2 = foo.next();
		String actual3 = foo.next();

		assertEquals("testPreorderIterator() method did not return object correctly", "Y", actual);
		assertEquals("testPreorderIterator() method did not return object correctly", "Y", actual2);
		assertEquals("testPreorderIterator() method did not return object correctly", "W", actual3);

	}
	
	@Test
	public void testPreorderIteratorInteger()
	{
		BSTReferencedBased u = new BSTReferencedBased(50); //50
		
		u.add(50);
		u.add(30);
		u.add(20);
		u.add(40);
		u.add(70);
		u.add(45);
		u.add(65);
		
		utility.Iterator<Integer> foo = u.preorderIterator();
		int actual =  foo.next();
		int actual2 = foo.next();
		int actual3 = foo.next();
		int actual4 = foo.next();
		int actual5 = foo.next();
		int actual6 = foo.next();
		int actual7 = foo.next();
		int actual8 = foo.next();
			//System.out.println(actual +" "+ actual2+" "+actual3+" "+ actual4
					//+" "+actual5+" "+actual6+" "+actual7+" "+actual8);


		assertEquals("testPreorderIteratorInteger() method did not return integer correctly", 50, actual);
		assertEquals("testPreorderIteratorInteger() method did not return integer correctly", 50, actual2);
		assertEquals("testPreorderIteratorInteger() method did not return integer correctly", 30, actual3);

	}

	@Test
	public void testPostorderIterator()
	{
		BSTReferencedBased u = new BSTReferencedBased(50); //50
		
		u.add(50);
		u.add(30);
		u.add(20);
		u.add(40);
		u.add(70);
		u.add(45);
		u.add(65);
		
		utility.Iterator<Integer> foo = u.postorderIterator();
		int actual =  foo.next();
		int actual2 = foo.next();
		int actual3 = foo.next();
		int actual4 = foo.next();
		int actual5 = foo.next();
		int actual6 = foo.next();
		int actual7 = foo.next();
		int actual8 = foo.next();
			//System.out.println(actual +" "+ actual2+" "+actual3+" "+ actual4
					//+" "+actual5+" "+actual6+" "+actual7+" "+actual8);

		assertEquals("testPostorderIterator() method did not return object correctly", 20, actual);
		assertEquals("testPostorderIterator() method did not return object correctly", 45, actual2);
		assertEquals("testPostorderIterator() method did not return object correctly", 40, actual3);
	}

}
