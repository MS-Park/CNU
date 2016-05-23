package Ds_HW07;

public class BST {

	BST_Node root;
	int count;

	public BST() {

	}

	public BST(String item) {
		this.root = new BST_Node(item);
	}
	public int height(BST_Node tmp){
		if(tmp == null){
			return 0;
		}
		else{
			return 1+Math.max(height(tmp.left),height(tmp.right));
		}
	}
	
	// Ʈ���� �����ϴ� �޼ҵ�
	public void Add(String item) {
		BST_Node temp;
		temp = root;

		while (true) {
			if (this.root == null) {
				this.root = new BST_Node(item);
				break;
			} else if(temp.key.equals(item)){
				temp.value++;
				break;
			} else if (temp.key.compareTo(item) < 0) {

				if (temp.right != null)
					temp = temp.right;
				else {
					temp.right = new BST_Node(item);
					break;
				}
			} else if (temp.key.compareTo(item) > 0) {

				if (temp.left != null)
					temp = temp.left;
				else {
					temp.left = new BST_Node(item);
					break;
				}
			} 
			count++;
		}
		
	}

	// Ʈ���ӿ� Ư������ �ִ��� �˻��ϴ� �޼ҵ�
	public boolean Search(String item) {

		BST_Node temp;
		temp = root;

		while (temp != null) {
			if (temp.key.equals(item)) {
				return true;
			}

			else if (temp.key.compareTo(item) > 0)
				temp = temp.left;
			else if (temp.key.compareTo(item) < 0)
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
	public void inOrder(BST_Node tree) 
	{
		if (isEmpty(tree) == true) {
			return;
		}

		inOrder(tree.left);
		System.out.println(tree.key+": "+tree.value );
		inOrder(tree.right);
	}

	public class BST_Node {

		String key;
		int value;
		BST_Node left,right;
		
		
		public BST_Node(String item) {
			this.key = item;
			this.value = 1;
			this.left = null;
			this.right = null;
		}

	}


}