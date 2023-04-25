import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 단원개수
		int T = sc.nextInt();// 공부할 수 있는 총 시간

		int[] time = new int[N + 1];
		int[] score = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			score[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][T+1];
		for(int unit=1;unit<=N;unit++) {//선택된 단원
			for(int t=1;t<=T;t++) {//고려하는 공부 시간
				if(time[unit]<=t) {
					dp[unit][t]=Math.max(dp[unit-1][t], dp[unit-1][t-time[unit]]+score[unit]);
				}
				else {
					dp[unit][t]=dp[unit-1][t];
				}
			}
		}
		
		System.out.println(dp[N][T]);

	}

}