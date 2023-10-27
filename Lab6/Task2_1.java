package Lab6;

public class Task2_1 {
	public class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

	public class SinglyLinkedList<E> {
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size = 0;

		public SinglyLinkedList() {
			super();
		}
		// Returns the number of elements in the list.

		public int size() {
			return size;
		}
		// Returns true if the list is empty, and false otherwise.

		public boolean isEmpty() {
			return size == 0;
		}

		// Returns (but does not remove) the first element in the list.
		public E first() {
			if (isEmpty())
				return null;
			return head.data;
		}

		// Returns (but does not remove) the last element in the list
		public E last() {
			if (isEmpty())
				return null;
			return tail.data;
		}

		// Adds a new element to the front of the list.
		public void addFirst(E e) {
			head = new Node<>(e, head);
			if (size == 0)
				tail = head;
			size++;
		}
		// Adds a new element to the end of the list.

		public void addLast(E e) {
			Node<E> newNode = new Node<>(e, null);
			if (isEmpty())
				head = newNode;
			else
				tail.next = newNode;
			tail = newNode;
			size++;
		}

		// Removes and returns the first element of the list.
		public E removeFirst() {
			if (isEmpty())
				return null;
			E answer = head.data;
			head = head.next;
			size--;
			if (size == 0)
				tail = null;
			return answer;
		}

		// Removes and returns the last element of the list
		public E removeLast() {
			if (isEmpty())
				return null;
			E element = tail.data;
			if (head == tail) {
				head = tail = null;
			} else {
				Node<E> prevToTail = head;
				while (prevToTail.next != tail) {
					prevToTail = prevToTail.next;
				}
				tail = prevToTail;
				tail.next = null;
			}
			size--;
			return element;
		}

	}

}
