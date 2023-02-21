import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 1. test case 
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 농장 크기 N
			int N=sc.nextInt();
			char[][] ground = new char[N][N];
			
			for(int i=0;i<N;i++) {
				ground[i] = sc.next().toCharArray();
			}
			
			//3. 확산 범위 -> 양쪽으로 N/2
			int range = 0;
			if(N==1) range=1;
			else range = N/2;
			
			//4. 확산 범위 만큼 가로로 더해짐
			int result=0;
			int start_row=N/2;
			int start_col=N/2;

			//+1은 현라인 검사하기 위한것이다.
			//+1없이 i==0일때만 가운데 위 아래를 동시에 돌리려고 했는데
			//가로로 퍼지는 범위가 달라서 그냥 나눴다.(가운데 5 , 위 아래 4)
			for(int i=0;i<N/2+1;i++) {
				//현, 시작라인 검사 
				if(i==0) {
					result+=ground[start_row][start_col]-'0'; //첫 땅 값 더하기
					//현라인 한줄만 검사
					//전체 중 절반만 돌리고 왼쪽 오른쪽 함께 검사
					for(int j=1;j<range+1;j++) {
						if(start_row>=0 && start_row<N && start_col-j>=0 && start_col-j<N) {
							result+=ground[start_row][start_col-j]-'0';//left
							result+=ground[start_row][start_col+j]-'0';//right
						}
					}
					range--;//3-> 2
					continue;
				}
				
				//top 검사
				result+=ground[start_row-i][start_col]-'0'; //첫 땅 값 더하기
				for(int k=1;k<range+1;k++) {
					if(start_row-i>=0 && start_row-i<N && start_col-k>=0 && start_col-k<N && start_col+k>=0 && start_col-k<N) {
						result+=ground[start_row-i][start_col-k]-'0';//left
						result+=ground[start_row-i][start_col+k]-'0';//right
					}
				}
				
				//bottom 검사
				result+=ground[start_row+i][start_col]-'0'; //첫 땅 값 더하기
				for(int k=1;k<range+1;k++) {
					if(start_row+i>=0 && start_row+i<N && start_col-k>=0 && start_col-k<N && start_col+k>=0 && start_col-k<N) {
						result+=ground[start_row+i][start_col-k]-'0';//left
						result+=ground[start_row+i][start_col+k]-'0';//right
					}
				}
				range--;//3-> 1

			}
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
}