package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class Task1_1<E> {

	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public Task1_1() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];

	}

	public Task1_1(int capacity) {
		this.elements = (E[]) new Object[capacity];

	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		E[] newElements = (E[]) new Object[elements.length * 2];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i
	public E get(int i) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		E oldElement = (E) elements[i];
		elements[i] = e;
		return oldElement;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		E removedElement = (E) elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return removedElement;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/*
	 * It is used to return the index in this list of the last occurrence of the
	 * specified element, or -1 if the list does not contain this element.
	 */
	public int lastIndexOf(Object o) {
		for (int index = size - 1; index >= 0; index--) {
			if (o.equals(elements[index])) {
				return index;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = elements[i];
		}
		return array;
	}

	// It is used to return a shallow copy of an ArrayList.
	public Task1_1<E> clone() {
		Task1_1<E> cloneList = new Task1_1<>(elements.length);
		for (int i = 0; i < size; i++) {
			cloneList.add(elements[i]);
		}
		return cloneList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		return indexOf(o) != -1;
	}

	/*
	 * It is used to return the index in this list of the first occurrence of the
	 * specified element, or -1 if the List does not contain this element.
	 */
	public int indexOf(E o) {
		for (int index = 0; index < size; index++) {
			if (o.equals(elements[index])) {
				return index;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		int indexToRemove = indexOf(e);
		if (indexToRemove == -1) {
			return false;
		} else {
			remove(indexToRemove);
			return true;
		}
	}
	// It is used to sort the elements of the list on the basis of specified
	// comparator.

	public void sort(Comparator<E> c) {
		for (int i = 1; i < size; i++) {
			E key = elements[i];
			int j = i - 1;

			while (j >= 0 && c.compare(elements[j], key) > 0) {
				elements[j + 1] = elements[j];
				j = j - 1;
			}
			elements[j + 1] = key;
		}
	}

}
