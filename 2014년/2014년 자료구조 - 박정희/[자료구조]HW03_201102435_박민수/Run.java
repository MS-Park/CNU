/*�й� 201102435
    �̸� �ڹμ�*/

package hw02_3;

public class Run {

	public static void main(String[] args) {
		//����� ���ε�
		
		Coin c1 = new Coin(50);
		Coin c2 = new Coin(10);
		Coin c3 = new Coin(100);
		Coin c4 = new Coin(500);
		Coin c5 = new Coin(1000);
		Coin c6= new Coin(10);
		Coin c7 = new Coin(55);
		Coin c8 = new Coin(10);
		Coin c9 = new Coin(100);
		Coin c10 = new Coin(50);
		
		//Bag�� c7������ ������ ���� ����
		System.out.println("����� ���ΰ��� �����մϴ�.");
		ListBag bag = new ListBag();
		bag.Add(c1);
		bag.Add(c2);
		bag.Add(c3);
		bag.Add(c4);
		bag.Add(c5);
		bag.Add(c6);
		bag.Add(c8);
		bag.Add(c9);
		bag.Add(c10);
		//Bag�ӿ� ���ε� ���
		bag.printBag();
		
		//�߸��� ���λ���
		System.out.println("�߸��� ���ΰ� 55����");
		bag.Add(c7);
		
		//�ش������ǰ���ã��
		System.out.println("50������ ����");
		bag.numOfCoin(c1);
		System.out.println("10������ ����");
		bag.numOfCoin(c2); 
		
		//Ư������ �ϳ��� ����
		System.out.println("500������ �ϳ� ����");
		bag.removeAt(c4);
		bag.numOfCoin(c4);
		//Ư������ ��� ����
		System.out.println("50���� ��� ����");
		bag.remove(c1);
		bag.numOfCoin(c1);
		
		//Ư���������ִ��� Ȯ��
		System.out.println("10������ �����ϴ��� Ȯ��");
		if(bag.isExist(c2)) System.out.println(c2.getCoin()+"������ �����մϴ�.");
		else System.out.println(c2.getCoin()+"������ ���������ʽ��ϴ�.");
		
		System.out.println("55������ �����ϴ��� Ȯ��");
		if(bag.isExist(c7)) System.out.println(c7.getCoin()+"������ �����մϴ�.");
		else System.out.println(c7.getCoin()+"������ ���������ʽ��ϴ�.");
		
		System.out.println("500������ �����ϴ��� Ȯ��");
		if(bag.isExist(c4)) System.out.println(c4.getCoin()+"������ �����մϴ�.");
		else System.out.println(c4.getCoin()+"������ ���������ʽ��ϴ�.");
		
		//Bag �ӿ� �ִ� Coin ��� ����
		System.out.println("Bag�ӿ� �����ϴ� ��� ���λ���");
		bag.removeAll();
		bag.printBag();
	}

}
