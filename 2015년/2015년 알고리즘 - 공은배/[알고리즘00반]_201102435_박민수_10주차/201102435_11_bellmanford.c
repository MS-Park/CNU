#include <stdio.h>
#include <stdlib.h>
 
// ���Ѵ�� ����� ��� ����.
#define INFINITY ((1 << (sizeof(int)*8-2))-1)
 
// ������ ������ ��� ����ü.
typedef struct Edge{
	// ������
	int source;
	// ������
	int dest;
	// ����ġ
	int weight;
}Edge;
 
// ����-���� �˰����� ���� �ϴ� �Լ�.
void BellmanFord(Edge edges[], int edgecount, int nodecount, int source, FILE* fop);
 
int main(){
	FILE* fp;
	FILE* fop;

	// ����� ����
	int node_size = 0;

	// ������
	int start_node = 0;

	// ������ ����.
	int cnt = 0;

	// ������ ������ �����ϴ� ����ü �迭.
	Edge* edge = (Edge*)malloc(sizeof(Edge));
	
	fp = fopen("data11.txt","rt");
	fop = fopen("bellman.txt","wt");

	// ����� ������ �������� ���� �޾Ƴ��´�.
	fscanf(fp, "%d",&node_size);
	fscanf(fp, "%d",&start_node);

	//�������� ������ ���Ͽ��� �޾ƿ� ����ü�� ����.
	while(!feof(fp)){
		edge = (Edge*)realloc(edge, sizeof(Edge)*(cnt+1));
		fscanf(fp, "%d %d %d\n",&edge[cnt].source,&edge[cnt].dest,&edge[cnt].weight);
		cnt++;
	}

	// ���-����� �˰����� �̿��Ͽ� ���������� �� ���� ���� �ִܰŸ��� ���Ѵ�.
	BellmanFord(edge, cnt ,node_size,start_node,fop);
 
	fclose(fp);
	fclose(fop);
	return 0;
}
 
// ������ ������ ���� �迭, ������ ��, ����� ��, ������, �ۼ��� ������ �Ű������� �޾ƿ�.
void BellmanFord(Edge edges[], int edgecount, int nodecount, int source, FILE* fop) {
	int i,j ;
	// �ִܰŸ��� �����ϴ� �迭 ����.
	int* dist = (int*)malloc(sizeof(int)*nodecount);

	// �ִܰŸ� �迭�� �ʱ�ȭ.
	for(i = 0; i < nodecount; i++) {
		if(i == source) dist[i] = 0;
		else dist[i] = INFINITY;
	}

	/* �� ���� ���� �ִܰŸ��� ���.
	���̽�Ʈ�� �˰������ ���̴� ���̽�Ʈ���� ��� ������ ����ġ�� ������ �����ϸ� ���Ҽ�������
	���-���� �˰��� ��� �������� ����� �����ϴ�.*/
	for(i = 0; i < nodecount; i++) {
		for(j = 0; j < edgecount; j++) {
			if(dist[edges[j].dest] > dist[edges[j].source] + edges[j].weight) {
				dist[edges[j].dest] = dist[edges[j].source] + edges[j].weight;
			}
		}
	}

	/* ��ȯ�� �߻��ϴ��� �˻�. 
	��ȯ�� �߻��ϸ�  �����ż����� ����ϰ� �Լ��� �����Ѵ�.*/
	for(i = 0; i < edgecount; i++) {
		if(dist[edges[i].dest] > dist[edges[i].source] + edges[i].weight) {
			printf("��ȯ�� �߻��Ͽ����ϴ�.");
			return ;
		}
	} 
	// ���������� �������� ���� �ִܰŸ� ���.
	for(i = 0; i < nodecount; i++) {
		printf("%d -> %d (%d)\n", source, i, dist[i]);
		fprintf(fop,"%d -> %d (%d)\n", source, i, dist[i]);
	}
}