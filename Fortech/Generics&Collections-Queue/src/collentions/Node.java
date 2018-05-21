package collentions;


public class Node<T>{
		
		private T value;
		@SuppressWarnings("rawtypes")
		private Node next;
		
		public Node() {
		}
		
		public Node(T value) {
			this.value=value;
		}
		
		
		
		public T getValue() {
			return value;
		}



		public void setValue(T value) {
			this.value = value;
		}



		@SuppressWarnings("rawtypes")
		public Node getNext() {
			return next;
		}



		@SuppressWarnings("rawtypes")
		public void setNext(Node next) {
			this.next = next;
		}



		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
		
		
	}
