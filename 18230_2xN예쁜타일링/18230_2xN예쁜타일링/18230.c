#include<stdio.h>

int main() {
	int N = 0;//Ÿ���� ���� 2xN
	int one = 0;//2x1Ÿ���� ����
	int two = 0;//2x2Ÿ���� ����
	int one_beauty[2001] = { 0, };
	int two_beauty[2001] = { 0, };
	int max = 0;//���� �Ƹ��ٿ��� �ƽ�
	
	int inter = 0; // ũ�� ������ �� ��ȯ

	int total = 0; // �����,��ü �Ƹ��ٿ�

	int one_turn = 0; //�ؿ� ���� �� ���� �� 2x1�� �Ƹ��ٿ� ����
	int two_turn = 0; //�ؿ� ���� �� ���� �� 2x2�� �Ƹ��ٿ� ����

	//N, one, two�ޱ�
	scanf("%d %d %d", &N,&one,&two);

	//one_beauty
	for (int i = 0; i < one; i++) {
		scanf("%d", &one_beauty[i]);
	}
	//one_beauty ũ�⺰�� �ټ����
	for (int i = 0; i < one-1; i++) {
		for (int j = 0; j < one-1-i; j++) {
			if (one_beauty[j] < one_beauty[j + 1]) {
				inter = one_beauty[j];
				one_beauty[j] = one_beauty[j + 1];
				one_beauty[j + 1] = inter;
			}

		}
	}
	//two_beauty
	for (int i = 0; i < two; i++) {
		scanf("%d", &two_beauty[i]);
	}
	//two_beauty ũ�⺰�� �ټ����
	for (int i = 0; i < two - 1; i++) {
		for (int j = 0; j <two - 1-i; j++) {
			if (two_beauty[j] < two_beauty[j + 1]) {
				inter = two_beauty[j];
				two_beauty[j] = two_beauty[j + 1];
				two_beauty[j + 1] = inter;
			}

		}
	}



	//N�� �� ä���������� ������
	while (N>0) {
		
		if (one_beauty[one_turn] >= two_beauty[two_turn] && one_turn < one) {
			
			total = total + one_beauty[one_turn];
			one_beauty[one_turn] = 0;
			one_turn++;
			N--;
		}
		else if (one_beauty[one_turn] + one_beauty[one_turn + 1] >= two_beauty[two_turn] && one_turn < one-1 && N >= 2) {
			
			total = total + one_beauty[one_turn] + one_beauty[one_turn + 1];
			one_beauty[one_turn] = 0;
			one_beauty[one_turn+1] = 0;
			one_turn= one_turn+2;
			N=N-2;

		}
		else if (one_beauty[one_turn] < two_beauty[two_turn] && two_turn < two&&N>=2) {
			
			total = total + two_beauty[two_turn];
			two_beauty[two_turn] = 0;
			two_turn++;
			N = N - 2;
		}
		else {
			
			break;
		}


	}
	printf("%d", total);
	return 0;
}