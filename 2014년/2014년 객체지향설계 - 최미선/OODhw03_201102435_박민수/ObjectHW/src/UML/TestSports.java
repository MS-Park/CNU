package UML;

public class TestSports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Football f = new Football();
		Baseball b = new Baseball();
		Fencing fc = new Fencing();
		
		f.name = "Footbal";
		f.playerNum = 22;
		
		b.name = "Baseball";
		b.playerNum = 18;
		
		fc.name = "Fencing";
		fc.playerNum = 2;
		
		System.out.println(f.name+"�� �÷��̾� ���� "+f.playerNum+"�� �Դϴ�.");
		f.UsingBall();
		
		System.out.println(b.name+"�� �÷��̾� ���� "+b.playerNum+"�� �Դϴ�.");
		b.UsingTool();
		
		System.out.println(fc.name+"�� �÷��̾� ���� "+fc.playerNum+"�� �Դϴ�.");
		fc.UsingSword();
	}

}
