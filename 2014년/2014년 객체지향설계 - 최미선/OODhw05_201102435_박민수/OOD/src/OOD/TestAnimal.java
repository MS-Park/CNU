package OOD;

public class TestAnimal {

	public static void main(String[] args) {
		
		System.out.println("**Fish�� �޼ҵ� ȣ��");
		Fish a = new Fish("�ؾ�θ���");
		System.out.println("������� �̸��� "+a.getName()+"�Դϴ�.");
		a.play();
		a.eat();
		a.walk();
		
		System.out.println("**Cat�� �޼ҵ� ȣ��");
		Cat c = new Cat();
		c.setName("����");
		System.out.println("������� �̸��� "+c.getName()+"�Դϴ�.");
		c.setName("�丣�þ�");
		System.out.println("������� �̸��� "+c.getName()+"���� �ٲ���ϴ�.");
		c.play();
		c.eat();
		c.walk();
		
		System.out.println("**Animal Fish�� �޼ҵ� ȣ��");
		Animal b = new Fish();
		b.eat();
		b.walk();
		
		System.out.println("**Animal Spdier�� �޼ҵ� ȣ��");
		Animal e = new Spider();
		e.eat();
		e.walk();
		
		System.out.println("**Pet Cat�� �޼ҵ� ȣ��");
		Pet f = new Cat();
		f.play();
		f.setName("��Ų���");
		System.out.println("�ֿ� ������ �̸��� "+f.getName()+"(��)�� �����մϴ�.");
		
		System.out.println("**��ü�� ���� ���� Ÿ�Ժ�ȯ");
		Animal q = new Fish();
		Fish ff = (Fish)q;
		ff.eat();
		ff.walk();
		ff.play();
		
		
		System.out.println("**������ �׽�Ʈ");
		Animal[] k = new Animal[3];
		k[0] = new Spider();
		k[1] = new Cat();
		k[2] = new Fish();
		k[0].walk();
		k[0].eat();
		k[1].walk();
		k[1].eat();
		k[2].walk();
		k[2].eat();
		}

}
