#include<stdio.h>

int main() {
	int number = 0;
	int time[1000] = { 0, };
	int temp = 0;
	int wait = 0;
	int result = 0;
	scanf("%d", &number);
	for (int i = 0; i < number; i++) {
		scanf("%d", &time[i]);
	}

	//정렬
	for (int i = 0; i < number-1; i++) {
		for (int j = 0; j < number-1-i; j++) {
			if (time[j] > time[j + 1]) {
				temp = time[j];
				time[j] = time[j + 1];
				time[j + 1] = temp;
			}
		}
	}

	//기다리는 시간 최소
	for (int i = 0; i < number; i++) {
		wait += time[i];
		result += wait;
	}
	printf("%d", result);

	return 0;
}