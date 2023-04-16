import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//수열의 크기
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);//모두 자기 자신의 최장길이는 1이다.
		int max=1;
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
			if(max<dp[i])max=dp[i];
		}
		
		System.out.println(max);
	}
}