import java.util.*;

public class Solution {
	
	static int[][] arr;
	static int N;
	static int K;
	static int result;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int T=1;T<=test;T++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];
			result = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			//입력 끝
			
			rowCount();
			colCheck();
			
			System.out.println("#"+T+" "+result);
		}

	}
	
	public static boolean check(int count, int K) {
		if(count==K) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//가로 찾기
	public static void rowCount() {
		for(int i=0;i<N;i++) {
			
			int count = 0;
			
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1) {
					//하얀공간
					count++;
				}
				
				if(arr[i][j]==0 || j==N-1) {
					//검정공간 && count가 K만큼 모임 
					//다음줄로 넘어가기 전에 체크 
					if(check(count, K)) {
						result++;
					}
					count=0;
				}
			}
		}
	}
	
	
	//세로 찾기
	public static void colCheck() {
		for(int i=0;i<N;i++) {
			
			int count = 0;
			
			for(int j=0;j<N;j++) {
				if(arr[j][i]==1) {
					//하얀공간
					count++;
				}
				
				if(arr[j][i]==0 || j==N-1) {
					//검정공간 && count가 K만큼 모임 
					//다음줄로 넘어가기 전에 체크 
					if(check(count, K)) {
						result++;
					}
					count=0;
				}
			}
		}
	}
}