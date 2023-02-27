import java.util.Arrays;
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int T=1;T<t+1;T++) {
			int count = sc.nextInt();
			
			int[] arr = new int[count];
			for(int i=0;i<count;i++) {
				arr[i]=sc.nextInt();
			}
			
			Arrays.sort(arr);
			
            System.out.print("#"+T+" ");
			for(int i=0;i<count;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
		}
	}
}