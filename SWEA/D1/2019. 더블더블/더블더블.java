import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int target=0;
        for(int i=0;i<=num;i++){
        	if(target==0) target=1;
            else target*=2;
            
            System.out.print(target+" ");
        }
	}
}