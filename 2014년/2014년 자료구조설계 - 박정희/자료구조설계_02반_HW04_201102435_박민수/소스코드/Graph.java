package Kuruskal;

public class Graph {
	// �׷����� ũ��
	private int size;
	// ������ �����ϴ� �迭
	private String[] vertices;
	// ����ġ�� ����� �������
	private int[][] a;
	// ��ü ������ ����
	private int e_size = 0;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];

		System.arraycopy(args, 0, vertices, 0, size);

		a = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j)
					continue;
				/*
				 * �ڱ��ڽ��� ����ġ�°��� �����ϰ� int���� �ִ밪�� ����(-200000�� �����÷ο츦 �����ϱ����� ���)
				 */
				a[i][j] = Integer.MAX_VALUE - 200000;
			}
		}

	}

	// ����Į �˰���
	public void kruskal() {
		Edges[] T = new Edges[size - 1];
		Edges[] E = new Edges[e_size];
		int z = 0;
		int q = 0;
		int p = 0;

		// ���� E�� �׷����� ��� �������� �޾ƿ´�.
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (a[i][j] != Integer.MAX_VALUE - 200000 && a[i][j] != 0) {
					E[z] = new Edges(vertices[i], vertices[j], a[i][j]);
					z++;
				}
			}
		}
		// �������� ����
		for (int i = 0; i < e_size; i++) {
			for (int j = i + 1; j < e_size; j++) {
				Edges temp;
				if (E[i].weight > E[j].weight) {
					temp = E[i];
					E[i] = E[j];
					E[j] = temp;
				}
			}
		}
		// ������������ ���ĵ� �������̻���Ŭ�� �������������� T�� ���� �߰�.
		while (q < size - 1 && p < e_size) {
			if (find(E[p], T)) {
				union(E[p], T);
				q++;
			}
			p++;
		}
		if (q != size - 1) {
			System.out.println("����Ʈ���� ����� �����ϴ�.");
		} else {
			System.out.println("�ּ� ����Ʈ���� �����ϴ� ���� : ");
			for (int i = 0; i < size - 1; i++) {
				System.out.println(T[i].v + "-" + T[i].w);
			}
		}

	}

	// �������� �������� ����
	public void union(Edges e, Edges[] T) {
		for (int i = 0; i < size - 1; i++) {
			if (T[i] == null) {
				T[i] = e;
				break;
			}
		}
	}

	// ������ ������ ����Ŭ�� �̷���� üũ
	public boolean find(Edges e, Edges[] T) {
		boolean v = false, w = false;
		for (int i = 0; i < size - 1; i++) {
			if (T[i] == null) {
				continue;
			}
			if (e.v.equals(T[i].w)) {
				v = true;
			}
			if (e.w.equals(T[i].w)) {
				w = true;
			}
		}
		if (v & w) {
			return false;
		}
		return true;
	}

	public void add(String v, String w, int weight) {
		int i = index(v), j = index(w);
		a[i][j] = a[i][j] = weight;
		this.e_size++;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
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

	// �ΰ��� ������ ����ġ�� ������ Ŭ����
	public class Edges {
		private String v;
		private String w;
		private int weight;

		Edges(String v, String w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}
	}
}
