package TopologicalSorting;

public class Graph {
	int size;
	List[] a;
	// vertex�� indegree
	int[] indegree;

	Stack stack = new Stack();
	Que que = new Que();

	public Graph(String[] args) {
		size = args.length;

		a = new List[size];

		for (int i = 0; i < size; i++) {
			a[i] = new List(args[i]);
		}
		indegree = new int[size];
	}

	public void add(String v, String w) {
		a[index(v)].add(index(w));
		// ������ �߰��Ǹ� indegree�� �����ȴ�.
		indegree[index(w)]++;
	}

	public void delete(String v, String w) {

		// �Է¹��� �ΰ��߿��� �߸��� ���� �Էµɰ�� �޼����� ���� �޼ҵ带 �����Ѵ�
		if (index(v) == size || index(w) == size) {
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			return;
		}

		// �ΰ������� ������ �������� �ʴ´ٸ� �޼ҵ带 �����Ѵ�.
		if (a[index(v)].Checkedges(index(w)) == false) {
			System.out.println("�Է��Ͻ� �����̿� ������ �������� �ʽ��ϴ�.");
			return;
		}
		a[index(v)].delete(index(w));
	}

	// Topological Sorting �޼���
	public void topsort() {
		
		// indegree�� 0�� vertex�� �ε����� ���ÿ� �߰�
		for (int i = 0; i < size; i++) {
			if (indegree[i] == 0) {
				stack.Add(i);
			}
		}
		
		while (stack.size != 0) {
			while (stack.size != 0) {
				int i = stack.Remove();
				que.Add(i);

				while (a[i].edgeNum != 0) {
					indegree[a[i].edges.to]--;
					a[i].delete(a[i].edges.to);
				}
				indegree[i]--;
			}
			for (int i = 0; i < size; i++) {
				if (indegree[i] == 0) {
					stack.Add(i);
				}
			}
		}
		
		if(que.size != this.size){
			System.out.println("���������� �Ҽ������ϴ�.");
		}
		else{
			while(que.size != 0){
				int i = que.Remove();
				System.out.print(a[i].vertex + " ");
			}
		}
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + a[0]);
		for (int i = 1; i < size; i++)
			buf.append("," + a[i]);
		return buf + "}";

	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (a[i].vertex.equals(v))
				return i;
		return a.length;
	}

	private class List {
		String vertex;
		int edgeNum = 0;
		Node edges;

		List(String vertex) {
			this.vertex = vertex;
		}

		public void add(int j) {
			edges = new Node(j, edges);
			edgeNum++;
		}

		// �Է��� �� �����̿� ������ �����ϴ��� ���ϴ��� �˻�� �޼ҵ�� �����ϸ� true�� �������� ������ false�� ����.
		public boolean Checkedges(int j) {
			Node check = edges;
			for (; check != null; check = check.next) {
				if (check.to == j)
					return true;
			}
			return false;
		}

		// �Է��� �� �������� ������ �����ϴ� �޼ҵ�
		public void delete(int j) {
			Node p = edges;

			// ��������Ʈ���� ó���� �ι�° �� ������ ������ ������ ���
			if (edges.to == j) {
				edges = edges.next;
			}
			// �������� ���
			else {
				while (true) {
					if (p.next.to == j)
						break;
					p = p.next;
				}
				p.next = p.next.next;
			}

			edgeNum--;
		}

		public String toString() {
			StringBuffer buf = new StringBuffer(vertex);
			if (edges != null)
				buf.append(":");
			for (Node p = edges; p != null; p = p.next)
				buf.append(Graph.this.a[p.to].vertex);
			return buf + "";
		}

		public class Node {
			int to;
			Node next;

			Node(int to, Node next) {
				this.to = to;
				this.next = next;
			}
		}
	}

}