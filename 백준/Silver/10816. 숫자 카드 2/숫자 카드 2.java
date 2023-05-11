import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//숫자 카드 개수
		
		HashMap<Integer, Integer> card = new HashMap<>();//나온 숫자 : 몇 개나왔는지
		
		for(int i=0;i<N;i++) {
			int key = sc.nextInt();
			if(card.containsKey(key)) {
				card.replace(key, card.get(key)+1);
			}else {
				card.put(key, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();//몇개 가지고 있는지 알아낼 갯수
		for(int i =0;i<M;i++) {
			int key = sc.nextInt();
			if(card.containsKey(key)) {
				sb.append(card.get(key)).append(" ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
}