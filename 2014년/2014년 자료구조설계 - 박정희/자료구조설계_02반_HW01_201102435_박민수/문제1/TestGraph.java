package Question1;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(new String[]{"0", "1", "2", "3" ,"4"});
		System.out.println(g);
		g.add("0", "1");
		g.add("0", "2");
		g.add("1", "2");
		g.add("1", "3");
		g.add("2", "3");
		g.add("3", "4");
		System.out.println(g);
		
		System.out.println("*****1�� 2������ ������ ����(�߰����� ������ �������Ű��)*****");
		g.delete("1", "2");
		System.out.println(g);
		
		System.out.println("*****1�� 3������ ������ ����(ó���� �ι�° ������ �������Ű��)*****");
		g.delete("1", "3");
		System.out.println(g);
		
		System.out.println("*****�߸��� ���� �Է��Ѱ��(5,3)*****");
		g.delete("5", "3");
		
		System.out.println("*****�ΰ������� ������ �������� ���� ���*****");
		g.delete("1", "3");

	}

}
