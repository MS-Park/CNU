package Question2;


public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(new String[]{"0", "1", "2", "3" ,"4" ,"5" ,"6" ,"7"});
		System.out.println(g);
		g.add("0", "1");
		g.add("0", "4");
		g.add("1", "2");
		g.add("1", "5");
		g.add("2", "3");
		g.add("2", "7");
		g.add("3", "7");
		g.add("4", "5");
		g.add("5", "6");
		System.out.println(g);
		System.out.println("***** �ʺ�켱Ž���� �����ϴ� ���� �湮�ϴ� ������ ��� *****");
		g.PrintBFS();
	}

}
