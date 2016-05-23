/****************************
 * �й� : 201102435 �̸� : �ڹμ�   *
 * **************************/
 
package hw02_1;
 
public class LinkedList {
	
	Node head;
 
	public LinkedList(){
		
	}
	
	public LinkedList(int item){
		this.head = new Node(item);
	}
 /* ���Ը޼ҵ�*/
	public void insert(int item)
	{
		if(isEmpty())			 		//����Ʈ�� ��������� 
			this.head = new Node(item);
		else{							//����Ʈ�� ������� ������
			Node node = this.head;
			while(node.next != null){
				node = node.next;
			}
			node.next = new Node(item);
		}
	}
	/*����Ʈ�� �ٸ�����Ʈ�� ��� ��带 �����ϴ� �޼ҵ�*/
	public void insertList(LinkedList list){
		Node node2 =new Node(list.head.item, list.head.next);
		
		while(true){
			if(this.head== null){
				this.head =new Node(node2.item);		
			}
			else{
				Node node = this.head;
				while(node.next != null){
					node = node.next;
				}
				node.next = new Node(node2.item);
			}
			if(node2.next == null) break;
			node2 = node2.next;

		}
	
		
	}
	/*����Ʈ�� �ٸ�����Ʈ�� ���̴� �޼ҵ�*/
	public void append(LinkedList list){
		Node temp = this.head;
		if(temp == null)
			this.head = list.head;
		else{
			while(true){
				temp = temp.next;
				if(temp.next == null) break;
			}
			temp.next = list.head;
		}
	}
	/*����Ʈ�� ����ִ��� Ȯ���ϴ� �޼ҵ�*/
	public boolean isEmpty(){
		if(this.head == null)			//����Ʈ�� ���������
			return true;
		else									//����Ʈ�� ������� ������
			return false;
	}
	/*Ư�������͸� ���� ��尡 �ִ��� ã�� �޼ҵ�*/
	public Node findNodebyitem(int item){
		
		Node node = this.head;
		while(node.next != null){
			if(node.item == item)			//���ӿ� �ִ� �����Ϳ� Ư�������Ͱ� ��ġ�Ҷ�
				return node;
			else{									//���ӿ� �ִ� �����Ϳ� Ư�������Ͱ� ��ġ���� ������
				node = node.next;
			}
		}
		return null;
		
	}
	/*Ư�������͸� ���� ����� ������ ���� �޼ҵ�*/
	public int countNodebyitem(int item){
		int count =0;
		Node node = this.head;
		while(node != null ){			
			if(node.item == item)				//������ �����Ϳ� Ư�������Ͱ� ��ġ�Ҷ�
				count++;
			node = node.next;
		}
		return count;
	}
	/*����Ʈ���� ����� ������ ���� �޼ҵ�*/
	public int getSize(){
		int count =0;
		Node node = this.head;
		while(node !=null){
			count++;
			node = node.next;
		}
		return count;
	}
	/*����Ʈ���� Ư�� ��带 �����ϴ� �޼ҵ�*/
	public void delete(int item){
		Node cNode = this.head;
		Node pNode = null;
		boolean D = false;
		while(true)
		{
			if(cNode.item == item)
			{
				D = true;
				break;
			}
			
			if(cNode.next == null)	break;
			pNode = cNode;
			cNode = cNode.next;
		}
		if(D)
		{
			if(cNode.item == this.head.item)
			{
				this.head.item = this.head.next.item;
				this.head.next = this.head.next.next;
			}
			else
			{
				pNode.next = cNode.next;
			}
			
		}
	}
	/*����Ʈ���� Ư������� �����͸� �ٸ������ͷ� ��ȯ�ϴ� �޼ҵ�*/
	public void replace(int item1,int item2){
		Node node = this.head;
		while(node.next != null){
			if(node.item == item1)		//���ӿ� �ִ� �����Ϳ� Ư�������Ͱ� ��ġ�Ҷ�
				node.item = item2;		//���ӵ����͸� �ٸ������Ͷ� ��ȯ
			node = node.next;
		}
	}
	/*����Ʈ�� ����� �����͸� ����ϴ� �޼ҵ�*/
	public void printList(){
		Node node = this.head;
		if(isEmpty())
			System.out.println(" �� ����Ʈ�� ����ֽ��ϴ�.");
		else{
			while(node != null)
				{
					System.out.print(" " +node.item);
					node = node.next;
				}
		}
	}
	/*�ٸ� �� ����Ʈ�� ����Ͽ� ���ο� ����Ʈ�� ������ �޼ҵ�*/
	public static LinkedList merged(LinkedList list1,LinkedList list2){
		Node node = list1.head;
		while(node.next != null){
			node = node.next;
		}
		node.next = list2.head;
		return list1;
	}
}
class Node{
	
	int item;
	Node next;
	
	Node()
	{		
	}
	Node(int item)
	{
		this.item = item;
	}
	Node(int item, Node next)
	{
		this.item = item;
		this.next = next;
	}		
	
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
 
}