import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void getSize() throws OutOfBoundsException {
		unsortedLinkedList<Integer> list1 = new unsortedLinkedList<Integer>();
		
		list1.push(1);
		list1.push(5);
		list1.insert(3, 1);
		list1.remove(0);
		
		assertTrue(list1.getSize() == 3);
		
	}

	@Test
	public void add() {
		unsortedLinkedList<Integer> list2 = new unsortedLinkedList<Integer>();
		list2.add(1);
		list2.add(4);
		
		assertTrue(list2.getSize() == 2);
		
	}
	
	@Test
	public void insert() throws OutOfBoundsException {
		unsortedLinkedList<Integer> list = new unsortedLinkedList<Integer>();
		list.insert(1, 0);
		list.insert(3,1);
		list.insert(4,2);
		list.insert(5, 1);
		list.insert(6, 99);
		
		
		assertTrue(list.getSize() == 5);
	}
	
	
	@Test
	public void remove() throws OutOfBoundsException{
		unsortedLinkedList<Integer> list = new unsortedLinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.push(0);
		list.insert(2, 2);
		list.remove(3);
		//assertTrue(list.getSize() == 4);
		//below shows that 3(previous at index 3) no longer exists and is replaced by 4
		assertTrue(list.get(3) == 4);
		
		
		
	}
	
	
		
		//Now onto unsorted Double linked list tests
	@Test
	public void push2() throws OutOfBoundsException {
		unsortedDoubleLinkedList<Integer> list1 = new unsortedDoubleLinkedList<Integer>();
		list1.push(3);
		list1.push(1);
		list1.push(4);
		list1.push(6);
		assertTrue(list1.getSize() == 4);
		
	}
	
	@Test
	public void add2() throws OutOfBoundsException {
		unsortedDoubleLinkedList<Integer> list = new unsortedDoubleLinkedList<Integer>();
		
		list.add(2);
		list.add(3);
		list.add(4);
		assertTrue(list.get(2) == 4);
	}
	
	@Test 
	public void insert2() throws OutOfBoundsException{
		unsortedDoubleLinkedList<Integer> list = new unsortedDoubleLinkedList<Integer>();
		list.insert(1,0);
		list.insert(2,1);
		list.insert(3,2);
		
		
		assertTrue(list.get(2) == 3);
	}
	
	
	@Test
	public void remove2() throws OutOfBoundsException{
		unsortedDoubleLinkedList<Integer> list = new unsortedDoubleLinkedList<Integer>();

		
		list.add(1);
		list.add(3);
		list.add(4);
		list.push(0);
		list.insert(2, 2);
		list.remove(3);
		assertTrue(list.getSize() == 4);
		//below shows that 3(previous at index 3) no longer exists and is replaced by 4
		assertTrue(list.get(3) == 4);
	}
	
	@Test
	public void add3() throws OutOfBoundsException{
		sortedLinkedList<Integer> ll3 = new sortedLinkedList<Integer>();
		
		ll3.add(0);
		ll3.add(5);
		ll3.add(3);
		ll3.add(15);
		
		assertTrue(ll3.get(2)==5);
		
	}
		
	
	@Test
	public void remove3 ()throws OutOfBoundsException{
		sortedLinkedList<Integer> ll3 = new sortedLinkedList<Integer>();
		
		ll3.add(0);
		ll3.add(5);
		ll3.add(3);
		ll3.add(15);
		ll3.remove(2);
		assertTrue(ll3.get(2) == 15);
		

	}


		

		
	
	

}
