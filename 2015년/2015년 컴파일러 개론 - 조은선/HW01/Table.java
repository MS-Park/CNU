package HW01;

// ������ �����ϱ� ���� Ŭ����. 
// ������ ���԰� ������ ���̺� �����ϴ����� �Ǻ����ش�.
public class Table {
	static int cnt = 0;
	String[] id = new String[100];
	String[] value = new String[100];
	
	void insertTable(String id, String value){
		for(int i=0;i<cnt;i++)
		{
			if(this.id[i].equals(id))
			{
				this.value[i] = value;
				return ;
			}
		}
		this.id[cnt] = id;
		this.value[cnt] = value;
		cnt ++;
	}
	// ������ ���̺� �����ϸ� �ش��ϴ� ������ value���� ����.
	String lookupTable(String id){
		String result = null;
		for(int i=0;i<cnt;i++)
		{
			if(this.id[i].equals(id))
			{
				result = this.value[i];
			}
		}
		return result;
	}
}
