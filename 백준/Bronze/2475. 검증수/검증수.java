import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[5];
		double result=0;
		
		for(int i=0;i<5;i++) {
			nums[i]=sc.nextInt();
			result+= Math.pow(nums[i], 2);
		}
		
		System.out.println((int)result%10);

	}

}