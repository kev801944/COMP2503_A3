/**
 * This is a class for nodes that takes in a type of data and extends from the comparable class.
 * 
 * @author Shaina Anne Garrido and Kevin Luo
 *
 * @param <T>
 */
class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> next;

	/**
	 * constructor for objects of class Node
	 * @param d for data of an element
	 */
	public Node(T d) {
		data = d;
		next = null;
	}

	/**
	 * getter for type T of data
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * setter for type T of data
	 * @param o
	 */
	public void setData(T o) {
		data = o;
	}

	/**
	 * get the next of a Node type T
	 * @return
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * set the next of a Node type T
	 * @param n
	 */
	public void setNext(Node<T> n) {
		next = n;
	}

	/*
	 * toString method
	 * */
	@Override
	public String toString() {
		return getData().toString();
	}

}