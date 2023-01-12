#include<stdio.h>


//2667번 https://www.acmicpc.net/problem/2667
//깊이확인
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
	int n = 0; //지도의크기
	
	scanf("%d", &n);


	//초기 행열 입력 받기, visited 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &(mat[i][j]));
		}
		
	}


	//첫 노드 찾기
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
	
	
	
	//오름차 순 정렬
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

	//결과 출력
	printf("%d\n", dange);
	for (int d = 0; d < dange; d++) {
		printf("%d\n",dange_mat[d]);
	}

	

	return 0;


}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////좌 측 검 사//////////////////////////////////////////////////////////////////////////////////////////////

//void left(int nowrow, int nowcol, int dange, int n) {
//	//집이 있는지 확인 및 방문한 적 있는지 확인
//	//좌측이니까 검사하고자 하는 인덱스보다 col이 -1 움직여야함
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
//////////////////////////////////////////////////////////우 측 검 사//////////////////////////////////////////////////////////////////////////////////////////////
//
//void right(int nowrow, int nowcol, int dange, int n) {
//	//집이 있는지 확인 및 방문한 적 있는지 확인
//	//우측이니까 검사하고자 하는 인덱스보다 col이 +1 움직여야함
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
//////////////////////////////////////////////////////////위 측 검 사//////////////////////////////////////////////////////////////////////////////////////////////
//
//void top(int nowrow, int nowcol, int dange, int n) {
//	//집이 있는지 확인 및 방문한 적 있는지 확인
//	//위측이니까 검사하고자 하는 인덱스보다 row이 -1 움직여야함
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
//////////////////////////////////////////////////////////아래 측 검 사//////////////////////////////////////////////////////////////////////////////////////////////
//
//void bottom(int nowrow, int nowcol, int dange,int n) {
//	//집이 있는지 확인 및 방문한 적 있는지 확인
//	//아래측이니까 검사하고자 하는 인덱스보다 row이 +1 움직여야함
//	if (mat[nowrow + 1][nowcol] == 1 && visited[nowrow + 1][nowcol] == 0 && nowrow+1<n) {
//		visited[nowrow + 1][nowcol] = 1;
//		//mat[nowrow + 1][nowcol] = dange;
//		dfs(nowrow + 1, nowcol, dange, n);
//	}
//
//
//}

//들어온 인덱스(원형) 상태 확인 및 상하좌우확인
void dfs(int nowrow, int nowcol, int dange, int n) {
	dange_mat[dange]++;
	visited[nowrow][nowcol] = 1;
	mat[nowrow][nowcol] = dange;
	
	int a;
	for (a = 0; a < 4; a++)
	{
		int n_i = nowrow + lr[a]; // 다음에 탐색할 위치의 좌표
		int n_j = nowcol + ud[a];

		if (0 <= n_i && n_i < n && 0 <= n_j && n_j < n) // 범위  확인(0 ~ n-1)
			if (mat[n_i][n_j] == 1 && visited[n_i][n_j] == 0) // 단지가 존재하고 방문하지 안았을 경우만
				dfs(n_i, n_j, dange, n); // 탐색하기(재귀)
	}
	return;

	
}
