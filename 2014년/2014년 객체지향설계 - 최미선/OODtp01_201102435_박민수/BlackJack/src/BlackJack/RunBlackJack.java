package BlackJack;

import java.util.Scanner;

public class RunBlackJack {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		Player player = new Player();
		int select =0;
		sc = new Scanner(System.in);
		
		System.out.println("********** ������ ���� �մϴ�. **********");
		
		System.out.println("ī�带 ���徿 ����մϴ�.");
		dealer.getCard(deck.getNextCard());
		player.getCard(deck.getNextCard());
		dealer.getCard(deck.getNextCard());
		player.getCard(deck.getNextCard());
		dealer.getValueOfHand();
		player.getValueOfHand();
		
		dealer.showHand();
		System.out.println();
		player.showHand();
		System.out.println();
		System.out.println("�÷��̾��� �ڵ��� �� :"+ player.ValueOfHand());
		
		if(dealer.ValueOfHand() == 21 && player.ValueOfHand() == 21){
			dealer.finalshowHand();
			System.out.println();
			System.out.println("������ �ڵ��� �� :"+ dealer.ValueOfHand());
			System.out.println("Dealder & Player are BlakJack!");
			System.out.println("���º��Դϴ�!");
			return;
		}
		else if(dealer.ValueOfHand() == 21){
			dealer.finalshowHand();
			System.out.println();
			System.out.println("������ �ڵ��� �� :"+ dealer.ValueOfHand());
			System.out.println("Dealder is BlakJack!");
			System.out.println("������ �¸��Ͽ����ϴ�!");
			return;
		}
		else if(player.ValueOfHand() == 21){
			dealer.finalshowHand();
			System.out.println();
			System.out.println("������ �ڵ��� �� :"+ dealer.ValueOfHand());
			System.out.println("Player is BlakJack!");
			System.out.println("�÷��̾ �¸��Ͽ����ϴ�!");
			return;
		}
		
		while(true){
			if(player.ValueOfHand()<21){
				System.out.println("���� ������ �ൿ�� �����մϴ�. (1. Stand 2.Hit)");
				select = sc.nextInt();
			}else{
				select = 1;
			}
			if (select == 1){
				System.out.println("[Stand]");
				System.out.println("������ ī�带 �����մϴ�.");
				dealer.finalshowHand();
				System.out.println();
				while(dealer.ValueOfHand() < 17){
					System.out.println("������ �ڵ��� ���� 16���Ͽ��� ������ Hit�մϴ�.");
					dealer.getCard(deck.getNextCard());
					dealer.getValueOfHand();
					dealer.finalshowHand();
					System.out.println();
				}
				player.showHand();
				System.out.println();
				
				System.out.println("�÷��̾��� �ڵ��� �� :"+ player.ValueOfHand());
				System.out.println("������ �ڵ��� �� :"+ dealer.ValueOfHand());
				
				if(dealer.ValueOfHand()>21 && player.ValueOfHand()>21){
					System.out.println("Dealer & Player are Bust!");
					System.out.println("������ �¸��߽��ϴ�!");
				}
				else if(dealer.ValueOfHand()>21 && player.ValueOfHand()<21){
					System.out.println("Dealer is Bust!");
					System.out.println("�÷��̾ �¸��߽��ϴ�!");
				}
				else if(dealer.ValueOfHand()<21 && player.ValueOfHand()>21){
					System.out.println("Player is Bust!");
					System.out.println("������ �¸��߽��ϴ�!");
				}
				else if(dealer.ValueOfHand() > player.ValueOfHand()){
					System.out.println("������ �¸��߽��ϴ�!");
				}
				else if(dealer.ValueOfHand() < player.ValueOfHand()){
					System.out.println("�÷��̾ �¸��߽��ϴ�!");
				}
				else{
					System.out.println("���º��Դϴ�!");
				}
				return;		
			}
			if (select == 2){
				System.out.println("[HIT]");
				
				player.getCard(deck.getNextCard());
				player.getValueOfHand();
				
				dealer.showHand();
				System.out.println();
				player.showHand();
				System.out.println();
				System.out.println("�÷��̾��� �ڵ��� �� :"+ player.ValueOfHand());
			}
		}
	}

}
