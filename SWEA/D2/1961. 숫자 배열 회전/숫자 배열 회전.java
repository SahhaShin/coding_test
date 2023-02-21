import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int N=sc.nextInt();
			int[][] arr = new int[N][N];
			
			//2. data input
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			//3. 90 turn
			int[][] turn90 = turn90(arr, N);

			//4. 180 turn
			int[][] turn180 = turn90(turn90, N);
			
			//5. 270 turn
			int[][] turn270 = turn90(turn180, N);
			
			
			//6. print
            System.out.println("#"+T);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(turn90[i][j]);
				}
				System.out.print(" ");
				for(int j=0;j<N;j++) {
					System.out.print(turn180[i][j]);
				}
				System.out.print(" ");
				for(int j=0;j<N;j++) {
					System.out.print(turn270[i][j]);
				}
				System.out.println();
			}
		}//test case end
	}//main end
    
    public static int[][] turn90(int[][] arr, int N) {
		//(2,0) (1,0) (0,0)
		//(2,1) (1,1) (0,1)
		//(2,2) (1,2) (0,2)
		int[][] turn_arr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				turn_arr[j][N-1-i]=arr[i][j];
			}
		}
		return turn_arr;
	}
}