/*201102435 �ڹμ�*/

package hw07;

public class ArrayCount {
	public static int arrayCount(int[] a,int find,int from){
		int cnt = 0;
		if(from< a.length){
			int temp = a[from];
			if(temp == find)
				cnt = 1+arrayCount(a,find,from+1);
			else
				cnt = arrayCount(a,find,from+1);
		}

		return cnt;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,3,4,5};
		
		System.out.println("�迭 {1,2,3,3,4,5}���� 3�� ������ "+arrayCount(array,3,0)+"�� �Դϴ�.");
		System.out.println("�迭 {1,2,3,3,4,5}���� 2�� ������ "+arrayCount(array,2,0)+"�� �Դϴ�.");
		System.out.println("�迭 {1,2,3,3,4,5}���� 0�� ������ "+arrayCount(array,0,0)+"�� �Դϴ�.");
	}

}
