package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import exceptions.TreeException;
import utility.BSTReferencedBased;

/**
 * 
 * Class description: WordTracker reads text files and collects and stores 
 * all the unique words it finds in those files. It keeps track 
 * of each occurrence of a word in a file and the line on which it was 
 * found in that file.
 *
 * @author Ivan Okhrimovich
 *
 */
public class WordTracker
{
	public static void main(String[] args)
			throws FileNotFoundException, IOException, NullPointerException, TreeException
	{
		BSTReferencedBased tree = new BSTReferencedBased();
		BSTReferencedBased tree2 = new BSTReferencedBased();
		ArrayList inst = new ArrayList();
		String filePath = "";
		String reportType = "";
		String reportName = "";

//read from console	
		
		for(int i = 0; i < args.length; i++) 
		{ 
			 if(args[i].toLowerCase().endsWith(".txt") && !args[i].toLowerCase().startsWith("-f") ) 
			 { 
				 filePath = args[i];
				 System.out.println("Read File " + filePath.toLowerCase()); 
			 }
		 
			 if(args[i].toLowerCase().startsWith("-p"))
			 { 
				 reportType = args[i].substring(2); 
				 System.out.println("Report type is " + reportType.toLowerCase()); 
			 }
		  
			 if(args[i].toLowerCase().startsWith("-f"))
			 { 
				 reportName = args[i].substring(2);
				 System.out.println("Write report to "+reportName.toLowerCase());
			 }
		}	 	
		 
//load serialized file
		
		File f = new File("res/repository.ser");
		
		if (f.exists())
		{
			ObjectInputStream loader = new ObjectInputStream(new FileInputStream(f));
			try
			{
				tree = (BSTReferencedBased) loader.readObject();

			} catch (ClassNotFoundException e)
			{
				System.out.println(".ser file can't be found");
			}
			loader.close();
		}

//read .txt file, add it to the tree, and write the tree to .ser file
		
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("res/repository.ser"));
		String line = in.readLine();
		int lineNum = 1;

		while (line != null)
		{
			String[] words = line.split(" ");

			for (int b = 0; b < words.length; b++)
			{
				String holder = words[b];
				holder = holder.replaceAll("[^a-zA-Z']", "");
				holder = holder.toLowerCase();
				holder = holder.trim();

				if (holder.startsWith("'"))
				{
					holder = holder.substring(1);
				}
				if (holder.endsWith("'"))
				{
					holder = holder.replace("'", "");
				}
				
				if(!tree.isEmpty() && !tree.contains(holder) && !holder.equals(""))
				{
					tree.add(holder);
					tree.search(holder).addInstance(filePath +", "+ lineNum);					
				}
				
				else if(tree.isEmpty() && !holder.equals(""))
				{
					tree.add(holder);	
					tree.search(holder).addInstance(filePath +", "+ lineNum);
				}
				
				else
				{
					if (!holder.equals(""))
					{
						tree.search(holder).addInstance(filePath +", "+ lineNum);
					} 
				}
							
			}
		
			line = in.readLine();
			lineNum++;
		}


		in.close();	
		writer.writeObject(tree);
		writer.close();
		
		ObjectInputStream loader = new ObjectInputStream(new FileInputStream(f));
		try
		{
			tree2 = (BSTReferencedBased) loader.readObject();

		} catch (ClassNotFoundException e)
		{
			System.out.println(".ser file can't be found");
		}
		loader.close();
		
//iterators
		if (reportName.equals("")|| reportName.equals(null))
		{
			reportName = "res/defaultReport.txt";
		}
	
		if(reportType.equalsIgnoreCase("f"))
		{
			utility.Iterator foo = tree2.inorderIterator();
			FileWriter fileWriter = new FileWriter(reportName);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    
			while (foo.hasNext())
			{
				String bla = (String) foo.next();
				
				System.out.println(bla);
				printWriter.println(bla);
			
				try
				{
					inst = tree.search(bla).getInstances();
												
					for (int o = 0; o < inst.size(); o++)
					{
						String [] ar = ((String) inst.get(o)).split(",");
						String fn = ar[0];
						System.out.println("\t" + fn);
						printWriter.println("\t" + fn);
					}
					
				} catch (NullPointerException e)
				{
	
				}
			}
		}
	
		
		if(reportType.equalsIgnoreCase("l"))
		{
			utility.Iterator foo = tree2.inorderIterator();
			FileWriter fileWriter = new FileWriter(reportName);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    
			while (foo.hasNext())
			{
				String bla = (String) foo.next();
				
				System.out.println(bla);
				printWriter.println(bla);
			
				try
				{
					inst = tree.search(bla).getInstances();
												
					for (int o = 0; o < inst.size(); o++)
					{
						String [] ar = ((String) inst.get(o)).split(",");
						String fn = ar[0];
						String tr = ar[1];
						System.out.println("\t" + fn +", line number:" +tr);
						printWriter.println("\t" + fn +", line number:" +tr);
					}
					
				} catch (NullPointerException e)
				{
	
				}
			}
		}

		
		if(reportType.equalsIgnoreCase("o"))
		{
			utility.Iterator foo = tree2.inorderIterator();

			FileWriter fileWriter = new FileWriter(reportName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
				    	    
			while (foo.hasNext())
			{
				String bla = (String) foo.next();
	
				System.out.println(bla);
				printWriter.println(bla);
	
				try
				{
					inst = tree.search(bla).getInstances();
												
					for (int o = 0; o < inst.size(); o++)
					{
						String [] ar = ((String) inst.get(o)).split(",");
						String fn = ar[0];
						String tr = ar[1];
						
						System.out.println("\t" + fn +", line #:" +tr );
						printWriter.println("\t" + fn +", line #:" +tr );
					}
					System.out.println("\t\tOccured "+ inst.size() +" times\n");
					printWriter.println("\t\tOccured "+ inst.size() +" times\n");
					
				} catch (NullPointerException e)
				{
	
				}
			}
		    printWriter.close();
		}
	}
}


