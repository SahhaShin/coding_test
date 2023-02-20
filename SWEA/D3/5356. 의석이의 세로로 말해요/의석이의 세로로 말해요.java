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
			
			//2. 5줄의 문장
			//각 줄에는 길이가 1~15이하인 문자열이 주어짐
			char[][] arr = new char[5][15];
			for(int s=0;s<5;s++) {
				arr[s]=sc.next().toCharArray();
			}
			
			//3.가장 긴 문장 길이 찾기
			int max=0;
			for(int i=0;i<arr.length;i++) {
				if(max<arr[i].length) {
					max=arr[i].length;
				}
			}
			
			//3. 세로로 읽기
			//길이가 안맞으면 스킵 
			StringBuilder sb = new StringBuilder();
			
			for(int r=0;r<max;r++) {
				for(int c=0;c<arr.length;c++) {
					//길이보다 col값이 크면 row 스킵
					if((arr[c].length-1)<r) {
						continue;
					}
					if(arr[c][r]!='\u0000') {
						sb.append(arr[c][r]);
					}
				}
			}
			System.out.println("#"+T+" "+sb);
		}//tc end
	}
}