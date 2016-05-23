/*201102435 �ڹμ�*/

package hw11_1;
 
import java.util.ArrayList;
 
public class UnorderedTree {
	String value;
	int size;
	ArrayList<UnorderedTree> subtrees;
	public static LinkedStack stack = new LinkedStack();
	
	public UnorderedTree(){
		
	}
	
	public UnorderedTree(String value){
		this.value = value;
		this.subtrees = new ArrayList<UnorderedTree>();
		size = 1 ;
	}
	
	public UnorderedTree(String value, ArrayList<UnorderedTree> Trees){
		this.value = value;
		
		this.subtrees = Trees;
		
		size += Trees.size();
		
	}
	
	public int size(){
		return size;
	}
	
	//post-order�� ��ȸ�ϴ� �޼ҵ�
	public void PostOrder(){
		int size = subtrees.size();
		
		stack.push(value);
		
		if(subtrees.size() != 0){
			for(int i = size-1; i>=0 ; i--)
				subtrees.get(i).PostOrder();
		}
	
	}
	
	//pre-order�� ��ȸ�ϴ� �޼ҵ�
	public void PreOrder(){
		int size = subtrees.size();
		
		if(subtrees.size() != 0){
			for(int i = size-1; i>=0 ; i--)
				subtrees.get(i).PreOrder();		
		}

		stack.push(value);
	
	}
}
