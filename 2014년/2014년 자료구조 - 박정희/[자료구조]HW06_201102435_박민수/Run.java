/*201102435 �ڹμ�*/

package hw06;

public class Run {

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue();
		System.out.println("==========ȯ�� ť�� ���� �Է�==========");
		q.Add("1");
		q.Add("2");
		q.Add("3");
		q.Add("4");
		q.Add("5");
		q.Add("6");
		q.Add("7");
		q.Add("8");
		q.Add("9");
		q.PrintQueue();
		System.out.println();
		
		System.out.println("==========ȯ�� ť�� ���� �Է�(ũ���ʰ�)==========");
		q.Add("10");
		System.out.println();
		
		System.out.println("==========ȯ�� ť�� ���� �Է�(resize)==========");
		q.Add_resize("10");
		q.Add("11");
		q.Add("12");
		q.Add("13");
		q.Add("14");
		q.Add("15");
		q.Add("16");
		q.Add("17");
		q.Add("18");
		q.Add("19");
		q.PrintQueue();
		System.out.println();
		
		System.out.println("==========ȯ�� ť�� ���� �Է�(ũ���ʰ�)==========");
		q.Add("20");
		System.out.println();
		
		System.out.println("==========ȯ�� ť�� ����(FIFO)==========");
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println();
		
		q.Remove();
		q.PrintQueue();
		System.out.println("==========ȯ�� ť����(ť�� ���������)==========");
		q.Remove();
	
		System.out.println("==========ȯ�� ť�߰�==========");
		q.Add("1");
		q.Add("2");
		q.Add("3");
		q.Add("4");
		q.PrintQueue();
	

	}

}