import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] store = new int[n];
		
		for(int i=0;i<n;i++) {
			store[i]=sc.nextInt();
		}
		
		Arrays.sort(store);
		
		int m = sc.nextInt();
		
		
		for(int i=0;i<m;i++) {
			int result = 0;
			
			//이분 탐색
			int start = 0;
			int end = n-1;
			
			int target = sc.nextInt();
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				if(target == store[mid]) {
					result=1;
					break;
				}
				else if(target>store[mid]) {
					start=mid+1;
				}
				
				else if(target<store[mid]) {
					end = mid-1;
				}
			}
			System.out.println(result);
			
		}//end for


	}

}