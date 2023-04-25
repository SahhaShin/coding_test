import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//최대 공부시간
		int K = sc.nextInt();//과목수
		
		int[] important = new int[K+1];
		int[] time = new int[K+1];
		
		for(int i=1;i<=K;i++) {
			important[i] = sc.nextInt();
			time[i]=sc.nextInt();
		}
		
		int[][] result = new int[K+1][N+1];
		for(int i=1;i<=K;i++) {//과목
			for(int t=1;t<=N;t++) {//시간
				//배낭 고려 가능
				if(time[i]<=t) {
					result[i][t]=Math.max(result[i-1][t], result[i-1][t-time[i]]+important[i]);
				}else {
					result[i][t]=result[i-1][t];
				}
			}		
		}

		System.out.println(result[K][N]);
	}

}