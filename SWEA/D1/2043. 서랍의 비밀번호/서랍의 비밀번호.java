
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int k = sc.nextInt();    
        System.out.println(p-k+1);
	}
}