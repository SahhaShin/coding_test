#include<stdio.h>

int main() {
	int N = 0;//타일의 길이 2xN
	int one = 0;//2x1타일의 갯수
	int two = 0;//2x2타일의 갯수
	int one_beauty[2001] = { 0, };
	int two_beauty[2001] = { 0, };
	int max = 0;//현재 아름다움의 맥스
	
	int inter = 0; // 크기 순으로 값 교환

	int total = 0; // 결과값,전체 아름다움

	int one_turn = 0; //밑에 비교할 때 쓰는 값 2x1의 아름다움 순서
	int two_turn = 0; //밑에 비교할 때 쓰는 값 2x2의 아름다움 순서

	//N, one, two받기
	scanf("%d %d %d", &N,&one,&two);

	//one_beauty
	for (int i = 0; i < one; i++) {
		scanf("%d", &one_beauty[i]);
	}
	//one_beauty 크기별로 줄세우기
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
	//two_beauty 크기별로 줄세우기
	for (int i = 0; i < two - 1; i++) {
		for (int j = 0; j <two - 1-i; j++) {
			if (two_beauty[j] < two_beauty[j + 1]) {
				inter = two_beauty[j];
				two_beauty[j] = two_beauty[j + 1];
				two_beauty[j + 1] = inter;
			}

		}
	}



	//N이 다 채워질때까지 돌리자
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