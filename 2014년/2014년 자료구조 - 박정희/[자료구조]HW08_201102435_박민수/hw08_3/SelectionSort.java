/*201102435 �ڹμ�*/

package hw08_3;
 
public class SelectionSort {
	int[] array;
	SelectionSort(){
		
	}
	SelectionSort(int[] array){
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
		for(int i = 0; i<array.length;i++)
		{
			int min = i ;
			for(int j = i; j<array.length;j++)
			{
				if(array[j]<array[min]) min=j; 
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}
	//��������
	public int[] Descending(){
		for(int i = 0; i<array.length;i++)
		{
			int max = i ;
			for(int j = i; j<array.length;j++)
			{
				if(array[j]>array[max]) max=j; 
			}
			int temp = array[i];
			array[i] = array[max];
			array[max] = temp;
		}
		return array;
	}
}
