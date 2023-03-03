import java.util.Scanner;

public class Solution {

	//하루에 최대 1만큼 구입
	//판매는 얼마든지 할 수 있다.
	//최대이익을 구해라
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 매매가 예측 갯수
			int n = sc.nextInt();
			
			//3. 매매가
			int[] price = new int[n+1];//0을 쓰지 않음
			for(int i=1;i<n+1;i++) {
				price[i]=sc.nextInt();
			}
			//4. 구매하고 비싸게 팔아보자 
			//뒤에서 부터 돌아보자
			//뒤 기준으로 max를 정하고 그 때 그때 비싼 값을 기준으로 판다.
			int max=0;
			long profit = 0;
			for(int i=n;i>0;i--) {
				//가장 비싼날엔 안삼.
				if(max<price[i])max=price[i];//2->(1) -> 3 ->(1) ->(1)
				else {
					profit+=max-price[i];
				}
			}
			System.out.println("#"+T+" "+profit);
		}//test case

	}

}