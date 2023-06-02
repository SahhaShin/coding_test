import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//재료의 개수
		int M = sc.nextInt();//갑옷을 만드는 데 필요한 수
		
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		long result = 0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++) {
				long target = nums[i]+nums[j];
				if(target==M) {
					result++;
					break;
				}
				else if(target>M) break;
			}
		}
		System.out.println(result);
	}
}