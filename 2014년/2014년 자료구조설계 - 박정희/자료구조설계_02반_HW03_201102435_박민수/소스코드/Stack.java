package TopologicalSorting;

public class Stack {
	int size = 0;
	Node front = null;
	Node rear = null;

	// ������ �߰��ϴ� �޼ҵ�
	public void Add(int a) {
		if (this.size == 0) {
			this.front = new Node(a);
			this.rear = this.front;
		} 
		else {
			rear.next = new Node(a);
			rear = rear.next;
		}
		this.size++;
	}

	// ������ �����ϴ� �޼ҵ�(������ ������ item���� ����)
	public int Remove() {
		Node temp = this.front;
		int rmstack = 0;
		if (this.size == 0) {
			return -1;
		}
		if (this.size == 1) {
			rmstack = this.front.item;
			this.front = null;
			this.rear = null;
		} 
		else {
			while (temp.next.next != null) {
				temp = temp.next;
			}
			rmstack = temp.next.item;
			temp.next = null;
			this.rear = temp.next;
		}
		this.size--;
		return rmstack;
	}

	public int size() {
		return this.size;
	}

	public static class Node {
		int item;
		Node next;

		Node(int item) {
			this.item = item;
			this.next = null;
		}
	}

}
