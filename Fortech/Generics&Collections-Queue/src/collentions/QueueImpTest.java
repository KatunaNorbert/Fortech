package collentions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class QueueImpTest {

	@Test
	void testSize() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		assertEquals(4,q.size());
	}

	@Test
	void testIsEmpty() {
		QueueImp<Integer> q=new QueueImp<>();
		assertEquals(true,q.isEmpty());
	}

	@Test
	void testContains() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		assertEquals(false,q.contains(9));
	}

	@Test
	void testIterator() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		Iterator<Integer> it=q.iterator();
		assertEquals(true,it.hasNext());
	}

	@Test
	void testToArray() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		Object[] arr=q.toArray();
		assertEquals(2,arr[0]);
		assertEquals(5,arr[1]);
		assertEquals(7,arr[2]);
		assertEquals(8,arr[3]);
	}

	@Test
	void testToArrayObjectArray() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		Object[] arr=new Object[4];
		assertEquals(arr,q.toArray(arr));
	}

	@Test
	void testRemoveObject() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		assertEquals(true,q.remove(8));
		assertEquals(false,q.remove(10));
	}

	@Test
	void testContainsAll() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		LinkedList<Integer> ar1=new LinkedList<>();
		ar1.add(2);
		ar1.add(7);
		ar1.add(8);
		LinkedList<Integer> ar2=new LinkedList<>();
		ar2.add(2);
		ar2.add(7);
		ar2.add(8);
		ar2.add(9);
		assertEquals(true,q.containsAll(ar1));
		assertEquals(false,q.containsAll(ar2));
	}

	@Test
	void testAddAll() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		ArrayList<Integer> ar1=new ArrayList<>();
		ar1.add(2);
		ar1.add(7);
		ar1.add(8);
		assertEquals(true,q.addAll(ar1));
	}

	@Test
	void testRemoveAll() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		ArrayList<Integer> ar1=new ArrayList<>();
		ArrayList<Integer> ar2=new ArrayList<>();
		ar1.add(2);
		ar1.add(7);
		ar1.add(8);
		assertEquals(true,q.removeAll(ar1));
		assertEquals(false,q.removeAll(ar2));
	}

	@Test
	void testRetainAll() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		ArrayList<Integer> ar1=new ArrayList<>();
		ar1.add(2);
		ar1.add(7);
		ar1.add(8);
		q.retainAll(ar1);
		assertEquals(false,q.contains(5));
	}

	@Test
	void testClear() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(2);
		q.offer(5);
		q.offer(7);
		q.offer(8);
		q.clear();
		assertEquals(0,q.size());
	}

	@Test
	void testAdd() {
		QueueImp<Integer> q=new QueueImp<>();
		q.add(6);
		assertEquals(true,q.contains(6));
	}

	@Test
	void testOffer() {
		QueueImp<Integer> q=new QueueImp<>();
		q.offer(10);
		assertEquals(true,q.contains(10));
	}

	@Test
	void testRemove() {
		QueueImp<Integer> q=new QueueImp<>();
		q.add(6);
		q.add(3);
		q.remove(3);
		assertEquals(false,q.contains(3));
		assertEquals(false,q.remove(3));
	}

	@Test
	void testPoll() {
		QueueImp<Integer> q=new QueueImp<>();
		q.add(6);
		q.add(3);
		q.poll();
		assertEquals(false,q.contains(6));
		int val=q.poll();
		assertEquals(3,val);
	}

	@Test
	void testElement() {
		QueueImp<Integer> q=new QueueImp<>();
		q.add(6);
		q.add(3);
		int val=q.element();
		assertEquals(6,val);
	}

	@Test
	void testPeek() {
		QueueImp<Integer> q=new QueueImp<>();
		assertEquals(null,q.peek());
		q.add(6);
		q.add(3);
		int val=q.peek();
		assertEquals(6,val);
	}

}
