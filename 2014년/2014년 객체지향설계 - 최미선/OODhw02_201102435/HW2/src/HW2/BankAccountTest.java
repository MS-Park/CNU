package HW2;

import java.util.Scanner;

public class BankAccountTest {

	private static Scanner sc;

	public static void main(String[] args) {
		
		int money = 0;
		sc = new Scanner(System.in);
		
		
		BankAccount bank = new BankAccount("�ڹμ�", 81540, 10000, 1);
		System.out.println("***** ���� ���� *****");
		System.out.println("�̸� : " + bank.getName());
		System.out.println("���¹�ȣ : " + bank.getAccountNumber());
		System.out.println("�ܾ� : " + bank.getBalance());
		
		System.out.println("���ϴ� �ݾ��Ա� : ");
		money = sc.nextInt();
		bank.deposit(money);
		System.out.println("�Ա��� �ܾ� : " + bank.getBalance());
		
		System.out.println("���ϴ� �ݾ� ��� : ");
		money = sc.nextInt();
		try {
			bank.withdraw(money);
		} catch (NegativeBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			System.out.println("�ܾ� : " + bank.getBalance());
		}
		
		
		
	}

}
