package Week2;

import java.util.Scanner;


public class TestGraph {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(new String[]{"1", "2", "3" ,"4" ,"5" ,"6"});
		g.add("1", "2", 7);
		g.add("1", "3", 9);
		g.add("1", "6", 14);
		g.add("2", "3", 10);
		g.add("2", "4", 15);
		g.add("3", "4", 11);
		g.add("3", "6", 2);
		g.add("4", "5", 6);
		g.add("5", "6", 9);
		
		System.out.println("*******����Ǿ� �ִ� �׷���(��ȣ���� ����ġ)******");
		System.out.println(g);
		
		System.out.println("*******������� ����******");
		System.out.print("����� ���� : ");
		sc = new Scanner(System.in);
		int startNum = sc.nextInt();

		g.Dijkstra(startNum-1);
		g.PrintFlight();
		
		System.out.println("*******����� "+startNum+"���� ������������ ��� ���******");
		System.out.print("������ ���� : ");
	
		int Destination = sc.nextInt();
		System.out.println(startNum+" ���� "+Destination+"������ ���");
		g.Route(Destination-1);
	}

}
