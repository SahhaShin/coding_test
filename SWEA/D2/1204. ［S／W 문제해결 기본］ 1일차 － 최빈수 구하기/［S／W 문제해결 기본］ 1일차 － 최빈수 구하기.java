import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int T=1;T<=test;T++) {
			int time = sc.nextInt();
			int[] score = new int[1000];
			for(int st=0;st<1000;st++) {
				score[st] = sc.nextInt();
			}
			
			//입력 끝
			
			
			//최빈수구하기
			
			int[] count = new int[101];
			for(int i=0;i<1000;i++) {
				count[score[i]]++;
			}
			
			//가장 많이 나온 수 도출
			int max=0;
			int result = 0;
			for(int i=0;i<101;i++) {
				if(max<=count[i]) {
					max=count[i];
					result=i;
				}
			}
			System.out.println("#"+T+" "+result);
		}//테스트케이스 end
	}
}