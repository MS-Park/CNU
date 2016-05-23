package BlackJack;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> pHand = new ArrayList<Card>();
	private int ValueOfHand = 0;
	
	public int ValueOfHand(){
		return this.ValueOfHand;
	}
	
	//ī�带 �ڵ�� �޾ƿ��� �żҵ�
	public void getCard(Card c){
		pHand.add(c);
	}
	
	// �÷��̾��� �ڵ忡 �ִ� ī�带 �����ִ� �޼ҵ�
	public void showHand(){
		System.out.print("�÷��̾��� ���� �ڵ� : ");
		for(int i =0 ; i<pHand.size(); i++){
			System.out.print(pHand.get(i)+" ");
		}
	}
	
	//�÷��̾��� �ڵ忡�ִ� ī���� ���� ��� ���ϴ� �޼ҵ�
	public void getValueOfHand(){
		int ValueOfHand =0;
		int findAce = 0;
		for(int i = 0; i<pHand.size();i++){
			if (pHand.get(i).getName().equals("ACE")) {
				findAce++;
				continue;
			}
			ValueOfHand += pHand.get(i).getVlaue();
		}
		// �÷��̾��� �ڵ忡�� ACE�� ������ �ڵ��� ī���� ���� 10�����ϰ�� 11��, �ƴҰ�� 1�� ����Ѵ�.
		while(findAce > 0){
			if(ValueOfHand <= 10 )
				ValueOfHand += 11;			
			else 
				ValueOfHand += 1;
			findAce--;
		}
		this.ValueOfHand = ValueOfHand;
	}

}
