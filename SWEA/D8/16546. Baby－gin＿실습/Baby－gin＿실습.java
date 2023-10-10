
import java.util.*;
public class Solution {
	
	static int[] numbers_count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int T=1;T<=test;T++) {
			char[] numbers = sc.next().toCharArray();
			numbers_count = new int[10];
			
			//	6자리 수  
			for(int i=0;i<6;i++) {
				numbers_count[(numbers[i]-'0')]++;
			}
			
			//1. run인지 확인
			if(!run()) {
				if(!triple()) {
					System.out.println("#"+T+" "+false);
                    continue;
				}
			}else {
				if(!run()) {
					if(!triple()) {
						System.out.println("#"+T+" "+false);
                         continue;
					}
				}
			}
			
			System.out.println("#"+T+" "+true);
		}//test end

	}
	
	public static boolean run() {
		boolean flag = true;
		for(int i=0;i<10;i++) {
			if(numbers_count[i]>=1) {
				if(i+1<10 && numbers_count[i+1]>=1) {
					if(i+2<10 && numbers_count[i+2]>=1) {
						numbers_count[i]--;
						numbers_count[i+1]--;
						numbers_count[i+2]--;
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean triple() {
		
		for(int i=0;i<10;i++) {
			if(numbers_count[i]>=3) {
				numbers_count[i]-=3;
				return true;
			}
		}
		
		return false;
	}

}
