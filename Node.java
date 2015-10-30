package linkedlists;

public class Node<E> {
	private E value;
	private Node<E> next;
	private Node<E> previous;
	
	public Node(E value){
		this.value = value;
	}
	
	public Node(E value, Node<E> previous){
		this.value = value;
		this.previous = previous;
	}
	
	public Node<E> getNext()
	{
		return this.next;
	}
	
	public E getValue()
	{
		return this.value;
	}
	
	public void setNext(Node<E> next)
	{
		this.next = next;
	}
	
	public Node<E> getPrevious()
	{
		return this.previous;
	}
	
	public void setPrevious(Node<E> previous)
	{
		this.previous = previous;
	}
	

}