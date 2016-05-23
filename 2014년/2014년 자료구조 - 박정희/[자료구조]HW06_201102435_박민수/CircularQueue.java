/*201102435 �ڹμ�*/

package hw06;

public class CircularQueue {
	int size = 0;			//�迭�� ũ�⸦ �޴� ����
	int DEFAULT_QUEUE_SIZE = 10;			//�迭�� ũ�⸦ ������ �ʾ������� �迭ũ��
	int front;
	int rear;

	String[] array;
	
	
	CircularQueue(){
		this.size = DEFAULT_QUEUE_SIZE;
		array = new String[size];
		rear = size -1;
		front = size - 1;
	}
	
	CircularQueue(int size){
		this.size=size;
		array = new String[size];
		rear = size -1;
		front = size - 1;
	}
	//�迭�� item�� �߰��ϴ� �޼ҵ�(�迭�� ���������� �����޼������)
	public void Add(String item){
		if(isFull()){
			System.out.println("�迭�� �� ���ֽ��ϴ�.");
		}
		
		//��������� ������ ���� ������ Remove�� ������� ���� �߰��ȵǾ ����
		else if(isEmpty()){
			rear = size -1;
			front = size - 1;
			rear = (rear +1)%size;
			array[rear] = item;
		}
		else{
			rear = (rear +1)%size;
			array[rear] = item;
		}
		
	}
	//�迭�� item�� �߰��ϴ� �޼ҵ�� �迭�� ���������� �迭�� ũ�⸦ ���� �迭�� 2��� resize�ؼ� �߰��ϴ� �޼ҵ�
	public void Add_resize(String item){
		if(isFull()){
			String[] temp = new String[size];
			for(int i=0 ;i<size; i++)
			{
				temp[i] = array[i];
			}
			this.size = size*2;
			array = new String[size];
			for(int i = 0; i<temp.length;i++)
			{
				array[i] = temp[i];
			}
			front = size-1;
			rear = (rear +1)%size;
			array[rear] = item;
		}
		
		//��������� ������ ���� ������ Remove�� ������� ���� �߰��ȵǾ ����
		else if(isEmpty()){
			rear = size -1;
			front = size - 1;
			rear = (rear +1)%size;
			array[rear] = item;
		}
		
		else{
			rear = (rear +1)%size;
			array[rear] = item;
		}
	}
	//ť�� ����� �޼ҵ�(FIFO)
	public String Remove(){
		String remove = null ;
		if(isEmpty()){
			System.out.println("�� �迭�� ����־� ���� ����� �����ϴ�.");
		}
		else{
				front = (front +1)%size;
				remove = array[front];
				array[front] = null;
		}
		
		return remove;
	}
	//ť�� �����ִ��� Ȯ���ϴ� �޼ҵ�
	public boolean isFull(){
		return (front == (rear+1)%size);
	}
	//ť�� ����ִ��� Ȯ���ϴ� �޼ҵ�
	public boolean isEmpty(){
		return (rear == front);
	}
	//ť�� ����ϴ� �޼ҵ�(ť�� ��������� �����޼����� ����Ѵ�)
	public void PrintQueue(){
		System.out.print("Print Queue = > ");
		if(rear == front)
		{
			System.out.println("�� �迭�� ����ֽ��ϴ�.");
		}
		else{
			for(int i =(front+1)%size; i<=rear; i++)
				System.out.print(array[i]+" ");
		}
	}
}