/*201102435 �ڹμ�*/


package hw13;



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
					temp.right = new BST_Node(item,temp);
					break;
				}
			} else if (temp.value > item) {

				if (temp.left != null)
					temp = temp.left;
				else {
					temp.left = new BST_Node(item,temp);
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
	//�ּҰ��� ã�� �޼ҵ�
	public int get_min(){
		BST_Node temp;
		temp = root;
		int min = 0;
		
		while(temp.left != null)
			temp = temp.left;
		
		min = temp.value;
		
		return min;
	}
	//�ִ밪�� ã�� �޼ҵ�
	public int get_max(){
		BST_Node temp;
		temp = root;
		int max = 0;
		
		while(temp.right != null)
			temp = temp.right;
		
		max = temp.value;
		
		return max;
	}
	//Ư������ ������ Ʈ���� �����ϴ� �޼ҵ�
	public void Delete(int item){
		BST_Node search,smallestInRightside;
		search = root;
		
		//�ݺ����� ���� ������ ���� ã�´�.
		while (search != null) {
			if (search.value == item) {
				break;
			}

			else if (search.value > item)
				search = search.left;
			else if (search.value < item)
				search = search.right;
		}
		
		//�����Ұ��� ������ �޼ҵ带 �����Ѵ�.
		if(search == null){
			System.out.println("ã�� ���� Ʈ���� �������� �ʽ��ϴ�.");
			return ;
		}
		
		//������ ���� �¿� Ʈ���� �������� ������
		if(search.left == null && search.right == null){
			//������ ���� ��Ʈ�� ������ ��Ʈ�� null����� �����Ѵ�.
			if(search == root){
				root = null;
				return ;
			}
			if(search.parent.left == search){
				search.parent.left = null;
			}
			else
				search.parent.right = null;
		}
		//������ ���� ������ Ʈ���� �����ҽ�
		else if(search.left == null && search.right != null){
			
			//������ ���� ��Ʈ���� ������� ��Ʈ�� �����ʰ� �ٲ��� ����.
			if(search == root){
				root = root.right;
				return ;
			}
			if(search.parent.left == search){
				search.parent.left = search.right;
				search.right.parent = search.parent;
			}
			else{
				search.parent.right = search.right;
				search.right.parent = search.parent;
			}
		}
		//������ ���� ���� Ʈ���� �����ҽ�
		else if(search.right == null && search.left != null){
			
			//ã�°��� ��Ʈ���� ������� ��Ʈ�� ���ʰ� �ٲ��� ����.
			if(search == root){
				root = root.left;
				return ;
			}
			if(search.parent.left == search){
				search.parent.left = search.left;
				search.left.parent = search.parent;
			}
			else{
				search.parent.right = search.left;
				search.left.parent = search.parent;
			}
		}
		//������ ���� �¿�Ʈ���� �Ѵ� �����ҽ�
		else{
			
			//������ ���� �������� �ּҰ��� ã�´�.
			smallestInRightside = search.right;
			
			while(smallestInRightside != null){
				if(smallestInRightside.left == null) break;
				smallestInRightside = smallestInRightside.left;
			}
			
			//�����Ұ��� �����Ұ��� �������� �ּҰ��� �ٲپ��ش�.
			search.value = smallestInRightside.value;
			
			if(smallestInRightside.parent.left == smallestInRightside)
				smallestInRightside.parent.left = smallestInRightside.right;
			else
				smallestInRightside.parent.right = smallestInRightside.right;
			
		}
	}

}
