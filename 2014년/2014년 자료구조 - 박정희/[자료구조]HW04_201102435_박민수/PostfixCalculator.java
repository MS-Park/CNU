/*�й� 201102435
    �̸� �ڹμ�*/

package hw04_3;

public class PostfixCalculator {
	LinkedStack stack = new LinkedStack();
	String[] postfixExpression = null;
	
	PostfixCalculator(){
		
	}
	
	PostfixCalculator(String[] array){
		this.postfixExpression = array;
	}
	//����ǥ�⸦ ����ϴ� �޼ҵ�
	public void RPN(){
		for(int i= 0; i<this.postfixExpression.length;i++){
			String temp = this.postfixExpression[i];
			if(isAnOperator(temp)){
				double y = Double.parseDouble((String)stack.pop());
				double x = Double.parseDouble((String)stack.pop());
				double z = evaluate(x,y,temp);
				stack.push(""+z);
			}
			else stack.push(temp);
		}
	}
	
	//���������� �ǿ��������� �����ϴ� �޼ҵ�
	private boolean isAnOperator(String s){
		return (s.length() == 1 && "+-*/".indexOf(s) >= 0);
	}
	//�������ϰ�� ����ϱ����� �޼ҵ�
	private double evaluate(double x, double y, String op){
		double z =0;
		if(op.equals("+")) z=x+y;
		else if(op.equals("-")) z=x-y;
		else if(op.equals("*")) z=x*y;
		else if(op.equals("/")) z=x/y;
		return z;
	}
}
