/*201102435	�ڹμ�*/

package hw10;

public class BinaryTree {

	String root = null;
	BinaryTree left,right;
	
	public BinaryTree(String value)
	{
		this.setRoot(value);
	}
	public BinaryTree(String value, BinaryTree left, BinaryTree right)
	{
		this.setRoot(value);
		this.setRingt(right);
		this.setLeft(left);
		
	}
	public BinaryTree(BinaryTree tree){
		this.root = tree.getRoot();
		this.right = tree.getRingt();
		this.left = tree.getLeft();
	}
	
	//Gettter & Setter
	public String getRoot(){
		return this.root;
	}
	public void setRoot(String data){
		this.root = data;
	}
	public BinaryTree getLeft(){
		return this.left;
	}
	public void setLeft(BinaryTree data){
		this.left = data;
	}
	public BinaryTree getRingt(){
		return this.right;
	}
	public void setRingt(BinaryTree data){
		this.right = data;
	}
	
	//Ʈ���� ����ϴ� �޼ҵ�
	public void ToString(){
		System.out.print("(");
		if(this.left != null)
			this.left.ToString();
		if(this.left != null && this.right != null){
			System.out.print(", ");
			System.out.print(this.root);
			System.out.print(", ");
		}
		else
			System.out.print(this.root);
		if(this.right != null)
			this.right.ToString();
		System.out.print(")");
		
	}
	//Ʈ���� Ư�����ڿ��� ��ִ��� ��ȯ�ϴ� �޼ҵ�
	public int count(String data){
		int cnt=0;
		if(this.left == null && this.right==null){
			if(this.root.equals(data))
				return 1;
			else
				return 0;
		}
		if(this.root.equals(data))
			cnt = 1+this.left.count(data)+this.right.count(data);
		else
			cnt = this.left.count(data)+this.right.count(data);
		return cnt;
	}
	//Ʈ���� full���� �ƴ����� ��ȯ�ϴ� �޼ҵ�
	public boolean isFull(){
		//���� Ʈ���� ��ȭ�϶� ũ�� n = 2^(height+1)-1
		if(this.size() == this.Bsquare(this.height()+1)-1)
			return true;
		else
			return false;
	}
	// Ʈ���� leaf��� ���� ��ȯ�ϴ� �޼ҵ�
	public int numLeaves(BinaryTree tree){
		int num = 0;
		if(tree.left == null && tree.right == null)
			return 1;
		num = numLeaves(tree.left)+numLeaves(tree.right);
		
		return num;

	}
	//Ʈ���� ���̸� ��ȯ�ϴ� �޼ҵ�
	public int height(){
		
		int height = 0;
		int leftH = 0, rightH = 0;
		if(this.left != null) leftH = this.left.height()+1;		// ������ height����
		if(this.right != null) rightH = this.right.height()+1;	// �������� height����
		height = Math.max(leftH, rightH);						// ���� ū���� height������ ������
		return height;	
		
	}
	//Ʈ���� ���Ե� string�� ���� ��ȯ�ϴ� �޼ҵ�
	public int size(){
		
		int size = 1;

		if(this.left != null) size = size + this.left.size();
		if(this.right != null) size = size + this.right.size();		
		
		return size;
		
	}
	//Ʈ���� leaf���� �ƴ����� ��ȯ�ϴ� �޼ҵ�
	public boolean isLeaf(){
		if(this.left == null && this.right == null) return true;
		else
			return false;
	}
	
	//����Ʈ���� ��ȭ���¸� �Ǵ��Ҷ� 2^n�� ����ϱ�����  �޼ҵ�
	public int Bsquare(int n){
		if(n == 1 ) return 2;
		return 2*Bsquare(n-1);
	}
	


}