/*�й� 201102435
    �̸� �ڹμ�*/

package hw02_3;

public class ListBag {
	
		Node top;
		int size;
		ListBag(){
			this.top = null;
			this.size = 0;
		}
		//Bag�� ���ο� Coin�� ����
		public void Add(Coin coin){
			//Coin�� ���� 10,50,100,500,1000�� �Է¹޴´�.
			if(coin.item == 10 ||coin.item == 50 ||coin.item == 100 ||coin.item == 500 ||coin.item == 1000 )
			{
				//Bag�� ���������
				if(this.size == 0){
					this.top =new Node(coin);
				}
				//Bag�� �������������
				else
				{
					Node temp = this.top;
					while(temp.next != null){
						temp = temp.next;
					}
					temp.next = new Node(coin);
				}
				this.size++;
			}
			//�߸��� Coin���� �Է¹޾�����
			else
				System.out.println("�߸��� �޾��� �Է��ϼ̽��ϴ�");
		}
		//Bag���� �Ķ���ͷ� �Է� ���� ������ ����(���� ��쿡 ��������)
		public void removeAt(Coin coin){
			Node cNode = this.top;
			Node pNode = null;
			if(this.size == 0) System.out.println("�� Bag�� ����ֽ��ϴ�");
			else{
				while(true){
					if(cNode.item.getCoin() == coin.item){
						if(cNode == this.top)
							this.top = this.top.next;
						else if(cNode.next == null)
							pNode.next=null;
						else
							pNode.next = cNode.next;
						this.size--;
						break;
					}
					if(cNode.next == null) break;
					pNode = cNode;
					cNode = cNode.next;
				}
			}
		}
		//Bag���� �Ķ���ͷ� �Է¹��� ������ ��� ����(�ߺ��� ���� ����)
		public void remove(Coin coin){
			Node cNode = this.top;
			Node pNode = null;
			if(this.size == 0) System.out.println("�� Bag�� ����ֽ��ϴ�");
			else{
				while(true){
					if(cNode.item.getCoin( ) == coin.item){
						if(cNode == this.top)
							this.top = this.top.next;
						else if(cNode.next == null)
							pNode.next=null;
						else
							pNode.next = cNode.next;
						this.size--;
					}
					if(cNode.next == null) break;
					pNode = cNode;
					cNode = cNode.next;
				}
			}
		}
		//Bag���� ��� Coin ��ü�� ����
		public void removeAll(){
			this.top = null;
			this.size = 0;
		}
		//Bag�� �ش� coin�� �ִ��� Ȯ��
		public boolean isExist(Coin coin){
			Node serch = new Node(this.top.item,this.top.next);
			boolean exist = false;
			//Bag�� ���������
			if(this.size == 0) return exist;
			while(true)
			{
				//ã�� ���������� true���� �־���
				if(serch.item.getCoin() == coin.item){
					exist = true;
					break;
				}
				if(serch.next == null) break;
				serch = serch.next;
			}
			return exist;
		}
		//Bag�� �ش� coin�� � �ִ��� ���
		public void numOfCoin(Coin coin){
			Node serch = new Node(this.top.item,this.top.next);
			int num = 0;
			
			while(true){
				if(serch.item.getCoin() == coin.item){
					num++;
				}
				if(serch.next == null) break;
				serch = serch.next;
			}
			System.out.println(coin.getCoin()+"������ "+num+"�� �ֽ��ϴ�.");
		}
		//Bag�� �ִ� coin�� ���
		public void printBag(){
			if(this.size == 0) System.out.println("�� Bag�� ����ֽ��ϴ�.");
			else
			{
				Node serch = new Node(this.top.item, this.top.next);
				int cnt_10 =0;
				int cnt_50 =0;
				int cnt_100 =0;
				int cnt_500 =0;
				int cnt_1000 =0;
				
				while(true)
				{
					if(serch.item.getCoin() == 10) cnt_10++;
					else if(serch.item.getCoin() == 50) cnt_50++;
					else if(serch.item.getCoin() == 100) cnt_100++;
					else if(serch.item.getCoin() == 500) cnt_500++;
					else if(serch.item.getCoin() == 1000) cnt_1000++;
					
					if(serch.next == null) break;
					serch = serch.next;
				}
				System.out.println("10���� : "+cnt_10+"\n50���� : "+cnt_50+"\n100���� : "+cnt_100+"\n500���� : "+cnt_500+"\n1000���� : "+cnt_1000);
			}
		}
		public class Node {
			Coin item;
			Node next;
			
			Node(int item)
			{
				this.item = new Coin(item);
				this.next = null;
			}
			Node(Coin coin)
			{
				this.item = coin;
				next = null;
			}
			Node(Coin item, Node next)
			{
				this.item = item;
				this.next = next;
			}
		}
}
