#include <stdio.h>
#define INFINITY 999

// Dijkstra �˰����� �����ϴ� �Լ�.
void dijkstra(int n, int v, int cost[10][10], int dist[]);

void main()
{
	// ����� ���� ����.
	int n, v, i, j, cost[10][10], dist[10];

	// ����� ���� �Է¹޾� ���� n�� ����.
	printf("Enter the number of nodes : ");
	scanf("%d", &n);

	// �� ��尣�� �Ÿ��� �ݺ����� �̿��Ͽ� �޾Ƽ� ����.
	printf("\nEnter the cost matrix : \n");
	
	for(i=1; i<=n; i++)
	{
		for(j=1; j<=n; j++)
		{
			scanf("%d", &cost[i][j]);

			// ������ �������� �ʴ� ��� �Ÿ��� INFINITY���� ����.
			if(cost[i][j]==0)
			{
				cost[i][j] = INFINITY;
			}
		}
	}

	
	// �˰� ���� ����� �ε����� �Է� ���� �� ���� v�� ����
	printf("\nEnter the source matrix : ");
	scanf("%d", &v);

	// Dijkstra �˰����� �̿��Ͽ� �ִܰŸ��� ����.
	dijkstra(n, v, cost, dist);

	// �ݺ����� �̿��Ͽ� �ִܰ�θ� ���.
	printf("\nShortest path : \n");

	for(i=1; i<=n; i++)
	{
		if(i!=v)
			printf("%d->%d, cost => %d\n", v-1, i-1, dist[i]);
	}
}

void dijkstra(int n, int v, int cost[10][10], int dist[])
{
	int i, u, count, w, flag[10], min;

	// �ʱ�ȭ.
	for(i=1; i<=n; i++)
	{
		flag[i] = 0;
		dist[i] = cost[v][i];
	}

	count=2;

	// �ִܰŸ��� ���ϱ� ���� �ݺ�.
	// while���� ���� ���������� ����� ��带 �ϳ��� ���Ͽ� ���� ���� ������ ����.
	// �� �ݺ��� ���� dist�迭���� ��ΰ� ����ȴ�.
	while(count<=n)
	{
		// min ���� �ʱ�ȭ.
		min = 99;
		
		for(w=1; w<=n; w++)
		{
			// �Ÿ��� min ������ �۰�, �湮������ �����ٸ�
			if(dist[w]<min && !flag[w])
			{
				min = dist[w], u = w;
			}
		}

		// �ִܰŸ��� �湮������ flag�� 1�� �ٲپ� �湮�ߴٰ� ǥ��
		flag[u] = 1;
		count++;

		
		for(w=1; w<=n; w++)
		{
			// ������ ���� ġ�ܰŸ����� ���� ���� �ִܰŸ��� �� �۰�, �湮������ �����ٸ� �ִܰŸ��� �ٲپ��ش�.
			if((dist[u]+cost[u][w]<dist[w]) && !flag[w])
			{
				dist[w] = dist[u] + cost[u][w];
			}
		}
	}
}