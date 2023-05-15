import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		dp[1]=0;//1을 만드는 과정이기 때문에 1을 1로 만드는 최소 횟수는 0이다.
		
		for(int t=2;t<=N;t++) {
			//-1을 하려고 할 때
			dp[t]=dp[t-1]+1;//작업 1회 추가
			
			// 2로 나누어 떨어지면 2로 나눈다.
			if(t%2==0) dp[t]=Math.min(dp[t/2]+1, dp[t]);
			
			//3으로 나누어 떨어지면 3으로 나눈다.
			if(t%3==0) dp[t]=Math.min(dp[t/3]+1, dp[t]);

		}	
		
		System.out.println(dp[N]);
		

	}

}