/*201102435 �ڹμ�*/

package hw05_2;

public class Run {

	public static void main(String[] args) {
		LinkedQueue que = new LinkedQueue();
		
		que.Add("0");
		que.Add("1");
		que.Add("2");
		que.Add("3");
		que.Add("4");
		que.Add("5");
		que.Add("6");
		que.Add("7");
		que.Add("8");
		que.Add("9");
		que.Add("10");
		que.Add("11");
		
		System.out.print("Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >0 ���� Que Size : "+que.size+"\n");		
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >1 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >2 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >3 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >4 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >5 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >6 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove >7 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove > 8����   Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove > 9  ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove > 10 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");
		
		que.Remove();
		System.out.print("Remove > 11 ���� Que Size : "+que.size+"\n");
		que.PrintQueue();
		System.out.println("");

	}

}
