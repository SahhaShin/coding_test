#include<stdio.h>
#include<math.h>
//https://www.acmicpc.net/board/view/41422
//https://www.acmicpc.net/board/view/49811
int main() {
	int doll_number = 0;
	int select = 0;//���������� ������ ���� �� ���� ���ҷ�?
	long double favorit[501] = { 0, };

	long double average = 0;
	
	long double v = 0;//�л�
	long double min_v = 987654321000000;

	//�Է¹ޱ�
	scanf("%d%d", &doll_number,&select);
	for (int i = 0; i < doll_number; i++) {
		scanf("%LF", &favorit[i]);
	}



	//k�� ��� ���ϰ� ���� -> ������ �� �ּ� ���ϱ�
	for (int i = 0; i < doll_number; i++) {
		

		//k���� ������ ������ ���� -> 1 2 3 4 5��� ������ �ְ� k�� 3�̶�� 3��°������ ���� ������ �ڿ� 3-1���� ������ �� �־�� ����
		if (doll_number - (i + 1) >= select - 1) {
			//5�� ���� �� 3�� �����̸� 3,4,5���� ����
			for (int rem = 0; rem <= doll_number - select-i;rem++) {
				
				//���ӵ� k���� ������ ����� ���Ѵ�.
				for (int j = 0; j < select + rem; j++) {
					
					average = average+favorit[i + j];
					//printf("\ni=%d, j=%d, sum = %LF\n", i,j,average);
				}
				average = average / ((long double)select + (long double)rem);
				//printf("\naverage = %LF\n", average);
				//�л걸�ϱ�(��-���)^2
				for (int a = 0; a < select + rem; a++) {
					v =v+ (favorit[i + a] - average) * (favorit[i + a] - average);
					//printf("\nv_sum = %lf\n", v);
				}
				v = v / ((long double)select + (long double)rem);
				//printf("\nv = %LF\n", v);
				


				//�ּҺл걸�ϱ�
				if (sqrt(min_v) > sqrt(v)) {
					min_v = v;

				}

				//�� �ʱ�ȭ
				average = 0;
				v = 0;
			}
			
			

			
		}
		
		
	}
	//�������:���� �л� ǥ�������� ��ȯ
	printf("%.11LF",sqrt(min_v));
	
	return 0;
}