import java.util.*;
import java.io.*;

class Solution
{
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int result=1;
			//2.배열
			int[][] arr = new int[9][9];
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			if(!row_check(arr)) result=0;
			if(!col_check(arr)) result=0;
			if(!mini_check (arr)) result=0;
			
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
    
    static public boolean row_check (int[][] arr) {
		boolean result=true;
		
		for(int i=0;i<arr.length;i++) {
			int[] count = new int[10];
			for(int j=0;j<arr.length;j++) {
				if(count[arr[i][j]]==0) {
					count[arr[i][j]]++;
				}
				else {
					result=false;
					break;
				}		
			}
		}
		return result;	
	}
	
	static public boolean col_check (int[][] arr) {
		boolean result=true;
		
		for(int i=0;i<arr.length;i++) {
			int[] count = new int[10];
			for(int j=0;j<arr.length;j++) {
				if(count[arr[j][i]]==0) {
					count[arr[j][i]]++;
				}
				else {
					result=false;
					break;
				}		
			}
		}
		return result;	
	}
	
	static public boolean mini_check (int[][] arr) {
		boolean result=true;
		int row=0;//start
		int col=0;//start 
		//전체 9번
		for(int i=0;i<9;i++) {
			int[] count = new int[10];
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					if(count[arr[row+j][col+k]]==0)count[arr[row][col]]++;
                    else {
						result=false;
						break;
					}	
				}
			}
			if(col!=6) col+=3;
			else {row+=3; col=0;}
		}
		
		return result;	
	}
}