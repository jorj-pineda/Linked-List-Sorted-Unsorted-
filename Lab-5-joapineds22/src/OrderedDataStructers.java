import java.util.ArrayList;

//import unsortedDoubleLinkedList.doublyLinkedListNode;

public abstract class OrderedDataStructers<T extends Comparable<T>> implements Iterable<T> {
	
	public abstract T get(int index) throws OutOfBoundsException;
	
	public abstract int add(T value);
	
	protected int Size =0;
	
	
	public OrderedDataStructers() {
		this.Size = 0;
	}
	
	
	public void OrderedDataStructures(ArrayList<T> values) {
		for(T value: values) {
			this.add(value);
			Size++;
		}
	}
	
	public synchronized int getSize() {
		return Size;

	}
	
	ArrayList<T> toArrayList(){
		ArrayList<T> one = new ArrayList<T>(Size);
		
		
		int index = 0;
		for(T value: this) {
			one.set(index, value);
			index++;
		}
		return one;
	}
	
	public String toString() {
		String rtn  = "";
		for(T value: this) {
			rtn += value + ", ";
			
		}
		return rtn;
	}
	
	

}
