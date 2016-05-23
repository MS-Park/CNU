package BlackJack;

import java.util.ArrayList;

public class Dealer {
	private ArrayList<Card> dHand = new ArrayList<Card>();
	private int ValueOfHand = 0;
	
	public int ValueOfHand(){
		return this.ValueOfHand;
	}
	
	// ī�带 ��ο��ϴ� �޼ҵ�
	public void getCard(Card c){
		dHand.add(c);
	}
	
	// ������ �ڵ忡 �ִ� ī�带 �����ִ� �޼ҵ�(ù��° ī��� ������)
	public void showHand(){
		System.out.print("������ ���� �ڵ� (ù��°ī��� ������) : ");
		for(int i =1 ; i<dHand.size(); i++){
			System.out.print(dHand.get(i)+" ");
		}
	}
	
	// ���� ������ �ڵ忡 �ִ� ��� ī�带 �����ִ� �޼ҵ�
	public void finalshowHand(){
		System.out.print("������ �����ڵ� : ");
		for(int i =0 ; i<dHand.size(); i++){
			System.out.print(dHand.get(i)+" ");
		}
	}
	
	//������ �ڵ忡�ִ� ī���� ���� ��� ���ϴ� �޼ҵ�
	public void getValueOfHand(){
		int ValueOfHand = 0;
		int findAce = 0;
		for(int i = 0; i<dHand.size();i++){
			if (dHand.get(i).getName().equals("ACE")) {
				findAce++;
				continue;
			}
			ValueOfHand += dHand.get(i).getVlaue();
		}
		// ������ �ڵ忡�� ACE�� ������ 11�� ����Ѵ�.
		while (findAce > 0){
				ValueOfHand += 11;			
		}
		this.ValueOfHand = ValueOfHand;
	}
}
