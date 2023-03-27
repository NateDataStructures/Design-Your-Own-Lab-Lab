public class MyCircularlyDoublyLinkedList<E> implements MyList<E> {
	private Node<E> tail;
	private int size = 0; // Number of elements in the list

	/**
	 * Create an empty list
	 */
	public MyCircularlyDoublyLinkedList() {
	}

	/**
	 * Create a list from an array of objects
	 */
	public MyCircularlyDoublyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override
	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/**
	 * Return the head element in the list
	 */
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return tail.next.element;
		}
	}

	/**
	 * Return the last element in the list
	 */
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

/******************************************************
 Lesson/Study: Implement the Following Six Methods  */

	/**
	 * Add an element to the beginning of the list
	 */
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);

		if (tail == null) {
			tail = newNode;
			tail.next = tail;
			newNode.previous = tail;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			newNode.previous = tail;
		}
		size++;


	}

	/**
	 * Add an element to the end of the list
	 */
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);

		if (tail == null) {
			tail = newNode;
			tail.next = tail;
			newNode.previous = tail;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		size++;
	}

	public void addBefore(E e, E before) {
		Node<E> newNode = new Node<>(e);
		Node<E> current = tail.next;
		Node<E> previous = tail;

		if (tail == null) {
			tail = newNode;
			tail.next = tail;
			newNode.previous = tail;
		} else {
			while (current.element != before) {
				previous = current;
				current = current.next;
			}
			newNode.next = current;
			previous.next = newNode;
			newNode.previous = previous;
			current.previous = newNode;
		}
		size++;
	}

	@Override
	/** Add a new element at the specified index
	 * in this list. The index of the head element is 0 */
	public void add(int index, E e) {
		if(index == 0) addFirst(e);
		else if(index >= size) addLast(e);
		else {
			Node<E> current = tail.next;
			for(int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;

			current.next = new Node<>(e);
			(current.next).next = temp;

			//set previous
			(current.next).previous = current;
			(temp).previous = current.next;
			size++;
		}

	}

	/**
	 * Remove the head node and
	 * return the object that is contained in the removed node.
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = tail.next;
			tail.next = tail.next.next;
			size--;
			if (tail.next == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	/**
	 * Remove the last node and
	 * return the object that is contained in the removed node.
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = tail;
			tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = tail.next;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			Node<E> temp = tail;
			tail = current;
			tail.next = tail.next.next;
			size--;
			return temp.element;
		}
	}

	@Override
	/** Remove the element at the specified position in this
	 *  list. Return the element that was removed from the list. */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = tail.next;
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}

	}

	/******************************************************/

	@Override
	/** Override toString() to return elements in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = tail.next;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override
	/** Clear the list */
	public void clear() {
		size = 0;
		tail.next = tail = null;
	}

	@Override
	/** Return true if this list contains the element e */
	public boolean contains(Object e) {
		// Left as an exercise
		return indexOf(e) != -1;
	}

	@Override
	/** Return the element at the specified index */
	public E get(int index) {
		if (index == 0) {
			return tail.next.element;
		} else {
			Node<E> current = tail.next.next;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			return current.element;
		}
	}

	@Override
	/** Return the index of the first matching element in
	 *  this list. Return -1 if no match. */
	public int indexOf(Object e) {
		Node<E> current = tail.next;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	@Override
	/** Return the index of the last matching element in
	 *  this list. Return -1 if no match. */
	public int lastIndexOf(E e) {
		Node<E> current = tail.next;
		int lastIndex = -1;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				lastIndex = i;
			}
			current = current.next;
		}
		return lastIndex;
	}

	@Override
	/** Replace the element at the specified position
	 *  in this list with the specified element. */
	public E set(int index, E e) {
		Node<E> current = tail.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.element = e;
		return e;
	}

	@Override
	/** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = tail.next; // Current index

		@Override
		public boolean hasNext() {
			return (current != tail);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}







		@Override
		public void remove() {
			MyCircularlyDoublyLinkedList.this.remove(current);

		}
	}

	public void walkForward() {
		Node<E> current = tail.next;
		while (current != tail) {
			System.out.println(current.element);
			current = current.next;
		}
		System.out.println(current.element);
	}

	//using previous
	public void walkBackward(){
		Node<E> current = tail;
		while(current != tail.next){
			System.out.println(current.element);
			current = current.previous;
		}
		System.out.println(current.element);
	}

//	public void walkBackward() {
//		Node<E> current = tail.next;
//		String txt = "";
//		while (current != tail) {
//			txt = current.element + "\n" + txt;
//			current = current.next;
//		}
//		txt = current.element + "\n" + txt;
//
//		System.out.println(txt);
//	}

	public void rotate() {
		tail = tail.next;
	}

	// In this program, class Node is a nested or inner class, it is used only
	// in its outer class MyLinkedList, so it is private. The purpose of inner
	// classes is purely to be used internally as helper classes.
	//    An inner class is a member of its enclosing class and has access to
	//    other members (including private) of the outer class. And vise versa,
	//    the outer class can have direct access to all members of the inner class.
	//    An inner class can be declared private, public, protected, or package
	//    private. There are two kind of inner classes: static and non-static.
	//    A static inner class cannot refer directly to instance variables or methods
	//    defined in its outer class: it can use them only through an object reference.
	// Class Node will be associated with an instance of MyLinkedList. Node does not
	// need to access any instance members of MyLinkedList, so it is defined static.
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;



		public Node(E element) {
			this.element = element;
		}

	}
}