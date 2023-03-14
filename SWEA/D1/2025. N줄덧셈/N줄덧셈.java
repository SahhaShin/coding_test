
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result=0;
        for(int i=1;i<=num;i++){
        	result+=i;
        }
        System.out.println(result);
	}
}