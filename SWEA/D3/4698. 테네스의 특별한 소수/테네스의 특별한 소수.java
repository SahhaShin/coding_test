import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    // 에라토스 테네스의 체 (2 부터 시작)
	// 1~N까지의 수 중 1과 자기 자신을 제외한 2의 배수, 3의배수 ... 등을 지워나간다.
	// 만약 2,3,4...의배수를 지운다면 2,3,4...(대상)는 지우지 않는다.
	// 1과 자기자신도 지우지 않고 건너 뛴다.
	public static int[] prime_list(int N) {
		int arr[] = new int[N + 1];

		// 1. 초기화
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		// 2. 에라토스 테네스의 체
		for (int i = 2; i < N; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= N; j += i) {
				arr[j] = 0;
			}
		}

		return arr;
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		// 1. test case
		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {
			//2. 특별한 수 포함 수
			int num = sc.nextInt();
			
			//3. A 시작점
			int start = sc.nextInt();
			
			//4. B 끝지점
			int end = sc.nextInt();
			
			//5. 소수 체크
			int[] arr=prime_list(end);
			
			//6. 특별한 수 갯수 세기
			int count=0;
			for(int i=start;i<=end;i++) {
				if(arr[i]==0 || i==1) continue;
				else {
					//0이아니면 소수임 
					//특별한 수가 포함되는지 확인
					int prime_check=arr[i];
					while(prime_check>0) {
						if(prime_check%10==num) {
							//특별한 수가 맞습니다. 
							count++;
							break;
						}
						prime_check/=10;
					}//while end
				}
			}
			System.out.println("#"+T+" "+count);
		}//test case end
	}
}