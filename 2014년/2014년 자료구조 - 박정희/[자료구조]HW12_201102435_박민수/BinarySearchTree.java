/*201102435 �ڹμ�*/

package hw12;

public class BinarySearchTree {

	BST_Node root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(int item) {
		this.root = new BST_Node(item);
	}

	//Ʈ���� ����ϴ� �޼ҵ�
	public void treePrint(BST_Node tree){
		if(root == null) System.out.println("This tree is Empty!");
		
		if(tree == null) return ;
	
		System.out.print("(");
		
		
		if(tree.left == null && tree.right != null)
		{
			System.out.print("null ");
		}
		
		treePrint(tree.left);
		
		
		if(tree.left!=null && tree.right == null) System.out.print(", ");
		else if(tree.left==null && tree.right != null) System.out.print(", ");
		else if(tree.left!=null && tree.right == null) System.out.print(", ");
		else if(tree.left!=null && tree.right != null) System.out.print(", ");
		
		System.out.print(tree.value);
		
		if(tree.left!=null && tree.right == null) System.out.print(", ");
		else if(tree.left==null && tree.right != null) System.out.print(", ");
		else if(tree.left!=null && tree.right == null) System.out.print(", ");
		else if(tree.left!=null && tree.right != null) System.out.print(", ");
		
		
		if(tree.left != null && tree.right == null)
		{
			System.out.print(" null");
		}
		
		treePrint(tree.right);
		
		
		System.out.print(")");
	}
	// Ʈ���� �����ϴ� �޼ҵ�
	public void Add(int item) {
		BST_Node temp;
		temp = root;

		while (true) {
			if (this.root == null) {
				this.root = new BST_Node(item);
				break;
			} else if (temp.value < item) {

				if (temp.right != null)
					temp = temp.right;
				else {
					temp.right = new BST_Node(item);
					break;
				}
			} else if (temp.value > item) {

				if (temp.left != null)
					temp = temp.left;
				else {
					temp.left = new BST_Node(item);
					break;
				}
			} else {
				System.out.println("�ߺ��Ǵ� ���� �ԷµǾ����ϴ�.");
				break;
			}
		}
	}

	// Ʈ���ӿ� Ư������ �ִ��� �˻��ϴ� �޼ҵ�
	public boolean Search(int item) {

		BST_Node temp;
		temp = root;

		while (temp != null) {
			if (temp.value == item) {
				return true;
			}

			else if (temp.value > item)
				temp = temp.left;
			else if (temp.value < item)
				temp = temp.right;
		}
		return false;

	}

	//Ʈ���� ����ִ��� �Ǵ��ϴ� �޼ҵ�
	public boolean isEmpty(BST_Node tree)
	{
		if (tree == null) {
			return true;
		} else {
			return false;
		}
	}

	//����Ž���޼ҵ�
	public void preOrder(BST_Node tree)
	{
		if (isEmpty(tree) == true) {
			return;
		}

		System.out.print(tree.value + " ");
		preOrder(tree.left);
		preOrder(tree.right);
	}

	//����Ž���޼ҵ�
	public void inOrder(BST_Node tree) 
	{
		if (isEmpty(tree) == true) {
			return;
		}

		inOrder(tree.left);
		System.out.print(tree.value + " ");
		inOrder(tree.right);
	}

	//����Ž���޼ҵ�
	public void postOrder(BST_Node tree) 
	{
		if (isEmpty(tree) == true) {
			return;
		}

		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.value + " ");
	}

}
