#include<stdio.h>

int main() {
	int people=0;
	int chance = 0;
	int distance = 0;
	int arr[101][101] = { 0, };
	int result[101] = { 0, };
	int times = 0;
	int pay_people = 0;

	scanf("%d %d %d", &people, &chance, &distance);

	for (int i = 0; i < people; i++) {
		for (int j = 0; j < chance; j++) {
			scanf("%d", &arr[i][j]);

		}
	}

	for (int i = 0; i < chance; i++) {
		for (int j = 0; j < people; j++) {
			result[j] += arr[j][i];
			if (result[j] >= distance) {
				times = i + 1;
				pay_people = j + 1;

				i = chance;
				break;
			}
				
		}
	}
	printf("%d %d", pay_people,times);


	

	return 0;
}