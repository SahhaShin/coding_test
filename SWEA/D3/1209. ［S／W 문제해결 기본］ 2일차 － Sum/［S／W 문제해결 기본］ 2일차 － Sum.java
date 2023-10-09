import java.util.*;

public class Solution {
	
	static int[][] arr;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int T=1;T<=10;T++) {
			
			arr = new int[100][100];
			result = 0;
			
			int t_num = sc.nextInt();
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//입력 끝
			row();
			col();
			left_cross();
			right_cross();
			
			System.out.println("#"+T+" "+result);
			
			
			
		}//test case end

	}
	
	public static void row() {
		for(int i=0;i<100;i++) {
			int row_sum=0;
			for(int j=0;j<100;j++) {
				row_sum+=arr[i][j];
			}
			
			result = Math.max(result, row_sum);
		}
	}
	
	public static void col() {
		for(int i=0;i<100;i++) {
			int col_sum=0;
			for(int j=0;j<100;j++) {
				col_sum+=arr[j][i];
			}
			
			result = Math.max(result, col_sum);
		}
	}
	
	public static void left_cross() {
		
		for(int i=0;i<100;i++) {
			int cross_sum=0;
			cross_sum += arr[i][i];			
			result = Math.max(result, cross_sum);
		}
	}
	
	public static void right_cross() {
		
		for(int i=0;i<100;i++) {
			int cross_sum=0;
			cross_sum += arr[i][99-i];			
			result = Math.max(result, cross_sum);
		}
	}

}