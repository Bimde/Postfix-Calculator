package linkedlists;

public class DoublyLinkedList<E> {
	protected Node<E> start, end;
	private boolean empty;

	public DoublyLinkedList() {
		this.empty = true;
	}

	public E get(int index) {
		if (this.start == null)
			return null;
		Node<E> temp = this.start;
		for (int i = 0; i < index; i++) {
			if (temp.getNext() == null)
				return null;
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	private Node<E> getNode(int index) {
		if (this.start == null)
			return null;
		Node<E> temp = this.start;
		for (int i = 0; i < index; i++) {
			if (temp.getNext() == null)
				return null;
			temp = temp.getNext();
		}
		return temp;
	}

	public void add(E value) {
		if (this.empty) {
			this.start = new Node<E>(value);
			this.end = this.start;
			this.empty = false;
		} else {
			Node<E> temp = this.start;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Node<E>(value, temp));
			this.end = temp.getNext();
		}
	}

	public int indexOf(E item) {
		Node<E> temp = start;
		int i = 0;
		while (!temp.getValue().equals(item)) {
			temp = temp.getNext();
			i++;
		}
		return i;
	}

	public E getFirst() {
		return this.start.getValue();
	}

	public E getLast() {
		return this.end.getValue();
	}

	public boolean remove(E value) {
		int i = 0;
		boolean done = false;
		while (!done && i < this.size()) {
			if (this.get(i).equals(value)) {
				this.remove(this.getNode(i));
				done = true;
			}
		}
		return done;
	}

	public E remove(int index) {
		if (this.empty || this.size() <= index)
			return null;
		Node<E> temp = this.getNode(index);
		remove(temp);
		return temp.getValue();
	}

	protected void remove(Node<E> node) {
		if (this.start == node) {
			this.start = this.start.getNext();
			if (this.start == null) {
				this.clear();
			} else {
				this.start.setPrevious(null);
			}
		} else if (this.end == node) {
			this.end = node.getPrevious();
			this.end.setNext(null);
		} else {
			node = node.getNext();
			node.setPrevious(node.getPrevious().getPrevious());
			node.getPrevious().setNext(node);
		}
	}

	protected void add(E value, int index) {
		Node<E> temp = this.getNode(index);
		if (temp == null) {
			return;
		} else if (index == this.size()) {
			this.add(value);
		} else if (index > this.size())
			return;
		if (temp == this.start) {
			if (this.end == this.start) {
				temp = new Node<E>(value);
				this.start.setPrevious(temp);
				temp.setNext(this.start);
				this.start = temp;
			} else {
				temp = new Node<E>(value);
				this.start.setPrevious(temp);
				temp.setNext(this.start);
				this.start = temp;
			}
		} else {
			Node<E> add = new Node<E>(value);
			Node<E> temp1 = temp.getPrevious();
			temp1.setNext(add);
			temp.setPrevious(add);
			add.setNext(temp);
			add.setPrevious(temp1);
		}

	}

	public void clear() {
		this.start = null;
		this.end = null;
		this.empty = true;
	}

	public boolean isEmpty() {
		return this.empty;
	}

	public int size() {
		if (this.start == null)
			return 0;
		int temp = 0;
		Node<E> temp1 = this.start;
		while (temp1 != null) {
			temp1 = temp1.getNext();
			temp++;
		}
		return temp;
	}

	public void printAll() {
		Node<E> temp = this.start;
		while (temp != null) {
			System.out.print(temp.getValue());
			temp = temp.getNext();
		}
	}
}
