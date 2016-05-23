package PLHW4;

import compile.TreeFactory;
import ast.ListNode;
import ast.Node;
import ast.IntNode;

public class Run {
	public static int max(Node node) {
		// �ִ밪�� �����ϵ��� �ۼ�
		// value�� next �� �� ū ���� ����
		if (node instanceof ListNode){
			if(node.getNext() == null)
			{
				return max(((ListNode)node).value);
			}
			else
			{
				return  (max(((ListNode)node).value) > max(node.getNext())? max(((ListNode)node).value) : max(node.getNext()));
			}
		}
		else if(node instanceof IntNode){
			if( node.getNext()== null){
				return ((IntNode)node).value;
			}
			else{
				return ( ((IntNode)node).value > max(node.getNext()) ? ((IntNode)node).value : max(node.getNext()));
			}
		}
		else{
			System.out.println("ERROR");
			return 0;
		}
	}

	public static int sum(Node node) {
		// ��� value�� ������ ��ȯ
		// value�� next�� �� ���� �����ϸ��
		if (node instanceof ListNode) {
			if(node.getNext() == null)
			{
				return sum(((ListNode)node).value);
			}
			else
			{
				return sum(((ListNode)node).value) + sum(node.getNext());
			}
		}
		else if(node instanceof IntNode){
			if( node.getNext()== null){
				return ((IntNode)node).value;
			}
			else{
				return ((IntNode)node).value + sum(node.getNext());
			}
		}
		else{
			System.out.println("ERROR");
			return 0;
		}
	}

	public static void main(String[] args) {
		String sourceFileName = "( 3 ( 5 2 3 ) -378 )";
		Node node = TreeFactory.createtTree(sourceFileName);
		System.out.println(sum(node));
		System.out.println(max(node));

	}
}
