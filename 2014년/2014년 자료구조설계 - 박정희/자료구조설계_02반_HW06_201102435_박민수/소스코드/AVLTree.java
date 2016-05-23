package hw07;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	
	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(int key){
		this.key = key;
		left = right = NIL;
	}
	
	public boolean add(int key){
		int oldSize = size();
		grow(key);
		return size()>oldSize;
	}
	
	public AVLTree grow(int key){
		if (this == NIL) return new AVLTree(key);
		if (key == this.key) return this;
		if (key < this.key) left = left.grow(key);
		else right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height,right.height);
		return this;
	}
	
	public int size(){
		if(this == NIL) return 0;
		return 1 + left.size()+right.size();
	}
	
	public String toString(){
		if (this == NIL) return "";
		return left + " " +  key + " " + right;
	}
	
	private AVLTree(){
		left = right = this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left,AVLTree right){
		this.key = key;
		this.left = left;
		this.right =right;
		height = 1 + Math.max(left.height, right.height);
	}
	
	private void rebalance(){
		if(right.height > left.height +1){
			if(right.left.height > right.right.height) right.rotateRight();
			rotateLeft();		
		}
		else if (left.height > right.height +1){
			if (left.right.height > left.left.height) left.rotateLeft();
			rotateRight();
		}
	}
	
	private void rotateLeft(){
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}
	private void rotateRight(){
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
	
	// ���� Ž��
	public void inorder(){
		if(this.left !=  NIL){
			this.left.inorder();
		}
		System.out.print(" "+this.key+" ");
		if(this.right !=  NIL){
			this.right.inorder();
		}
		
	}
	
	// Ű ���� �����ϴ� �޼ҵ�.
	public void delete(int key){
		if (this == NIL) return ;
		//key ���� ��Ʈ�� �����Ҷ�.
		if (key == this.key){
			// ��Ʈ���̿ܿ� ���� ������, �� ��尡 �����ȴ�.
			if (this.left == NIL && this.right == NIL){
				this.left = this.right = this;
				this.key = 0;
				this.height = -1;
			}
			// ����Ʈ��  NIL������ ����Ʈ�� �����Ѵٸ� ��Ʈ�� ����Ʈ�� �ȴ�.
			else if (this.left != NIL && this.right == NIL){
				this.key = this.left.key;
				this.height = this.left.height;
				this.right = this.left.right;
				this.left = this.left.left;
			}
			// �������� ��� ��Ʈ�� �������� ���� �������� ��Ʈ���� �ȴ�.
			else{
				AVLTree temp;
				temp = this.right;
				if(temp.left == NIL){
					this.key = temp.key;
					this.right = NIL;
					return;
				}
				while(temp.left.left != NIL){
					temp = temp.left;
				}
				this.key = temp.left.key;
				temp.left = NIL;
				temp.height = 1+ Math.max(temp.left.height, temp.right.height);
			}
			
		}
		// Ű���� ��Ʈ�� Ű������ ������
		if (key < this.key){
			// ����Ʈ�� Ű���� ���� ��, ����Ʈ�� ���� ����̸� left�� NIL�� �ȴ�.
			if(left.key == key && left.left == NIL && left.right == NIL){
				left = NIL;
			}
			else{
				left.delete(key);
			}
		}
		else{
			// ����Ʈ�� Ű���� ������, ����Ʈ�� ��������̸� ����Ʈ�� NIL�� �ȴ�.
			if(right.key == key && right.left == NIL && right.right == NIL){
				right = NIL;
			}
			else {
				right.delete(key);
			}
		}
		rebalance();
		height = 1 + Math.max(left.height,right.height);
	
	}
}