package linkedlists;

public class Calculator {

	private DoublyLinkedList<IntNode> list;
	public static final String OPERATIONS = "*/-+%^";

	public Calculator() {
		this.list = new DoublyLinkedList<IntNode>();
	}

	public void push(String token) {
		int value = 0;
		if (OPERATIONS.indexOf(token.charAt(0)) == -1) {
			value = Integer.parseInt(token);
		} else {
			char operation = token.charAt(0);
			switch (operation) {
			case '*': {
				int this1 = this.pop(), this2 = this.pop();
				value = this1 * this2;
				break;
			}
			case '-': {
				int this1 = this.pop(), this2 = this.pop();
				value = this2 - this1;
				break;
			}
			case '+': {
				int this1 = this.pop(), this2 = this.pop();
				value = this1 + this2;
				break;
			}
			case '/': {
				int this1 = this.pop(), this2 = this.pop();
				value = this2 / this1;
				break;
			}
			case '%': {
				int this1 = this.pop(), this2 = this.pop();
				value = this2 % this1;
				break;
			}
			case '^':{
				int this1 = this.pop(), this2 = this.pop();
				value = (int)Math.pow(this2, this1);
			}
			}
		}
		this.list.add(new IntNode(value));
	}

	public int pop() {
		return this.list.remove(this.list.size() - 1).getValue();
	}

}
