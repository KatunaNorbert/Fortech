package collentions;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueImp<T> implements Queue<T> {

	private int size;
	private static int CAPACITY = 10;
	private Node<T> first;
	private Node<T> last;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		if (first == null)
			return false;
		Node<T> aux = new Node<>();
		aux.setNext(first);
		while (aux.getNext() != null) {
			if (aux.getNext().getValue().equals(o))
				return true;
			aux = aux.getNext();
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if (first == null) {
			return arr;
		} else {
			Node<T> aux = first;
			int poz = 0;
			arr[0] = aux.getValue();
			while (aux.getNext() != null) {
				arr[++poz] = aux.getNext().getValue();
				aux = aux.getNext();
			}
			return arr;
		}
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <Object> Object[] toArray(Object[] a) {
		System.out.println(size);
		if (size > a.length) {
			return (Object[]) toArray();
		}
		if (first == null) {
			return a;
		} else {
			Node<T> aux = first;
			int poz = 0;
			a[0] = (Object) aux.getValue();
			while (aux.getNext() != null) {
				a[++poz] = (Object) aux.getNext().getValue();
				aux = aux.getNext();
			}
			return a;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		Node<T> aux = new Node<>();
		if (first.getValue() == o) {
			first = first.getNext();
			size--;
			return true;
		}
		aux = first;
		while (aux.getNext() != null) {
			if (aux.getNext().getValue() == o) {
				aux.setNext(aux.getNext().getNext());
				size--;
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsAll(Collection<?> c) {
		Node<T> aux = new Node<>();
		for (Object i : c) {
			boolean exist = false;
			aux = first;
			while (aux != null) {
				if (aux.getValue() == i)
					exist = true;
				aux = aux.getNext();
			}
			if (exist == false)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends T> c) {
		int beforeSize=size;
		for (Object i : c) {
			add((T) i);
		}
		if(size==beforeSize) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (size == 0)
			return false;
		boolean changed = false;
		Object[] queue = toArray();
		for (Object i : queue) {
			if (c.contains(i) == true) {
				remove(i);
				changed = true;
			}
		}
		if (changed)
			return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean changed = false;
		Object[] queue = toArray();
		for (Object i : queue) {
			if (c.contains(i) == false) {
				remove(i);
				changed = true;
			}
		}
		if (changed)
			return true;
		return false;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public boolean add(T e) {
		if (size == CAPACITY || e == null) {
			throw new IllegalStateException();
		}
		Node<T> node = new Node<T>(e);
		if (first == null) {
			size++;
			first = node;
			last = node;
		} else if (first.getNext() == null) {
			size++;
			last = node;
			first.setNext(last);
		} else {
			last.setNext(node);
			last = node;
			size++;
		}
		return true;
	}

	@Override
	public boolean offer(T e) {
		if (size == CAPACITY || e == null) {
			throw new IllegalStateException();
		}
		Node<T> node = new Node<T>(e);
		if (first == null) {
			size++;
			first = node;
			last = node;
		} else if (first.getNext() == null) {
			size++;
			last = node;
			first.setNext(last);
		} else {
			last.setNext(node);
			last = node;
			size++;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			T val = first.getValue();
			first = first.getNext();
			size--;
			return val;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T poll() {
		if (first == null) {
			return null;
		} else {
			T val = first.getValue();
			first = first.getNext();
			size--;
			return val;
		}
	}

	@Override
	public T element() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			return first.getValue();
		}
	}

	@Override
	public T peek() {
		if (first == null) {
			return null;
		} else {
			return first.getValue();
		}
	}

	private final class QueueIterator implements Iterator<T> {
		private Node<T> curr;

		QueueIterator() {
			curr = new Node<T>();
			this.curr.setNext(QueueImp.this.first);
		}

		@Override
		public boolean hasNext() {
			return (this.curr != null);
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if (this.curr == null)
				throw new NoSuchElementException();
			this.curr = this.curr.getNext();
			T e = this.curr.getValue();
			if (this.curr.getNext() == null)
				this.curr = null;
			return e;
		}
	}

}
