import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int result=0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. row col
			int N=sc.nextInt();
			int M=sc.nextInt();
			char[][] arr = new char[N][M];
			
			//3. data input
			for(int i=0;i<N;i++) {
				arr[i]=sc.next().toCharArray();
			}
			
			//4. 파란줄 갯수(i) 정하기
			int min=Integer.MAX_VALUE;
			int total=0;
			for(int i=0;i<N-2;i++) {
				//4.파란줄 row(j) 정하기 1~n-2
				for(int j=1;j<N-1-i;j++) {
					//4. 전체 다시 샐칙할 갯수 구하기
					total+=count_white(arr, 0, j-1, M);
					total+=count_blue(arr, j, j+i, M);
					total+=count_red(arr, j+i+1, N-1, M);
					if(min>total) min=total;
					total=0;
				}
			}
			System.out.println("#"+T+" "+min);
			result=0;
			
		}//test case end
	}
    public static int count_white(char[][] arr, int start_row,int end_row,int M) {
		//row = white 줄의 끝
		int w_count=0;
		for(int i=start_row;i<=end_row;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]=='W') {
					w_count++;
				}
			}
		}
		
		//색칠필요갯수는 M*몇줄-w_count개
		return M*(end_row-start_row+1)-w_count;
	}
	
	public static int count_blue(char[][] arr, int start_row,int end_row,int M) {
		//row = white 줄의 끝
		int b_count=0;
		for(int i=start_row;i<=end_row;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]=='B') {
					b_count++;
				}
			}
		}
		
		//색칠필요갯수는 M*몇줄-w_count개
		return M*(end_row-start_row+1)-b_count;
	}
	
	public static int count_red(char[][] arr, int start_row,int end_row,int M) {
		//row = white 줄의 끝
		int r_count=0;
		for(int i=start_row;i<=end_row;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]=='R') {
					r_count++;
				}
			}
		}
		
		//색칠필요갯수는 M*몇줄-w_count개
		return M*(end_row-start_row+1)-r_count;
	}
}