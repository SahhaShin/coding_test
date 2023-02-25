

import java.util.Scanner;

public class Main {
	
	//mCn M개의 다리 중 N개를 선택하는 경우 
	//조합은 중복 허용하지 않기 때문에 중복 걱정 ㄴㄴ
	//계산 방법 5C2 = 5*4 / 2*1 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. test case
		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {
			int N = sc.nextInt();// 왼 2
			int M = sc.nextInt();// 오 5
			double top = 1;
			double bottom=1;
			//분모 계산
			for(double i=M;i>M-N;i--) {
				top=top*i;
			}
			
			//분자 계산 
			for(double i=N;i>0;i--) {
				bottom=bottom*i;
			}
			
			double result = top/bottom;
			System.out.printf("%.0f\n",top/bottom);
			
		}//test case end 

	}

}
