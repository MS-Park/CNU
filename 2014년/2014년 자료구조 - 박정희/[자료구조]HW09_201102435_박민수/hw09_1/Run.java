/*201102435 �ڹμ�*/

package hw09_1;

public class Run {

	public static void main(String[] args) {
		int[] array = {15,36,40,31,22,51,19,28,37,36};
		QuickSort B = new QuickSort(array,0,array.length);
		
		System.out.println("==========QuickSort==========");
		
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
