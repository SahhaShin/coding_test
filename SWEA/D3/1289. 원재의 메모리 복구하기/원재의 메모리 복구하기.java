
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		// 1289
		Scanner sc = new Scanner(System.in);
		//1. TEST CASE
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 메모리 원래값
			char[] memory=sc.next().toCharArray();
			
			int count=0;
		
			
			for(int i=0;i<memory.length;i++) {
				if((memory[i]-'0')==1) {
					count++;
					for(int j=i;j<memory.length;j++) {
						memory[j]=(char) ((1- (memory[j]-'0'))+48);
					}
					if(check(memory)==1) break;
				}
			}
			
			System.out.println("#"+T+" "+count);
		}
	}
    public static int check(char[] arr) {
		int flag=1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!='0') flag=0;
		}
		
		return flag;
	}
}