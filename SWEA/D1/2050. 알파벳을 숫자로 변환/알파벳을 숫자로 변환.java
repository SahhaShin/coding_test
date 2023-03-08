import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
        
        for(int i=0;i<arr.length;i++){
        	System.out.print((arr[i]-'0'-16)+" ");
        }
        System.out.println();
	}
}