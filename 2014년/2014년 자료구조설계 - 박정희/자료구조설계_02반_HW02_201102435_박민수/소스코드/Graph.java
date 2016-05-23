package Week2;

public class Graph {
	// �׷����� ũ��
	private int size;
	// ������ �����ϴ� �迭
	private String[] vertices;
	// �ش� ���� ������ ������ �����ϴ� �迭
	private int[] route;
	// �湮������ �ִ��� üũ�ϴ� �迭
	private boolean[] visit;
	// ����ġ�� ����� �������
	private int[][] a;
	// ������������ �ּұ��̰� ����� �迭
	private int[] length;
	// �����
	private int startNum;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		route = new int[size];
		visit = new boolean[size];
		length = new int[size];

		System.arraycopy(args, 0, vertices, 0, size);
		a = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j)
					continue;
				/*�ڱ��ڽ��� ����ġ�°��� �����ϰ� int���� �ִ밪�� ����
				 *(-200000�� �����÷ο츦 �����ϱ����� ���)*/
				a[i][j] = Integer.MAX_VALUE - 200000;
			}
		}

	}

	public void add(String v, String w, int weight) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = weight;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	// ���̽�Ʈ�� �˰���
	public void Dijkstra(int startNum) {
		
		// �޾ƿ� ������� ����
		this.startNum = startNum;
		
		/* ����ġ�� �������� �ּұ��̸� ã���� ���� ���� ����ġ�� ����
		 * ������ �ε����� �޾ƿ� min_index���� �����ϰ� 0���� �ʱ�ȭ*/
		int min_index = 0;

		// visit�迭���� ������� �湮�ߴٰ� true�� ��ũ
		visit[startNum] = true;
		
		/* ������� �������� �� ���������� ����ġ�� ������Ŀ��� �����ϰ�
		 * �ش� ������ ���� ������ �����ϴ� route �迭�� ������� �ε����� �ʱ�ȭ*/
		for (int i = 0; i < size; i++) {
			length[i] = a[startNum][i];
			route[i] = startNum;
		}

		for (int i = 0; i < size; i++) {
			
			// visit[i]�� �湮�ߴٸ� �������� �Ѿ��.
			if (visit[i]) continue;
			
			// �ּҰ��� ã������ ���ҽ� �ʿ��� min�� �����ϰ� ���Ѵ밪���� �ʱ�ȭ
			int min = Integer.MAX_VALUE - 200000;
			
			// ����ġ�� �ּҰ��� ã������ �ݺ���
			for (int j = 0; j < size; j++) {
				// �̹� �湮�ߴ� ���̶�� �������ʴ´�.
				if (visit[j]) continue;
				
				/* min������ ����ġ�� �۴ٸ� min�� �ٲ��ְ� min���� ������ �迭�� �ε����� 
				 * min_index�� �����Ѵ�.*/
				if (min > length[j]) {
					min = length[j];
					min_index = j;
				}
			}
			
			// ���� ª�� �Ÿ��� ã������ �ݺ���
			for (int k = 0; k < size; k++) {
				
				// �湮�ߴ� ���̸� �������� �Ѿ��.
				if (visit[k]) continue;
				
				/* ��������� k�ε����� ������ ���������� �Ÿ��� ����ġ�� 
				 * ���� ���� ������ ���ļ� ���� �ͺ��� ũ�ٸ� �Ÿ��� �ٲپ��ְ�
				 * k�� �ε����� ������ �迭�� �� ������ min_index�� �����Ѵ�.*/
				if (length[k] > length[min_index] + a[min_index][k]) {
					length[k] = length[min_index] + a[min_index][k];
					route[k] = min_index;
				}
				// �湮�ߴٰ� ��ũ
				visit[min_index] = true;
			}
		}
	}
	// �ִܰŸ��� ����ϴ� �޼���
	public void PrintFlight() {
		System.out.println("*****����� " + vertices[startNum]
				+ "���� ���� ���������� �ִܰŸ�*****");
		for (int i = 0; i < size; i++) {
			System.out.print(vertices[startNum] + " -> " + vertices[i]
					+ " �� �ִܰŸ� : " + length[i]);
			System.out.println();
		}
	}
	// ��θ� ����ϴ� �޼���
	public void Route(int Destination) {
		if (Destination == startNum) {
			System.out.print(vertices[Destination]);
			return;
		}
		Route(route[Destination]);

		System.out.print(" -> " + vertices[Destination]);
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}

	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++) {
			if (j == i)
				continue;
			if (a[i][j] != Integer.MAX_VALUE - 200000) {
				buf.append(vertices[j]);
				buf.append("(" + a[i][j] + ")");
			}
		}
		return buf + "";
	}
}
