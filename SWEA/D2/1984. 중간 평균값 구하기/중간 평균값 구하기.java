import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 테스트 케이스 입력받기
		int test_case = sc.nextInt();
		
		for(int test=0;test<test_case;test++) {
			//2. 10개 수 입력받기
			int[] numbers = new int[10];
			int max_index=0;
			int min_index=0;
			
			for(int i=0;i<10;i++) {
				numbers[i]=sc.nextInt();
				
				//최대수 찾기
				if(numbers[max_index]<numbers[i]) {
					max_index=i;
				}
			}
			
			//최소수를 찾기.
			for(int i=0;i<10;i++) {
				//최대 최소 같은 수를 방지
				if(max_index==i) {
					continue;
				}
				if(numbers[min_index]>numbers[i]) {
					min_index=i;
				}
			}
			
			
			//최소 최대 제외 나머지의 평균
			double result = 0;
			for(int i=0;i<10;i++) {
				if(i==max_index || i==min_index) {
					continue;
				}
				result+=numbers[i];
			}
			result=Math.round(result/8);
			System.out.printf("#%d %d\n",(test+1),(int)result);
			
		}//test_case end

	}

}