import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        for(int i=0;i<num;i++){
        	System.out.print("#");
        }
        System.out.println();
	}
}