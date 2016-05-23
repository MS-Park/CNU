/*201102435 �ڹμ�*/

package hw07;

public class Hanoi {
	public static void print(int n,char x, char y, char z){
		if(n==1) System.out.println(x +" --> "+z);
		else{
			print(n-1,x,z,y);
			System.out.println(x+ " --> " +z);
			print(n-1,y,x,z);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numTowers = 3 ;
		if(args.length>0) numTowers = Integer.parseInt(args[0]);
		System.out.println("hanoi(3, 'A', 'B', 'C') ����");
		print(numTowers,'A','B','C');
	}

}
