#include<stdio.h>
#include<stdlib.h>
int main() {
	//���� ���� �Է�
	int ice_num = 0;
	int pang_position = 0; //��� ��ġ
	int left_min_power=1000000001;//��� ���� ���� ���� �Ŀ�
	int right_min_power = 1000000001;//��� ���� ���� ���� �Ŀ�
	scanf("%d", &ice_num);
	int* power = (int*)malloc(sizeof(int)*ice_num);
	for (int i = 0; i < ice_num; i++) {
		//���߸��µ� ��� ��
		scanf("%d", power+i);
	}

	//-1��ġ, �����ġ �ľ�
	for (int i = 0; i < ice_num; i++) {
		if (*(power + i) == -1)
			pang_position = i;
	}

	//��� ��ġ ���� ���� Ž��
	for (int i = 0; i < pang_position; i++) {
		if (left_min_power > * (power + i))
			left_min_power = *(power + i);
	}

	//��� ��ġ ���� ������ Ž��
	for (int i = pang_position+1; i < ice_num; i++) {
		if (right_min_power > * (power + i))
			right_min_power = *(power + i);
	}

	//���� ���� �� ����
	printf("%d", left_min_power + right_min_power);

	return 0;
}