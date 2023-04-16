import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result=0;
		
		int[] dp = new int[n+1];
		dp[1]=1;
		
		if(n>=2) {
			dp[2] = 2;
			
			for(int i=3;i<=n;i++) {
				dp[i]=(dp[i-1]+dp[i-2])%10007;
			}
		}
		else {
			result = dp[1];
		}
		
		System.out.println(dp[n]);
	}
}