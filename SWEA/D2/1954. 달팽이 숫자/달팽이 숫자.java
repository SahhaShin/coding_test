import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int row;
	static int col;
	static int direc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int T=1;T<=test;T++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			
			row=0;
			col=0;
			direc=0;//우 하 좌 상 
			
			for(int i=1;i<=N*N;i++) {
				map[row][col]=i;
				
				if(direc==0) col++;
				else if(direc==1)row++;
				else if(direc==2)col--;
				else row--;
				
				change();//방향 변화가 필요한지 체크하고 변경해줌 
			}
			
			
			System.out.println("#"+T);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}//test end

	}
	
	public static void change() {
		if(direc==0 && (col==N-1 || (col+1<N&&map[row][col+1]!=0) )) {
			direc=1;
		}
		
		else if(direc==1 && (row==N-1 || (row+1<N&&map[row+1][col]!=0))) {
			direc=2;
		}
		
		else if(direc==2 && (col==0 || (col-1>=0&&map[row][col-1]!=0))) {
			direc=3;
		}
		
		else if(direc==3 && (row==0 || (row-1>=0&&map[row-1][col]!=0))) {
			direc=0;
		}
	}

}