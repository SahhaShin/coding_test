//2562번 최댓값
//#include<stdio.h>
//int main() {
//	int number = 0;
//	int max = 0;
//	int rank = 0;
//	for (int i = 0; i < 9 ; i++) {
//		scanf("%d",&number);
//		if (number > max) {
//			max = number;
//			rank = i + 1;
//		}
//			
//	}
//	printf("%d\n%d", max, rank);
//	return 0;
//}


//2577번 숫자의 개수
//#include<stdio.h>
//int main() {
//	int a, b, c = 0;
//	int result = 0;
//	int count[10] = { 0, };
//	scanf("%d", &a);
//	scanf("%d", &b);
//	scanf("%d", &c);
//	result = a * b * c;
//	while (result>0) {
//		count[result % 10]++ ;
//		result /= 10;
//	}
//	for (int i = 0; i < 10; i++) {
//		printf("%d\n", count[i]);
//	}
//	return 0;
//}

//3052번 나머지
//#include<stdio.h>
//int main() {
//	int number = 0;
//	int result[43] = { 0, };
//	int total = 0;
//	for (int i = 0; i < 10; i++) {
//		scanf("%d", &number);
//		if (result[number % 42] == 0) {
//			result[number % 42]++;
//		}
//	}
//	for (int i = 0; i < 43; i++) {
//		if (result[i] == 1) {
//			total++;
//		}
//		
//	}
//	printf("%d", total);
//	return 0;
//}

//1546번_평균
//#include<stdio.h>
//int main() {
//	int number = 0;
//	float score[1000] = { 0.0, };
//	float avg = 0.0;
//	int max = 0;
//	scanf("%d", &number);
//	for (int i = 0; i < number; i++) {
//		scanf("%f", &score[i]);
//		if (score[i] > max) {
//			max = score[i];
//		}
//	}
//	for (int i = 0; i < number; i++) {
//		
//		avg += score[i] / max * 100;
//	}
//	avg = avg / (float)number;
//	printf("%f", avg);
//	return 0;
//}

//8958번_OX퀴즈 -> 블로그
//#include<stdio.h>
//#include<string.h>
//int main() {
//	int number = 0;
//	char ox[80] = { 'X', };
//	int score = 1;
//	int total = 0;
//	scanf("%d", &number);
//	for (int i = 0; i < number; i++) {
//		scanf("%s", &ox);
//		for (int i = 0; i < strlen(ox); i++) {
//			
//			if (ox[i] == 'O') {
//				total += score;
//				score++;
//			}
//			else {
//				score = 1;
//			}
//		}
//		printf("%d\n", total);
//		score = 1;
//		total = 0;
//
//	}
//	
//	return 0;
//}

//4344번_평균은 넘겠지 -> 블로그 % 문제
//#include<stdio.h>
//int main() {
//	int number = 0;
//	int row_number = 0;
//	float score[1000] = { 0.0, };
//	
//	float avg = 0.0;
//	int over = 0;
//	float result = 0.0;
//	scanf("%d", &number);
//	for (int i = 0; i < number; i++) {
//		scanf("%d", &row_number);
//		for (int j = 0; j < row_number; j++) {
//			scanf("%f", &score[j]);
//			avg += score[j];
//		}
//		avg /= row_number;
//		for (int k = 0; k < row_number; k++) {
//			if (avg < score[k]) {
//				over++;
//			}
//		}
//		result = ((float)over/(float)row_number)*100;
//		printf("%.3f%%\n",result);
//		result = 0.0;
//		over = 0;
//		avg = 0.0;
//		
//	}
//	return 0;
//}

