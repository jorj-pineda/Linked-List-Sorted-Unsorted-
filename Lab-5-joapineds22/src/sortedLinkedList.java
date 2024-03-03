import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//import unsortedLinkedList.LinkedListNode;

public class sortedLinkedList<T extends Comparable<T>> extends OrderedDataStructers<T> implements  Iterable<T>{

	private doublyLinkedListNode<T> header;

	private doublyLinkedListNode<T> tail;

	//protected int Size = 0;

	/**
	 * imported Linked List Node 
	 * @author Jorge
	 *only here to make sure doubly LL node works
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	private class LinkedListNode<T> {
		private T value;

		@SuppressWarnings("unused")
		private LinkedListNode<T> next;



		//private LinkedListNode<T> prev;

		@SuppressWarnings("unused")
		public LinkedListNode(T value, LinkedListNode<T> next) {
			this.value = value;
			//this.next = next;

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

	/**
	 * Doubly Linked List Node inner class
	 * @author Jorge
	 *deals with linked list node without need of outer class
	 * @param <T>
	 */
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




	public sortedLinkedList() {
		super();
		header = null;
		tail = null;

	}


	/**
	 * Getter for value in sorted linked list
	 * @param index will travel through linked list until location to GET value
	 * @return value requested within LinkedList using index
	 * @throws OutOfBoundsException in case requested index is out of bounds of LinkedList
	 */
	public synchronized  T get(int index) throws OutOfBoundsException {
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
	 * Adds a value and puts it in order. list sets previous to previous header 
	 * and sets new header to previous header's getNext accordingly to the order of numbers (least to greatest) ex. 0, 1, 2, 3
	 * @param value is the value being inserted where it should
	 * @return value at location it belongs (ex inserting 2 in a list 1, 3, 4 | it will now be 1, 2, 3, 4
	 */
	public synchronized int add(T value) {

		int currentIndex = 0;

		
		if(header==null) {
			//doublyLinkedListNode<T> currentHeader= header;

			header = new doublyLinkedListNode<T>(value,null,null);
			//header.setNext(currentHeader);

			setTail();
			Size++;

		} else if(value.compareTo(header.getValue()) <0){
			doublyLinkedListNode<T> currentHeader= header;

			header = new doublyLinkedListNode<T>(value,header,null);
			currentHeader.setPrev(header);
			header.setNext(currentHeader);
			setTail();
			Size++;

		
		}else {

			doublyLinkedListNode<T> currentNode = header;
			//currentIndex++; //Sketchy line

			while(value.compareTo(currentNode.getValue())>0 && currentNode.getNext() != null && currentIndex <= getSize()) {
				currentIndex++;
				currentNode = currentNode.getNext();
				
			}
			if (value.compareTo(currentNode.getValue())<0) {
				currentNode = currentNode.getPrev();
			} 
			//doublyLinkedListNode<T> previousNode = currentNode.getPrev();
			doublyLinkedListNode<T> followNode = currentNode.getNext();
			

			//Points the newly inserted value to the next index and has previous value point at newly inserted value
			doublyLinkedListNode<T> insertedNode = new doublyLinkedListNode<T>(value,followNode, currentNode);
			//				System.out.println("currentNode" +currentNode.getValue());
			//				System.out.println("insertedNode" +insertedNode.getValue());
			
			
			
			
			insertedNode.setPrev(currentNode);
			currentNode.setNext(insertedNode);
			Size++;
			if(insertedNode.getNext() == null){
				tail = insertedNode;
				}
			setTail();
			

		}

		
		return currentIndex;
	}



		/**
		 * Removes a value from LinkedList
		 * @param index is the location where that value will be removed
		 * @return removed value
		 * @throws OutOfBoundsException in case index is out of bounds of what's attainable
		 */
		public synchronized T remove(T value) throws OutOfBoundsException{
			if(header==null || (int) value < 0 || (int) value > getSize()) {
				throw new OutOfBoundsException();
				//return null;
			} else if ((int) value==0) {
				T rtnValue = header.getValue();
				header = header.getNext();
				Size--;
				return rtnValue;


			} else {
				doublyLinkedListNode<T> currentNode = header;

				int currentIndex=1;
				while(currentIndex<(int) value && currentNode.getNext()!=null) {
					currentIndex++;
					currentNode = currentNode.getNext();
				}
				//removes value at index and points previous value to the next value

				if(currentIndex==(int) value && currentNode.getNext()!=null) {
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
			if(Size <1) {
				tail = header;
			} else {

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
						System.out.println("w");
						return tail;

					} else if (tail == header){
						doublyLinkedListNode<T> updateNode = header;
						int currentIndex2=1;
						while(currentIndex2<getSize() && updateNode.getNext()!=null) {
							currentIndex++;
							updateNode = updateNode.getNext();
						}
						System.out.println("works");
						if(currentIndex2==getSize() && updateNode.getNext()!=null) {
							doublyLinkedListNode<T> newTailNode = updateNode.getNext();
							tail = newTailNode;
							return tail;
						}

					}

				}
			}
			return tail;
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



	




	}
