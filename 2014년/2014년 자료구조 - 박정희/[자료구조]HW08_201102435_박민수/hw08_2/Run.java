/*201102435 �ڹμ�*/

package hw08_2;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,4,3,2,1,9,8,7,6};
		InsertionSort B = new InsertionSort(array);
		
		System.out.println("==========��������==========");
		
		System.out.print("���Ŀ� ����� ������ : ");
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		
		System.out.print("\n���� ���� ���� : ");
		B.startSorting('a');
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		
		System.out.print("\n���� ���� ���� : ");
		B.startSorting('b');
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}