import java.util.Iterator;

public class unsortedLinkedList<T extends Comparable<T>> extends OrderedDataStructers<T> implements  Iterable<T>{
	
	@SuppressWarnings("hiding")
	private class LinkedListNode<T> {
		private T value;

		private LinkedListNode<T> next;
		
		//private LinkedListNode<T> prev;
		
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

		public LinkedListNode<T> getNext() {
			return next;
		}

		public void setNext(LinkedListNode<T> next) {
			this.next = next;
		}
		
		
	}

	

	private LinkedListNode<T> header;
	
	
	
	protected int Size= 0;
	
	
	public unsortedLinkedList() {
		super();
		header = null;
	}
	
	
	/**
	 * Adds a value to the beginning of LinkedList
	 * @param value is what gets added to end
	 */
	public void push(T value) {
		if(header==null) {
			header = new LinkedListNode<T>(value,null);
			Size++;
		}else {
			header = new LinkedListNode<T>(value,header);
			
		}
		Size++;
	}
	
	
	/**
	 * Getter for value in linked list
	 * @param index will travel through linked list until location to GET value
	 * @return value requested within LinkedList using index
	 * @throws OutOfBoundsException in case requested index is out of bounds of LinkedList
	 */
	public synchronized T get(int index) throws OutOfBoundsException {
		if(header==null || index < 0) {
			throw new OutOfBoundsException();
			//return null;
		} else if (index==0) {
			T rtnValue = header.getValue();
			return rtnValue;
		} else {
			LinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null)  {
				LinkedListNode<T> nextNode = currentNode.getNext();
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
		if(header==null) {
			header = new LinkedListNode<T>(value,null);
			Size++;
		} else if (index<0) {
			//header = new LinkedListNode<T>(value,header);
			throw new OutOfBoundsException();
			
		} else {
			//still IN PROGESS 
			if (index == 0){
				
				header = new LinkedListNode<T>(value,header);
				Size++;
				
			} else if(index>getSize()) {
				LinkedListNode<T> currentNode = header;
				index = getSize() +1;
				currentIndex++;
				//System.out.println(index);
				while(currentIndex<index && currentNode.getNext()!=null) {
					currentIndex++;
					currentNode = currentNode.getNext();
				}
				
				LinkedListNode<T> addedNode = new LinkedListNode<T>(value,currentNode.getNext());
				currentNode.setNext(addedNode);
				
				Size++;
				return index;
				
				
				
			} else {

			
			LinkedListNode<T> currentNode = header;
			currentIndex++;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			
			//Points the newly inserted value to the next index and has previous value point at newly inserted value
			LinkedListNode<T> insertedNode = new LinkedListNode<T>(value,currentNode.getNext());
			currentNode.setNext(insertedNode);
			Size++;
			
			}
		}
		
		
		return currentIndex;
	}
	
	/**
	 * Adds value to end of list
	 * @param value is the value being added at end
	 * @return value that is being added
	 */
	public synchronized int add(T value) {
		LinkedListNode<T> currentNode = header;
		
		int currentIndex = 0;
		
		if(header==null) {
			header = new LinkedListNode<T>(value,null);
			Size++;
		} else {
		//index = getSize() +1;
		currentIndex++;
		//System.out.println(index);
		while(currentIndex<getSize() && currentNode.getNext()!=null) {
			currentIndex++;
			currentNode = currentNode.getNext();
		}
		
		LinkedListNode<T> newlyaddedNode = new LinkedListNode<T>(value);
		currentNode.setNext(newlyaddedNode);
		
		Size++;
		}
		return (int) value;
		
	}
	
	/**
	 * Removes a value from LinkedList
	 * @param index is the location where that value will be removed
	 * @return removed value
	 * @throws OutOfBoundsException in case index is out of bounds of what's attainable
	 */
	public synchronized T remove(int index) throws OutOfBoundsException{
		if(header==null || index < 0) {
			throw new OutOfBoundsException();
			//return null;
		} else if (index==0) {
			T rtnValue = header.getValue();
			header = header.getNext();
			Size--;
			return rtnValue;
		} else {
			LinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			//removes value at index and points previous value to the next value
			if(currentIndex==index && currentNode.getNext()!=null) {
				LinkedListNode<T> nextNode = currentNode.getNext();
				T rtnValue = nextNode.getValue();
				currentNode.setNext(nextNode.getNext());
				Size--;
				return rtnValue;
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
			LinkedListNode<T> current = header;
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
	public synchronized String toStringHelper(LinkedListNode<T> current) {
		current = header;
		String rtn = "";
		if(current.getNext()!= null) {
			rtn += toStringHelper(current.getNext());
		}
		rtn += ", " + current.getValue();

		return rtn;
	}


	@Override
	public Iterator<T> iterator() {
		Iterator<T> rtnIter = new Iterator<T>(){
			private LinkedListNode<T> current = header;
			
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
				LinkedListNode<T> currentValue = current;
				current = current.getNext();
				return currentValue.getValue();
				}
			};
			return rtnIter;
	}
}
