import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        for(int T=1;T<t+1;T++){
            int p = sc.nextInt();
      		int q = sc.nextInt();
        
        	System.out.println("#"+T+" "+(p/q)+" "+(p%q));
        }
        
	}
}