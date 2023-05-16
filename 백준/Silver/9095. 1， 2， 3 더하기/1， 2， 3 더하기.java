import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int num = sc.nextInt();
			
			int[] dp = new int[num+1];
			if(num>=1)dp[1]=1;
			if(num>=2)dp[2]=2;
			if(num>=3) 
				dp[3]=4;
			if(num>=4) {				
				for(int i=4;i<=num;i++) {
					dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
				}
			}
			
			System.out.println(dp[num]);
		}//test case end

	}

}