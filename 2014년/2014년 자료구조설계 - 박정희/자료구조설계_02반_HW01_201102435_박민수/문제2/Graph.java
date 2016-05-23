package Question2;

public class Graph {
	int size;
	String[] vertices;
	//BFS�� �湮�ߴ��� ���(�̹湮�� 0, �湮�� 1)
	int[] visitvertices;
	boolean[][] a;
	//BFS�� ����� ť
	LinkedQueue que = new LinkedQueue();
	
	public Graph(String[] args){
		size = args.length;
		vertices = new String[size];
		visitvertices = new int[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}
	
	public void add(String v, String w){
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}
	
	public String toString(){
		if(size == 0) return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1 ; i < size ; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}
	
	private int index(String v){
		for (int i = 0; i<size ; i++)
			if(vertices[i].equals(v)) return i;
		return a.length;
	}
	
	//�ʺ�켱Ž���� �����ϴ� �޼ҵ�
	public void BFS(){
		//�������� ����(vertices[0])
		que.Add(vertices[0]);
		
		while (que.size !=0){
			int i = index(que.Remove());
			//�湮�� ���� �湮�ߴٰ� ǥ��
			visitvertices[i] = 1;
			for (int j = 0; j < size; j++)
				//�� �������̿� ������ �����ϰ� �湮������ ���� que�ӿ� �������� �ʴ´ٸ� que�� �߰�.
				if(a[i][j] && visitvertices[j] != 1 && que.Search(vertices[j]) != true) 
					que.Add(vertices[j]);
		}
	}
	
	//�ʺ�켱Ž���� ������ ����� ����Ʈ�ϴ� �޼ҵ�
	public void PrintBFS() {
		// �������� ����(vertices[0])
		que.Add(vertices[0]);

		while (que.size != 0) {
			int i = index(que.Remove());
			//�湮�� ���� �湮�ߴٰ� ǥ��
			visitvertices[i] = 1;
			for (int j = 0; j < size; j++)
				//�� �������̿� ������ �����ϰ� �湮������ ���� que�ӿ� �������� �ʴ´ٸ� que�� �߰�.
				if (a[i][j] && visitvertices[j] != 1 && que.Search(vertices[j]) != true)
					que.Add(vertices[j]);
			//BFS�� �����ϸ鼭 �湮�� ���� ���
			System.out.print(vertices[i]);
			if(que.size !=0)
				System.out.print(" -> ");
		}
	}
	
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if(a[i][j]) buf.append(vertices[j]);
		return buf + "";
	}
}
