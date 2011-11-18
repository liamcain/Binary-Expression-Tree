import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static LinkedList fixNotation(LinkedList badList) {
		badList.addFirst(badList.findAndPop("+"));
		return badList;
	}

	public static BET importDB(){
		BET tree = null;
		ListIterator iter = null;
		 try{
	            Scanner reader = new Scanner(new File("db2.txt"));
	            reader.useDelimiter(" ");

	            LinkedList list = new LinkedList(reader.next());

	            while(reader.hasNext()){
	            	list.add((Object)reader.next());
	            }
	            
	            System.out.println(list);

	            list = fixNotation(list);

	            System.out.println(list);
	            
	            iter = new ListIterator(list);
	            tree = new BET(iter.getPrev());
	        
	             while(iter.hasNext()){
	             	tree.add(iter.next());
	             	/*if(iter.hasNextInt())
	            		tree.add(iter.nextInt());
	            	else
	            		tree.add(iter.next());*/
	             }

	        } catch(IOException e){
	            System.out.println("Unable to read file. " + e.getMessage());
	        }
	    return tree;
	}

	public static void main(String[] args) {
		
		BET tree = importDB();

		System.out.println("Root: " + tree.getRoot());
		System.out.println("Left: " + tree.getRoot().left());
		System.out.println("right: " + tree.getRoot().right());
		System.out.println(tree);
		System.out.println("Evaluated: " + tree.evaluate());
	}

}
