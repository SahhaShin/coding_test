import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	
	/** memoization(N의 M승)
	 * 각 인덱스는 지수(승)를 나타낸다.
	 * 각 인덱스의 값은 밑의 지수(인덱스)승의 결과이다.
	 * */
	static int[] memo;
	
	//N의 M승을 구하는 재귀함수
	static public int pow(int N, int M) {
		//만약 0승이면 값은 무조건 1이 나온다.
		if(M==0) {
			memo[0]=1;
			return 1;
		}
		
		//M이 홀수이면 2^5 -> 2^2 * 2^2 * 2이런식으로 N을 한 번 더 곱해줘야하기 때문에 케이스를 나눈다.
		if(M%2==0) {
			//한번도 연산된적 없으면 계산값 저장 
			if(memo[M/2]==0) {
				memo[M/2]=pow(N, M/2);
			}
			return pow(N, M/2)*pow(N, M/2);
		}
		else {
			if(memo[M/2]==0) {
				memo[M/2]=pow(N, M/2);
			}
			return pow(N, M/2)*pow(N, M/2)*N;
		}
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T=1;T<=10;T++) {
			int test = sc.nextInt();
			int num = sc.nextInt();
			int times = sc.nextInt();
			memo=new int[times+1];
			
			int result = pow(num, times);
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
}