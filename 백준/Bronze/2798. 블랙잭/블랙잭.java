import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
		int N = sc.nextInt();
		
		//2. 그런 후에 딜러는 숫자 M을 크게 외친다.
		int M = sc.nextInt();
		
		//3. N장의 카드를 입력한다.
		int[] card = new int[N];
		for(int i=0;i<N;i++) {
			card[i]=sc.nextInt();
		}
		
		//4. N장의 카드 중에서 3장의 카드를 골라야 한다.
		//플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
		
		//target -> 2개 값 더해서 21이 넘는가?
		//5 -> 6 7 / 6 8 / 6 9 /7 8 / 7 9 / 8 9
		//6 -> 7 8 / 7 9 / 8 9
		//7 -> 8 9
		//8 -> x
		//돌면서 21보다 커지면 더해준 값 빼주고 max 저장
		int max=0;
		
		//N=5 -> 0 1 2
		//5 6 7 8 9치면 target = 5 i = 6 j =7을 가르키고 있어야 해서 시작 값을 아래처럼 
		for(int target=0;target<N-2;target++) {
			int tg = card[target];
			//index = 1~3 -> 6 7 8
			for(int i=target+1;i<N-1;i++) {
				//index = 2~4 -> 7 8 9
				for(int j=i+1;j<N;j++) {
					int plus = card[i]+card[j]; //6 7 -> 6 8 -> 6 9
					//3개 수의 합이 M을 넘지 않고, 
					//max보다 크다면 max값 재할당 
					//21때도 들어와야하니까 <=의 = 필수 
					if(plus+tg<=M && max<plus+tg) {
						max=plus+tg; //21
					}
				}
			}
		}//target for end 
		System.out.println(max);
	}
}
