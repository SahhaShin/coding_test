#include<stdio.h>
#include<math.h>
//https://www.acmicpc.net/board/view/41422 도움받음
int main() {
	int doll_number = 0;
	int select = 0;//연속적으로 놓여진 인형 몇 개를 비교할래?
	long long favorit[501] = { 0, };

	long double average = 0;
	
	long double v = 0;//분산
	long double min_v = 987654321000000;

	//입력받기
	scanf("%d%d", &doll_number,&select);
	for (int i = 0; i < doll_number; i++) {
		scanf("%ld", &favorit[i]);
	}



	//k개 평균 구하고 오차 -> 오차의 합 최소 구하기
	for (int i = 0; i < doll_number; i++) {
		

		//k개의 인형이 있으면 연산 -> 1 2 3 4 5라는 인형이 있고 k가 3이라면 3번째인형에 대한 연산은 뒤에 3-1개의 인형이 더 있어야 가능
		if (doll_number - (i + 1) >= select - 1) {
			//5개 인형 중 3개 연속이면 3,4,5까지 가능
			for (int rem = 0; rem <= doll_number - select-i;rem++) {
				
				//연속된 k개의 인형의 평균을 구한다.
				for (int j = 0; j < select + rem; j++) {
					
					average += favorit[i + j];
				}
				average = average / select;

				//분산구하기(값-평균)^2
				for (int a = 0; a < select + rem; a++) {
					v += (favorit[i + a] - average) * (favorit[i + a] - average);
				}
				v = v / select;
				


				//최소분산구하기
				if (sqrt(min_v) > sqrt(v)) {
					min_v = v;

				}

				//값 초기화
				average = 0;
				v = 0;
			}
			
			

			
		}
		
		
	}
	//결과도출:구한 분산 표준편차로 변환
	printf("%.11lf",sqrt(min_v));
	
	return 0;
}