#include <stdio.h>
#include<stdlib.h>

//4시 30분 시작
//https://www.acmicpc.net/problem/1966



int main() {
	
	//number는 테스트 케이스이다.
	int number = 0;
	scanf("%d",&number);
	int document_count = 0; //문서의 갯수
	int document_question = 0; // 큐 몇번째에 있는지 궁금한 문서

	//테스트 케이스 만큼 for문이 돌아간다.
	for (int i = 0; i < number; i++) {


		//문서의 갯수와 큐 몇번째에 있는지 궁금한 문서를 받는다.
		scanf("%d %d", &document_count, &document_question);

		int* primary = (int*)malloc(sizeof(int) * document_count);
		


		//일단 문서 갯수만큼 중요도를 받는다.
		for (int j = 0; j < document_count; j++) {
			scanf("%d", primary + j);


		}

		int inter = 0;

		//문서 위치 찾자
		int position = document_question;

		//문서들의 중요도를 따져 재배치(0번째 문서와 모든 문서를 비교하여 0번째 문서보다 큰 중요도가 있다면 맨뒤로)
		//우선순위 값이 클수록 우선순위가 먼저임
		for (int k = 0; k < document_count; k++) {
			
			for (int k_2 = k + 1; k_2 < document_count; k_2++) {
				

				//비교대상보다 큰 우선순위가 하나라도 발견되면 맨뒤로 이동해야함
				if (*(primary + k) < *(primary + k_2)) {

					inter = *(primary + k);
					//하나씩 앞당기며 비교대상을 맨뒤로 보낸다.
					for (int k_3 = k; k_3 < document_count - 1; k_3++) {
						*(primary + k_3) = *(primary + k_3 + 1);
						if (k_3 + 1 == position) {
							position = k_3;

						}
					}
					*(primary + document_count - 1) = inter;

					if (position == 0) {
						position = document_count - 1;


					}


					k_2 = k;//맨뒤로 보내고 다시 바로 옆에것과 비교부터 시작

				}


			}
		}
		
		printf("%d\n", position + 1);
	
		free(primary);
		





		
	}


	
}


