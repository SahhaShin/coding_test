#include<stdio.h>
int same_diff(int number1, int number2, int number3) {
	if ((number1 - number2) == (number2 - number3)) {
		return 1;
	}
	return 0;
}
int main() {
	int number = 0;
	int result = 0;
	scanf("%d", &number);
	int i = 1;
	while (i<=number) {
		if (i<100) {
			result++;
		}
		else if (i < 1000) {
			if (same_diff(i % 10, (i % 100) / 10, i / 100) == 1)
				result++;
		}
		i++;
	}
	printf("%d", result);
	return 0;
}