package Question2;

public class LinkedQueue {
	int size = 0;
	Node front  = null;
	Node rear = null;
	
	//ť�� �߰��ϴ� �޼ҵ�
	public void Add(String a){
		
		if(this.size == 0){
			this.front = new  Node(a);
			this.rear = this.front;
		}
		else{
			Node temp = this.front;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node(a);
			this.rear = temp.next;
		}
		this.size++;
	}
	
	//ť�� �����ϴ� �޼ҵ�(������ ť�� item���� ����)
	public String Remove(){
		String temp = this.front.item;
		if(this.front.next == null)
		{			
			this.front = null;
		}
		else{
			this.front = this.front.next;
		}
		this.size--;
		return temp;
	}
	
	//�Է¹��� String a�� ��ġ�ϴ� que�� item�� �����ϴ��� ã�� �޼ҵ�(�����ϸ� true, �׷��������� false)
	public boolean Search(String a){
		Node temp = this.front;
		for (; temp != null; temp = temp.next)
			if (temp.item.equals(a)) return true;
		return false;
	}
	public int size(){
		return this.size;
	}
	
	public static class Node{
		String item;
		Node next;
		Node(String item){
			this.item = item;
			this.next = null;
		}	
	} 
 
}