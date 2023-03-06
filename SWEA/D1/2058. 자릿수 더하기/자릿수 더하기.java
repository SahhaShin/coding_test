import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result=0;
        while(n>0){
            result+=n%10;
            n/=10;
        }
        System.out.println(result);
	}
}