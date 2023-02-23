import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//test case
		int t = sc.nextInt();
		
		//20까지의 숫자로 합이 커봤자 40
		
		for(int T=1;T<t+1;T++) {
			int[] count = new int[41];
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//카운팅
			int max=0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					count[i+j]++;
					
					if(max<count[i+j]) {
						max=count[i+j];
					}
				}
			}
			
			//결과
			System.out.print("#"+T+" ");
			for(int i=0;i<41;i++) {
				if(count[i]==max) {
					System.out.print(i+" ");
				}
			}
			System.out.println();

		}
	}
}