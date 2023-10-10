import java.util.*;

public class Solution {
	
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int T=1; T<=test; T++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//입력 끝 
			
			//1. 시작과 끝을 정해준다.
			int[][] end = new int[1][2];
			end[0][0] = (N-1)-(M-1);//3
			end[0][1] = (N-1)-(M-1);//3
			int max=0;
			for(int row=0;row<=end[0][0];row++) {
				for(int col=0;col<=end[0][1];col++) {
					//row col은 시작점을 나타낸다.
					int cur_pari=0;
					for(int hit_row=row;hit_row<row+M;hit_row++) {
						for(int hit_col=col;hit_col<col+M;hit_col++) {
							cur_pari+=map[hit_row][hit_col];
						}
					}
					
					max=Math.max(max, cur_pari);
				}
			}
			System.out.println("#"+T+" "+max);
			
		}//test end

	}

}