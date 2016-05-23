/*�й� 201102435
    �̸� �ڹμ�*/

package hw04_3;

public class InfixToPostfix {

	LinkedStack stack;		//��ȯ�� ����� ����
	String[] Infix ;				//Infix������ �迭
	String[] Postfix ;			//��ȯ�� Postfix�� ������ �迭
	
	InfixToPostfix(){
		
	}
	
	InfixToPostfix(String[] array){
		this.Infix = array;
	}
	public String[] getInfix(){
		return this.Infix;
	}
	public void setInfix(String[] array){
		this.Infix = array;
	}
	
	public String[] getpostfix(){
		return this.Postfix;
	}
	public void setPostfix(String[] array){
		this.Postfix = array;
	}
	//Infix ->Postfix�� ��ȯ�ϴ� �޼ҵ�
	public String[] ToPostfix(){
		
		int size = 0;
		stack = new LinkedStack();
		Postfix = new String[Infix.length];
		for(int i = 0; i<this.Infix.length;i++)
		{
			String temp = this.Infix[i];
			if(isAnOperator(temp)){
				if(temp.equals("(")){
					stack.push(Infix[i]);
				}
				else if(temp.equals("+")){
					if(stack.top == null){
						stack.push(temp);
					}
					else{
						String a1 =(String)stack.pop();
						if(a1.equals("+")||a1.equals("-")||a1.equals("*")||a1.equals("/"))
						{
							this.Postfix[size] = a1;
							size++;
						}
						else{
							stack.push(a1);
						}
						stack.push(temp);
					}
				}
				else if(temp.equals("-"))
				{
					if(stack.top == null){
						stack.push(temp);
					}
					else{
						String a1 =(String)stack.pop();
						if(a1.equals("+")||a1.equals("-")||a1.equals("*")||a1.equals("/"))
						{
							this.Postfix[size] = a1;
							size++;
						}
						else{
							stack.push(a1);
						}
						stack.push(temp);
					}
				}
				else if(temp.equals("*"))
				{
					if(stack.top == null){
						stack.push(temp);
					}
					else{
						String a1 =(String)stack.pop();
						if(a1.equals("*")||a1.equals("/"))
						{
							this.Postfix[size] = a1;
							size++;
						}
						else{
							stack.push(a1);
						}
						stack.push(temp);
					}
				}
				else if(temp.equals("/"))
				{
					if(stack.top == null){
							stack.push(temp);
					}
					else{
						String a1 =(String)stack.pop();
						if(a1.equals("*")||a1.equals("/"))
						{
							this.Postfix[size] = (String)stack.pop();
							size++;
						}
						else{
							stack.push(a1);
						}
						stack.push(temp);
					}
				}
				else if(temp.equals(")"))
				{
					while(true){
						String tmp = (String)stack.pop();
						if(tmp.equals("(")) break;
						this.Postfix[size] = tmp;
						size++;
					}
				}
			}
			else{
				this.Postfix[size] = temp;
				size++;
			}
		}
		Postfix[size] = (String)stack.pop();
		String[] tmp = new String[size + 1];
		for(int i =0 ; i<tmp.length; i++)
		{
			tmp[i] = Postfix[i];
		}
		Postfix =tmp;
 		return this.Postfix;
	}
	//�ǿ��������� ���������� �����ϴ� �޼ҵ�.
	private boolean isAnOperator(String s){
		return (s.length() == 1 && "+-*/()".indexOf(s) >= 0);
	}
}
