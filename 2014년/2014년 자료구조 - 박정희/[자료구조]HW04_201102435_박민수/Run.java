/*�й� 201102435
    �̸� �ڹμ�*/

package hw04_3;



import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		/* 0~9������ �������� �Է¹޴´�*/
		System.out.println("Input infix expression : ");
		String[] input = sc.nextLine().split("\\s+");
		
		//����ǥ�⸦ ����ǥ��� ��ȯ
		InfixToPostfix infix = new InfixToPostfix();
		infix.setInfix(input);
		infix.ToPostfix();
		
		String[] postfix = new String[infix.ToPostfix().length];		
		for(int i = 0; i<postfix.length;i++){
			postfix[i] = infix.Postfix[i];
		}
		
		PostfixCalculator p = new PostfixCalculator(postfix);
		//����ǥ������ ���
		p.RPN();
		System.out.println("Postfix expression : ");
		for(int i =0 ; i<postfix.length; i++){
			System.out.print(postfix[i]+" ");
		}
		
		System.out.println("\n==========��� ��� ���=============\n");
		
		for(int i = 0;i<postfix.length;i++){
			System.out.print(postfix[i]+" ");
		}
		System.out.println(" = " +p.stack.pop());
	
	
	}

}


