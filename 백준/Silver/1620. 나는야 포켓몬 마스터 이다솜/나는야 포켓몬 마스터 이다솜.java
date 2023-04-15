import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//포켓몬 개수
		int M = sc.nextInt();//내가 맞춰야 하는 문제 개수
		
		//포켓몬 정보 받기
		HashMap<Integer,String> pocketmonNum = new HashMap<>();
		HashMap<String,Integer> pocketmonName = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String name = sc.next();
			pocketmonNum.put(i, name);
			pocketmonName.put(name, i);
		}
		
		//퀴즈 시작
		for(int test=1;test<=M;test++) {
			String ans = sc.next();
			
			if(isnum(ans)) {
				int num_ans = Integer.parseInt(ans);
				System.out.println(pocketmonNum.get(num_ans));
			}else {
				System.out.println(pocketmonName.get(ans));
			}
		}//퀴즈 끝

	}
	
	public static boolean isnum(String ans) {
		try {
			Integer.parseInt(ans);
		}catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

}