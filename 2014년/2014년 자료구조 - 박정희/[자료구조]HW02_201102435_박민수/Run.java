/****************************
 * �й� : 201102435 �̸� : �ڹμ�   *
 * **************************/
package hw02_1;
 
public class Run {
 
	public static void main(String[] args) {
		
		System.out.println("A1 ����Ʈ ���� ");
		LinkedList A1 = new LinkedList();
		
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		
		System.out.println("A1 ����Ʈ �Է� ");
		A1.insert(13);
		A1.insert(23);
		A1.insert(3);
		A1.insert(4);
		A1.insert(33);
		
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		
		System.out.println("\nA1 ����Ʈ ���� : " +A1.getSize());
		System.out.println("A1 ����Ʈ �� 33�� ���� ����� ����: " +A1.countNodebyitem(33));
		System.out.println("A1 ����Ʈ �� 4 -> 7�� ���� ");
		A1.replace(4, 7);
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		
		System.out.println("\nA1 ����Ʈ�� 3��� ���� ");
		A1.delete(3);
		
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		
		System.out.println("\nA2 ����Ʈ ���� ");
		LinkedList A2 = new LinkedList();
		
		System.out.println("A2 ����Ʈ�� A1����Ʈ�� ����� ���� ");
		A2.insertList(A1);
		
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		System.out.println("\nA2 ����Ʈ ��� : ");
		A2.printList();
		
		System.out.println("\nA3 ����Ʈ ���� ");
		LinkedList A3 = new LinkedList();
		System.out.println("A3 ����Ʈ �Է� ");
		A3.insert(11);
		A3.insert(9);
		A3.insert(15);
		A3.insert(27);
		A3.insert(68);
		System.out.println("A3 ����Ʈ ��� : ");
		A3.printList();
		
		System.out.println("\nA4 ����Ʈ ���� ");
		LinkedList A4 = new LinkedList();
		
		System.out.println("A4 ����Ʈ�� A1�� Append ");
		A4.append(A1);
		System.out.println("A4 ����Ʈ ��� : ");
		A4.printList();
		
		System.out.println("\nA1 ����Ʈ�� 33��� ���� ");
		A1.delete(33);
		System.out.println("A1 ����Ʈ ��� : ");
		A1.printList();
		System.out.println("\nA4 ����Ʈ ��� : ");
		A4.printList();
		System.out.println("\nA2 ����Ʈ ��� : ");
		A2.printList();
		
		
		
		System.out.println("\n A1�� A3 merged ");
	
		LinkedList.merged(A1, A3);
		System.out.println("A1�� A3 merged ����Ʈ ��� : ");
		A1.printList();
		
		
	}
 
}