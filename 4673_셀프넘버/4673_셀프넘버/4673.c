//4673번 셀프넘버 -> 블로그
#include<stdio.h>

int main() {
	int mat[10001] = { 0, };
	int number = 1;
	while (number <= 9972) {
		if (number < 10) {
			 mat[number + number]++;
		}
		else if (number < 100) {
			mat[number + (number / 10) + (number % 10)]++;
		}
		else if (number < 1000) {
			mat[number + (number % 10) + ((number / 10) % 10) + (number / 100)]++;
		}
		else if (number < 10000) {
			mat[number + (number % 10) + ((number / 10) % 10) + ((number / 100) % 10) + (number / 1000)]++;
		}
		
		number++;
	}

	for (int i = 1; i < 10001; i++) {
		if (mat[i] == 0) {
			printf("%d\n", i);
		}
		
	}
	return 0;
}