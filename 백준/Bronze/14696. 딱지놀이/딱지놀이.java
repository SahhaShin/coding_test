import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//별 : 4 / 동그라미 : 3 / 네모 : 2 / 세모 : 1
		
		//1. 딱지 라운드 수
		int round = sc.nextInt();
		for(int T=1;T<round+1;T++) {
			//A 카드
			int A_card_count = sc.nextInt();//카드 총 수 4
			int[] countA = new int[5];//1~4까지 몇 번 나왔는지 
			for(int i=0;i<A_card_count;i++) {
				countA[sc.nextInt()]++; //4
			}
			
			//B 카드
			int B_card_count = sc.nextInt();//카드 총 수 5
			int[] countB = new int[5];//1~4까지 몇 번 나왔는지 
			for(int i=0;i<B_card_count;i++) {
				countB[sc.nextInt()]++; //3 3 2 1
			}
			
			//4점짜리 부터 몇 개인지 비교해서 승자 가리기
			char result='\u0000';
			for(int i=4;i>=0;i--) {
				if(countA[i]>countB[i]) {
					result='A';
					break;
				}
				else if(countA[i]<countB[i]) {
					result='B';
					break;
				}
			}
			
			if(result=='\u0000') result='D';
			
			System.out.println(result);
		}//test case end
	}
}