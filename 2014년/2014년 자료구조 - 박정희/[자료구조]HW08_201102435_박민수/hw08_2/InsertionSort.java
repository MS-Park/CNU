/*201102435 �ڹμ�*/

package hw08_2;

public class InsertionSort {
	int[] array;
	InsertionSort(){
		
	}
	InsertionSort(int[] array){
		this.array = array;
	}
	public void startSorting(char a){
		switch(a){
		case 'a': 
			Ascending();
			break;
		case 'b':
			Descending();
			break;
		
		}
	}
	//��������
	public int[] Ascending(){
		for(int i = 1; i<array.length;i++)
		{
			int ai = array[i],j = i;
			for(j = i; j > 0 && array[j-1] > ai ; j--)
			{
				array[j] = array[j-1];
			}
			array[j] = ai;
		}
		return array;
	}
	//��������
	public int[] Descending(){
		for(int i = 1; i<array.length;i++)
		{
			int ai = array[i],j = i;
			for(j = i; j > 0 && array[j-1] < ai ; j--)
			{
				array[j] = array[j-1];
			}
			array[j] = ai;
		}
		return array;
	}
}
