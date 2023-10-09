import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<=10;T++) {
			int dump = sc.nextInt();
			int[] box_height = new int[100];
			for(int i=0;i<100;i++) {
				box_height[i]=sc.nextInt();
			}
			
			//입력 끝
			
			for(int i=0;i<dump;i++) {
				Arrays.sort(box_height);
				if(box_height[99]-box_height[0]!=0) {
					box_height[99]--;
					box_height[0]++;
				}else {
					break;
				}
			}
			Arrays.sort(box_height);
			System.out.println("#"+T+" "+(box_height[99]-box_height[0]));
			
		}
	}
}