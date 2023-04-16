import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[3] = 1;
		if(N>=5) dp[5]=1;
		
		for(int i=6;i<=N;i++) {
			if(dp[i-3]!=0 && dp[i-5]==0) dp[i] = dp[i-3]+1;
			if(dp[i-3]==0 && dp[i-5]!=0) dp[i] = dp[i-5]+1;
			if(dp[i-3]!=0 && dp[i-5]!=0) dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		if(dp[N]==0) dp[N]=-1;
		System.out.println(dp[N]);
	}
}