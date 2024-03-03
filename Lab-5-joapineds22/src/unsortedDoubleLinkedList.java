import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;


public class unsortedDoubleLinkedList<T extends Comparable<T>> extends OrderedDataStructers<T> implements  Iterable<T>{
	
	@SuppressWarnings("hiding")
	private class LinkedListNode<T> {
		private T value;

		@SuppressWarnings("unused")
		private LinkedListNode<T> next;
		
		//private LinkedListNode<T> prev;
		
		@SuppressWarnings("unused")
		public LinkedListNode(T value, LinkedListNode<T> next) {
			this.value = value;
			this.next = next;
			
		}
		
		public LinkedListNode(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		public void setValue(T value) {
			this.value = value;
		}

		
		
		
}
	

	@SuppressWarnings("hiding")
	private class doublyLinkedListNode<T> extends LinkedListNode<T> {

	
	private doublyLinkedListNode<T> prev;
	
	private doublyLinkedListNode<T> next;
	

	public doublyLinkedListNode(T value, doublyLinkedListNode<T> next, doublyLinkedListNode<T> prev) {
		super(value);
		this.next = next;
		this.prev = prev;
		
		// TODO Auto-generated constructor stub
	}


	public doublyLinkedListNode<T> getPrev() {
		return prev;
	}


	public void setPrev(doublyLinkedListNode<T> prev) {
		this.prev = prev;
	}


	public doublyLinkedListNode<T> getNext() {
		return next;
	}


	public void setNext(doublyLinkedListNode<T> next) {
		this.next = next;
	}
	
	
	
	
	

}

//		
//
//	@SuppressWarnings("unused")
//	private T value;
	
	private doublyLinkedListNode<T> header;
	
	private doublyLinkedListNode<T> tail;
	
	
	protected int Size= 0;
	
	
	public unsortedDoubleLinkedList() {
		super();
		header = null;
		tail = null;
	}
	
	
	
	/**
	 * Adds a value to the beginning of LinkedList and points to next value while that value now points back too
	 * @param value is what gets added to end
	 */
	public synchronized void push(T value) {
		if(header==null) {
			
			header = new doublyLinkedListNode<T>(value,null,null);
			Size++;
			
			
		
		}else {
			doublyLinkedListNode<T> currentHeader = header;
			//System.out.println(header.getValue());
			//doublyLinkedListNode<T> newHeader = header.getPrev();
			header = new doublyLinkedListNode<T>(value,currentHeader,null);
			
			currentHeader.setPrev(header);
			header.setNext(currentHeader);
			Size++;
			setTail();
			
			

		}
	}
	
	
	/**
	 * Getter for value in linked list
	 * @param index will travel through linked list until location to GET value
	 * @return value requested within LinkedList using index
	 * @throws OutOfBoundsException in case requested index is out of bounds of LinkedList
	 */
	public synchronized T get(int index) throws OutOfBoundsException {
		if(header==null || tail == null || index < 0 ) {
			throw new OutOfBoundsException();
			//return null;
		} else if (index==0) {
			T rtnValue = header.getValue();
			return rtnValue;
		} else {
			doublyLinkedListNode<T> currentNode = header;
			//LinkedListNode<T> previousNode = tail;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null)  {
				doublyLinkedListNode<T> nextNode = currentNode.getNext();
				T rtnValue = nextNode.getValue();
				return rtnValue;
			} else {
				return null;
			}
		}
	}
	/**
	 * Inserts value into a place in linked list
	 * @param value is the value that's going to be inserted
	 * @param index is the location the value will be inserted
	 * @return the location of newly inserted value 
	 */
	public synchronized int insert(T value,int index) throws OutOfBoundsException{
		int currentIndex = 0;
		if( header == null) {
			header = new doublyLinkedListNode<T>(value,header,null);
			Size++;

		} else if (index<0) {
			//header = new LinkedListNode<T>(value,header);
			throw new OutOfBoundsException();
			
		} else if (index == 0){
			
			header = new doublyLinkedListNode<T>(value,header,null);
			
			Size++;
			
				
		} else if(index>=getSize()) {
				doublyLinkedListNode<T> currentNode = header;
				doublyLinkedListNode<T> previousNode = currentNode.getPrev();

				index = getSize() +1;
				currentIndex++;
				//System.out.println(index);
				while(currentIndex<index && currentNode.getNext()!=null) {
					currentIndex++;
					currentNode = currentNode.getNext();
					previousNode = currentNode.getPrev();
					
				}
				
				
				doublyLinkedListNode<T> addedNode = new doublyLinkedListNode<T>(value,currentNode.getNext(),previousNode);
				currentNode.setNext(addedNode);
				currentNode.setPrev(previousNode);
				addedNode.setPrev(currentNode);
				tail = addedNode;
				
				Size++;
				return index;
				
				
				
			} else {


			doublyLinkedListNode<T> currentNode = header;
			doublyLinkedListNode<T> previousNode = currentNode.getPrev();
			currentIndex++;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
				previousNode=currentNode.getPrev();
				
			}
			doublyLinkedListNode<T> followNode = currentNode.getNext();
			
			//Points the newly inserted value to the next index and has previous value point at newly inserted value
			doublyLinkedListNode<T> insertedNode = new doublyLinkedListNode<T>(value,currentNode, previousNode);
			//insertedNode.setNext(nextNode);
			insertedNode.setNext(followNode);
			currentNode.setNext(insertedNode);
			currentNode.setPrev(previousNode);
			insertedNode.setPrev(currentNode);
			setTail();
			
			
			Size++;
			
			}
		return currentIndex;
		}
		
		
		
	
	
	/**
	 * Adds a value to end of list and sets previous to previous header 
	 * and sets new header to previous header's getNext
	 * @param value is the value being inserted
	 * @return value at end of list
	 */
	public synchronized int add(T value) {
		doublyLinkedListNode<T> currentNode = header;
		//doublyLinkedListNode<T> currentTail = tail;
		
		int currentIndex = 0;
		
		if(header==null) {
			header = new doublyLinkedListNode<T>(value,null,null);
			Size++;
		} else {

			doublyLinkedListNode<T> previousNode = currentNode.getPrev();

			currentIndex++;
			//System.out.println(index);
			while(currentIndex<getSize() && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
				previousNode = currentNode.getPrev();
			}
			
			
			doublyLinkedListNode<T> addedNode = new doublyLinkedListNode<T>(value,currentNode.getNext(),previousNode);
			currentNode.setNext(addedNode);
			currentNode.setPrev(previousNode);
			addedNode.setPrev(currentNode);
			tail = addedNode;
			//System.out.println(tail);
			//System.out.println(getSize());
			Size++;
			//return index;
		}
		return currentIndex;
		
	}
	
	/**
	 * Removes a value from LinkedList
	 * @param index is the location where that value will be removed
	 * @return removed value
	 * @throws OutOfBoundsException in case index is out of bounds of what's attainable
	 */
	public synchronized T remove(int index) throws OutOfBoundsException{
		if(header==null || index < 0 || index > getSize()) {
			throw new OutOfBoundsException();
			//return null;
		} else if (index==0) {
			T rtnValue = header.getValue();
			header = header.getNext();
			Size--;
			return rtnValue;
			

		} else {
				doublyLinkedListNode<T> currentNode = header;
								
				int currentIndex=1;
				while(currentIndex<index && currentNode.getNext()!=null) {
					currentIndex++;
					currentNode = currentNode.getNext();
				}
				//removes value at index and points previous value to the next value

				if(currentIndex==index && currentNode.getNext()!=null) {
					doublyLinkedListNode<T> nextNode = currentNode.getNext();
					doublyLinkedListNode<T> previousNode = currentNode.getPrev();
					doublyLinkedListNode<T> followingNode = nextNode.getNext();
					
					if(previousNode == null || currentNode == header) {
						T rtnValue= nextNode.getValue();
						currentNode.setNext(nextNode.getNext());
						followingNode.setPrev(currentNode);
						Size--;
						setTail();
						return rtnValue;
					
					}else{
						T rtnValue = nextNode.getValue();
						currentNode.setPrev(previousNode);
						previousNode.setNext(currentNode);
						currentNode.setNext(nextNode.getNext());
						followingNode.setPrev(currentNode);
						setTail();
						Size--;
						return rtnValue;
					}
				} else {
					
					return null;
			}
		}
	}
	
	
	/**
	 * Getter for Size of LinkedList
	 * @return Size of LinkedList
	 */
	public synchronized int getSize() {
		return Size;
		
			}
	
	/**
	 * if tail is null, which it should never be, this will set the Tail (kinda like a countermeasure to some bugs specifically with push)
	 * @return tail
	 */
	public synchronized doublyLinkedListNode<T> setTail() {
		if(tail == null) {
			doublyLinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<getSize() && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==getSize() && currentNode.getNext()!=null) {
				doublyLinkedListNode<T> nextNode = currentNode.getNext();
				tail = nextNode;
				return tail;
			} else { return null;}
		}
		return tail;
	}
	
//	public T pop() {
//		if(header==null) {
//			return null; //Probably should return exception?
//		} else {
//			T currentValue = header.getValue();
//			header = header.getNext();
//			return currentValue;
//		}
//	}
//	
//	public T top() {
//		if(header==null) {
//			return null; //Probably should return exception?
//		} else {
//			T currentValue = header.getValue();
//			return currentValue;
//		}
//	}
	/**
	 * Prints values in LinkedList in order they were put in (First to last)
	 */
	public synchronized String toString() {
		if(header == null) {
			return "List is empty";
		} else {
			String rtn  = "";
			doublyLinkedListNode<T> current = header;
			while(current!=null) {
				rtn+=current.getValue()+", ";
				current = current.getNext();
			}
			return rtn;
		}
	}
	
	/**
	 * toString Recursion
	 * @param current is what grabs header
	 * @return toString neatly
	 */
	public synchronized String toStringHelper(doublyLinkedListNode<T> current) {
		current = header;
		String rtn = "";
		if(current.getPrev()!= null) {
			rtn += toStringHelper(current.getPrev());
		}
		rtn += ", " + current.getValue();
		current = tail;
		if(current.getNext()!= null) {
			rtn += toStringHelper(current.getNext());
		}
		

		return rtn;
	}



	@Override
	public Iterator<T> iterator() {
		Iterator<T> rtnIter = new Iterator<T>(){
			private doublyLinkedListNode<T> current = header;
			
			@Override
			public boolean hasNext() {
					if (current!= null){
						return true;
					} else {
						return false;
					}
			}
			@Override
			public T next() {
				doublyLinkedListNode<T> currentValue = current;
				current = current.getNext();
				return currentValue.getValue();
				}
			};
			return rtnIter;
	}
	/**
	 * Writing to a file time
	 * @param fileName
	 */
	public void writeTextLinkedList(String fileName, unsortedDoubleLinkedList<T> doublyLL) {
		

		PrintWriter pw = null;
		FileWriter fw = null;
//		BufferedWriter bw=null;
		
		try {
			fw = new FileWriter(fileName);
//			bw = new BufferedWriter(fw);
//			pw = new PrintWriter(bw);
			
			BufferedWriter bw = new BufferedWriter(fw);
//			pw = new PrintWriter(bw);

			
			bw.write(doublyLL.toString());

			bw.close();
			
		} catch(IOException ex){
			System.err.println("Error with file: " + ex.getMessage());
			
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
		
	
	public void readTextLinkedList(String fileName) {
		

		//Creating a path just for your records.
		//This example REQUIRES you have data.txt in your project directory
		Path noPath = Paths.get(fileName);
		File simpleData = noPath.toFile();
		//The construction of fr and br may fail, gotta
		//make them null first so we can tell failure
		FileReader fr = null;
		BufferedReader br = null;
		try{
		//This can throw file not found exception
		fr = new FileReader(simpleData);
		br = new BufferedReader(fr);
		//Null when we're done
		String lineOData = br.readLine();
		while(lineOData!=null){
		System.out.println(lineOData);
		lineOData = br.readLine();
		}
		} catch (IOException ex){
		//Print to the error stream
		//IOException ex will contain attempted file name
		System.err.println("ERROR accessing :"+ex.getMessage());
		} finally {
		//Ok, we're done let's close this down.
		try {
		//br may have failed to init, check before closing
		if(br != null){
		br.close();
		}
		} catch (IOException ex){
		//We couldn't close the file?
		//Ok, we're screwed bail.
		ex.printStackTrace();
		//Non-zero means we failed
		System.exit(-1);
		}
		}
		
		
		
	}
	
//	public void writeObjLinkedList(String fileName, unsortedDoubleLinkedList<T> doublyLL) {
//		
//		//Chose text files because we have them
//		//Could be anything.
//		File sourceFile = Paths.get(fileName).toFile();
//		File destFile = Paths.get(sourceFile).toFile();
//		try(
//		FileInputStream fis = new FileInputStream(sourceFile);
//		FileOutputStream fos = new FileOutputStream(destFile);
//		){
//		//copy 4k
//		byte[] buffer = new byte[4096];
//		//Fills the buffer with as many as possible
//		//returns the number of bytes read
//		int bytesRead = fis.read(buffer);
//		while (bytesRead>0){
//		 fos.write(buffer, 0, bytesRead);
//		bytesRead = fis.read(buffer);
//		}
//		}catch(FileNotFoundException e){
//		System.err.println("Unale to locate file "+sourceFile.getAbsolutePath());
//		}catch(IOException e){
//		System.err.println("Unable to copy file "+sourceFile.getAbsolutePath()+" to "+destFile.getAbsolutePath());
//		}
//		
//	}
	
	

}



