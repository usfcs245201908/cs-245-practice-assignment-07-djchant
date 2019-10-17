public class LinkedList<T> implements List<T> {
	Node head;
	int numNodes;

	public LinkedList() {
		head = null;
		numNodes = 0;
	}

	public void add(T item) {
		if(head == null) {
			head = new Node(item);
			numNodes++;
		} else {
			Node prev = head;
			while(prev.next != null) {
				prev = prev.next;
			}
			prev.next = new Node(item);
			numNodes++;
		}
	}

	public void add(int pos, T item) {
		if(pos > numNodes || pos < 0) {
			System.out.println("Invalid position.");
			return;
		}

		if(pos == 0) {
			head = new Node(item);
			numNodes++;
		} else {
			Node prev = head;
			Node newNode = new Node(item);
			while(prev.next != null) {
				prev = prev.next;
			}
			newNode.next = prev.next;
			prev.next = newNode;
			numNodes++;
		}
	}

	public T get(int pos) {
		if(pos < 0 || pos > numNodes) {
			System.out.println("Invalid position.");
			return null;
		}

		Node prev = head;
		for(int i = 0; i < pos; i++) {
			prev = prev.next;
		}

		return((T)prev.data);
	}

	public int size() {
		return(numNodes);
	}

	public T remove(int pos) {
		if(pos < 0 || pos > numNodes) {
			System.out.println("Invalid position.");
			return null;
		}

		if(pos == 0) {
			Node temp = head;
			head = head.next;
			numNodes--;
			return ((T)temp.data);
		} else {
			Node prev = head;
			for(int i = 0; i < pos - 1; i++) {
				prev = prev.next;
			}
			Node temp = prev.next;
			prev.next = prev.next.next;
			numNodes--;
			return ((T)temp.data);
		}
	}
}