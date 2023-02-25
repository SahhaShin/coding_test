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
			//2. 제목 갯수
			int count=sc.nextInt();
			
			//3. 제목 입력
			int[] alpa = new int[26];
			for(int i=0;i<count;i++) {
				String title = sc.next();
				alpa[title.charAt(0)-65]++;//A 아스키코드 65
			}
			
			//4. A->B->C 가 순차적으로 있는지 확인
			int result=0;
			for(int i=0;i<26;i++) {
				if(alpa[i]>0) {
					result++;
				}
				else {
					break;
				}
			}
			
			//5. 결과출력
			System.out.println("#"+T+" "+result);
		}//test case end
	}
}