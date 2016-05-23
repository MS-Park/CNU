/*201102435 �ڹμ�*/

package hw09_2;

public class QuickSortbyIndex {
	int[] array;
	int[] index;
	int start ;
	int end;
	QuickSortbyIndex(){
		
	}
	QuickSortbyIndex(int[] array, int start, int end){
		this.array = array;
		this.start = start;
		this.end = end;
		this.index = new int[array.length];
		for(int i =0; i<index.length;i++)
			index[i] = i;
	}
	public void startSorting(char a){
		switch(a){
		case 'a': 
			Ascending(this.array, this.start, this.end);
			break;
		case 'b':
			Descending(this.array, this.start, this.end);
			break;
		
		}
	}
	//��������
	public void Ascending(int[] array,int start,int end){
		if(end - start <2) 
			return;
		int pivot = A_partition(array,start,end);
		Ascending(array,start,pivot);
		Ascending(array,pivot+1,end);
		
	}
	//��������
	public void Descending(int[] array,int start, int end){
		if(end - start <2) 
			return;
		int pivot = D_partition(array,start,end);
		Descending(array,start,pivot);
		Descending(array,pivot+1,end);
	}



	//��������(DATA �迭�� �񱳿��� ����ϰ� Index���� swap)
	public int A_partition(int[] array, int start, int end){
	
		int pivot = index[start];
		int i = start,j = end;
		
		while(i<j)
		{
			while(j > i && array[index[--j]]>=array[pivot])
				;
			if(j>i) 
				index[i] = index [j];
			while(i<j && array[index[++i]]<= array[pivot])
				;
			if(i<j) 
				index[j] = index[i];
		} 
		index[j] = pivot;
		
		return j;
	}
	//��������(DATA �迭�� �񱳿��� ����ϰ� Index���� swap)
	public int D_partition(int[] array, int start, int end){
		
		int pivot = index[start];
		int i = start,j = end;
		
		while(i<j)
		{
			while(j > i && array[index[--j]]<=array[pivot])
				;
			if(j>i) 
				index[i] = index [j];
			while(i<j && array[index[++i]]>= array[pivot])
				;
			if(i<j) 
				index[j] = index[i];
		} 
		index[j] = pivot;
		
		return j;	}

}
