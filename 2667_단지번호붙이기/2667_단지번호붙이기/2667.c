#include<stdio.h>


//2667�� https://www.acmicpc.net/problem/2667
//����Ȯ��
/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/


void dfs(int nowrow, int nowcol, int dange, int n);
//void bottom(int nowrow, int nowcol, int dange, int n);
//void top(int nowrow, int nowcol, int dange, int n);
//void right(int nowrow, int nowcol, int dange, int n);
//void left(int nowrow, int nowcol, int dange, int n);
int lr[4] = { -1, 0, 1, 0 }, ud[4] = { 0, 1, 0, -1 };



int visited[25][25] = { 0, };
int mat[25][25];
int dange_mat[1000] = { 0, };
int dange = 0;
int main() {
	int n = 0; //������ũ��
	
	scanf("%d", &n);


	//�ʱ� �࿭ �Է� �ޱ�, visited �ʱ�ȭ
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &(mat[i][j]));
		}
		
	}


	//ù ��� ã��
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (mat[i][j] == 1 && visited[i][j] == 0) {	
				
				dfs(i, j, dange, n);
				dange = dange + 1;
				

			}
			else{
				continue;
			}
		}
		

	}
	
	
	
	//������ �� ����
	int trans = 0;
	for (int row = 1; row < dange-1; row++) {
		for (int col = row+1; col < dange-1-row; col++) {
			if (dange_mat[col]> dange_mat[col+1]) {
				trans = dange_mat[col];
				dange_mat[col] = dange_mat[col+1];
				dange_mat[col+1] = trans;
			}
		}
		
	}

	//��� ���
	printf("%d\n", dange);
	for (int d = 0; d < dange; d++) {
		printf("%d\n",dange_mat[d]);
	}

	

	return 0;


}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////�� �� �� ��//////////////////////////////////////////////////////////////////////////////////////////////

//void left(int nowrow, int nowcol, int dange, int n) {
//	//���� �ִ��� Ȯ�� �� �湮�� �� �ִ��� Ȯ��
//	//�����̴ϱ� �˻��ϰ��� �ϴ� �ε������� col�� -1 ����������
//	if (mat[nowrow][nowcol-1] == 1 && visited[nowrow][nowcol-1] == 0 && nowcol>=0) {
//		visited[nowrow][nowcol-1] = 1;
//		//mat[nowrow][nowcol-1] = dange;
//		dfs(nowrow, nowcol-1, dange, n);
//	}
//
//}
//
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////�� �� �� ��//////////////////////////////////////////////////////////////////////////////////////////////
//
//void right(int nowrow, int nowcol, int dange, int n) {
//	//���� �ִ��� Ȯ�� �� �湮�� �� �ִ��� Ȯ��
//	//�����̴ϱ� �˻��ϰ��� �ϴ� �ε������� col�� +1 ����������
//	if (mat[nowrow][nowcol + 1] == 1 && visited[nowrow][nowcol + 1] == 0 && nowrow<n) {
//		visited[nowrow][nowcol + 1] = 1;
//		//mat[nowrow][nowcol + 1] = dange;
//		dfs(nowrow, nowcol+1, dange, n);
//	}
//
//
//}
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////�� �� �� ��//////////////////////////////////////////////////////////////////////////////////////////////
//
//void top(int nowrow, int nowcol, int dange, int n) {
//	//���� �ִ��� Ȯ�� �� �湮�� �� �ִ��� Ȯ��
//	//�����̴ϱ� �˻��ϰ��� �ϴ� �ε������� row�� -1 ����������
//	if (mat[nowrow-1][nowcol] == 1 && visited[nowrow-1][nowcol] == 0 && nowrow>=0) {
//		visited[nowrow-1][nowcol] = 1;
//		//mat[nowrow-1][nowcol] = dange;
//
//		dfs(nowrow - 1, nowcol, dange, n);
//
//	}
//
//
//}
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////�Ʒ� �� �� ��//////////////////////////////////////////////////////////////////////////////////////////////
//
//void bottom(int nowrow, int nowcol, int dange,int n) {
//	//���� �ִ��� Ȯ�� �� �湮�� �� �ִ��� Ȯ��
//	//�Ʒ����̴ϱ� �˻��ϰ��� �ϴ� �ε������� row�� +1 ����������
//	if (mat[nowrow + 1][nowcol] == 1 && visited[nowrow + 1][nowcol] == 0 && nowrow+1<n) {
//		visited[nowrow + 1][nowcol] = 1;
//		//mat[nowrow + 1][nowcol] = dange;
//		dfs(nowrow + 1, nowcol, dange, n);
//	}
//
//
//}

//���� �ε���(����) ���� Ȯ�� �� �����¿�Ȯ��
void dfs(int nowrow, int nowcol, int dange, int n) {
	dange_mat[dange]++;
	visited[nowrow][nowcol] = 1;
	mat[nowrow][nowcol] = dange;
	
	int a;
	for (a = 0; a < 4; a++)
	{
		int n_i = nowrow + lr[a]; // ������ Ž���� ��ġ�� ��ǥ
		int n_j = nowcol + ud[a];

		if (0 <= n_i && n_i < n && 0 <= n_j && n_j < n) // ����  Ȯ��(0 ~ n-1)
			if (mat[n_i][n_j] == 1 && visited[n_i][n_j] == 0) // ������ �����ϰ� �湮���� �Ⱦ��� ��츸
				dfs(n_i, n_j, dange, n); // Ž���ϱ�(���)
	}
	return;

	
}
