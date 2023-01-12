#include<stdio.h>

int dfs(int row, int col, int x_big, int y_big);
int up_down[4] = { 1,-1,0,0 };
int left_right[4] = { 0,0,-1,1 };
//�־��� ū �簢��
int square[101][101] = { 0, };
//�簢�� ����
int count[101] = { 0, };

//���� ����
int area = 0;

int main() {
	int x_big = 0;
	int y_big = 0;
	int number = 0;

	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;

	//�������� ����
	int temp = 0;

	scanf("%d%d%d" ,& y_big,&x_big,&number);

	//���� 0 -> 1
	for (int i = 0; i < number; i++) {
		scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
		//��
		for (int row = y1; row < y2; row++) {
			//��
			for (int col = x1; col < x2; col++) {
				square[row][col] = 1;
			}

		}
	}

	
	

	//nxm�� �簢�� �� ���� ���� 0 ���

	//��
	for (int row = 0; row < y_big; row++) {
		//��
		for (int col = 0; col < x_big; col++) {
			if (square[row][col] == 0 && square[row][col] != 2) {
				dfs(row, col, x_big, y_big);
				area++;
				

			}
			
		}
	
	}

	//�������(��������)
	for (int i = 0; i < area-1; i++) {
		for (int j = 0; j < area-i-1; j++) {
			if (count[j] > count[j + 1]) {
				temp = count[j];
				count[j] = count[j + 1];
				count[j + 1] = temp;
			}

		}
	}
	//������ ����
	printf("%d\n", area);

	//ũ�� ���
	for (int i = 0; i < area; i++) {
		printf("%d ", count[i]);
	}

	
	return 0;
}

int dfs(int row, int col, int x_big, int y_big) {

	if (square[row][col] == 0 && square[row][col] != 2) {
		square[row][col] = 2;
		count[area]++;
	}

	for (int i = 0; i < 4; i++) {
		if ((col + left_right[i]) < x_big && (row + up_down[i]) < y_big && (col + left_right[i] >= 0) && (row + up_down[i] >= 0)) {
			if (square[row + up_down[i]][col + left_right[i]] == 0) {
				count[area]++;
				square[row + up_down[i]][col + left_right[i]] = 2;
				dfs(row + up_down[i], col + left_right[i], x_big, y_big);
			}
			
		}
		
			
	}
	
	return 0;
	
	
}