import java.util.Scanner;

public class Main {

	static int[][] memo;
	public static void main(String[] args) {
		// 이항계수 : 내가 주어진 조합에서 순서없이 원하는 만큼 고를 수 있는 경우의 수
		// 즉, 조합과 같다.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		memo = new int[N+1][K+1];
		
		go(N, K);
		
		System.out.println(memo[N][K]);

	}
	
	static public int go(int N, int K) {
		if(memo[N][K]>0) {
			return memo[N][K];
		}
		
		if(K==0 || K==N) return memo[N][K]=1;
		
		return memo[N][K]=go(N-1, K-1)+go(N-1, K);
		
	}

}