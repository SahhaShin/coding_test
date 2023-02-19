#include<stdio.h>

int main() {
	//테스트 케이스 입력
	int test = 0;
	int k = 0;
	int try_program = 0;
	scanf("%d", &test);
	int start = 0;
	int end = 0;
	
	for (int i = 0; i < test; i++) {
		scanf("%d%d", &start, &end);

		while (start != end) {
			//첫번째 시도와 마지막 시도는 무조건 1만큼 간다.
			if (try_program == 0 || start==end-1) {
				start= start+1;
				try_program++;
				k = 1;
				continue;
				
			}
			//k-1 k k+1
			else if (start+(k+1) < end) {
				start = start + (k + 1);
				try_program++;
				k = k + 1;
				continue;
			}
			else if (start + k < end) {
				start = start + k;
				try_program++;
				continue;
			}
			else if ((start + (k - 1) < end) && (k-1 != 0)) {
				start = start + (k - 1);
				try_program++;
				k = k - 1;
				continue;
			}
			else {
				break;
			}
		}
		printf("%d\n", try_program);
		try_program = 0;
		k = 0;
	}

	


	return 0;
}
