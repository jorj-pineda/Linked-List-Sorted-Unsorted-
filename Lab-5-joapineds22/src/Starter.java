import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Starter {
	
	//File time
	
	
	
//	public void writeTextLinkedList(String fileName) {
//		
//		Path noPathWrite = Paths.get("LLtxt.txt");			
//		File Linkedtxt = noPathWrite.toFile();
//
//		PrintWriter pw = null;
//		FileWriter fw = null;
//		
//		
//		BufferedWriter bw=null;
//		
//		try {
//			fw = new FileWriter(Linkedtxt);
//			bw = new BufferedWriter(fw);
//			pw = new PrintWriter(bw);
//			
//			
//		} catch(IOException ex){
//			System.err.println("Error with file: " + ex.getMessage());
//			
//		} finally {
//			if (pw != null) {
//				pw.close();
//			}
//		}
//	}
//		
//		
//		public void readTextLinkedList(String filename){
//			//Creating a path just for your records.
//			//This example REQUIRES you have data.txt in your project directory
//			Path noPath = Paths.get("LLtxt.txt");
//			File simpleData = noPath.toFile();
//			//The construction of fr and br may fail, gotta
//			//make them null first so we can tell failure
//			FileReader fr = null;
//			BufferedReader br = null;
//			try{
//			//This can throw file not found exception
//			fr = new FileReader(simpleData);
//			br = new BufferedReader(fr);
//			//Null when we're done
//			String lineOData = br.readLine();
//			while(lineOData!=null){
//			System.out.println("data "+lineOData);
//			lineOData = br.readLine();
//			}
//			} catch (IOException ex){
//			//Print to the error stream
//			//IOException ex will contain attempted file name
//			System.err.println("ERROR accessing :"+ex.getMessage());
//			} finally {
//			//Ok, we're done let's close this down.
//			try {
//			//br may have failed to init, check before closing
//			if(br != null){
//			br.close();
//			}
//			} catch (IOException ex){
//			//We couldn't close the file?
//			//Ok, we're screwed bail.
//			ex.printStackTrace();
//			//Non-zero means we failed
//			System.exit(-1);
//			}
//			}
//			
//		}
	
	public static void main(String[] args) throws OutOfBoundsException {
		
//		unsortedLinkedList<Integer> ll = new unsortedLinkedList<Integer>();
//		
//		
//		//Test for insert & push
//		ll.add(0);
//		ll.add(1);
//		ll.add(2);
//		ll.insert(3, 1);
//		ll.push(1);
//		ll.remove(2);
//		System.out.println(ll.toString());
		
//		
//		//tests unsortedDouble
		unsortedDoubleLinkedList dll = new unsortedDoubleLinkedList<>();
		

		dll.add("hello");
		dll.add(4.2);
		dll.add(4);
		dll.insert("hi", 1);
		//System.out.println(dll.toString());

		dll.writeTextLinkedList("DoublyLinkedListFile.txt", dll);
		
		dll.readTextLinkedList("DoublyLinkedListFile.txt");
		
		

//		
//		
//		
		
		
//		
		//tests for sortedLinkedList
//		sortedLinkedList sll = new sortedLinkedList<>();
//		sll.add(3);
//		sll.add(1);
//		sll.add(0);
//		sll.add(-1);
//		
//		sll.add(3);
//		sll.add(2);
//		sll.add(10);
//		//sll.add(20);
//		sll.add(15);
//		
//		sll.add(3);
//		sll.add(0);
//		sll.add(-10);
//		sll.remove(2);
//		sll.add("how");
//		sll.add("hwllo");
//		sll.add("hi");
		
//		System.out.println(sll.toString());
//		
		//I GOT SORTED LINKED LIST TO WORK LETS GOOOO


		
	}
		
	
}
