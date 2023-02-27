
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		//모두 0으로 만드는 방법과 동일
		
		
		for(int T=1;T<t+1;T++) {
			int count=0;
			char[] memory = sc.next().toCharArray();
			int[] mem2 = new int[memory.length];
			
			//int형으로 바꾸기 
			for(int i=0;i<memory.length;i++) {
				mem2[i]=memory[i]-'0';
			}

			
			
			for(int i=0;i<mem2.length;i++) {

				if(mem2[i]==1) {
					for(int j=i;j<mem2.length;j++) {
						mem2[j]=1-mem2[j];
					}
					count++;
				}
			}
			
			System.out.println("#"+T+" "+count);
			
		}//test case end
	}
}