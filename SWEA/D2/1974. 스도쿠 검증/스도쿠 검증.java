import java.util.Scanner;

public class Solution {
	static int[][] arr=new int[9][9];;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 배열
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			//3. 검사
			//가로
			int result=1;
			if(!row_check()) result=0;
			
			//세로
			if(!col_check()) result=0;
			
			//3x3
			if(!three_check()) result=0;
			
			System.out.println("#"+T+" "+result);
			
		}//test case end

	}
	
	static public boolean row_check() {
		for(int i=0;i<9;i++) {
			int[] count = new int[10];
			for(int j=0;j<9;j++) {
				if(count[arr[i][j]]==0)count[arr[i][j]]++;
				else return false;
			}
		}
		return true;
	}
	
	static public boolean col_check() {
		for(int i=0;i<9;i++) {
			int[] count = new int[10];
			for(int j=0;j<9;j++) {
				if(count[arr[j][i]]==0)count[arr[j][i]]++;
				else return false;
			}
		}
		return true;
	}
	
	static public boolean three_check() {
		int row=0;
		int col=0;
		for(int i=0;i<9;i++) {
			int[] count = new int[10];
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					if(count[arr[j+row][k+col]]==0)count[arr[j+row][k+col]]++;
                    else return false;
				}
			}
			col+=3;
			if(col>8) {
				//3x3밑으로 이동 
				col=0;
				row+=3;
			}
		}
		return true;
	}

}