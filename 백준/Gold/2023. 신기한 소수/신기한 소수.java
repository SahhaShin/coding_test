import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백트래킹 문제
// 신기한 소수
// 에라토스테네스의 체 
public class Main {
	static int n;
	static StringBuilder sb;
	static String[] alwaysSosu = { "1" , "3" , "7" , "9" };
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		sb = new StringBuilder();
		
		// 한 자리의 소수는 고정되어이쓰므로, 이거부터 시작하기
		String[] startSosu = {"2" , "3" , "5" , "7" };
		for(int i = 0; i < startSosu.length; i++) {
			backTracking(startSosu[i], 1);
		}
		
		System.out.print(sb.toString());
	}
	
	// 백트래킹
	// 자리 수 하나씩 증가할 때 마다, 해당 함수 재귀호출 
	static void backTracking(String sosu, int len) {
		if(len >= n) {
			sb.append(sosu).append("\n");
			return;
		}
		
		for(int i = 0; i < alwaysSosu.length; i++) {
			String nextSosu = sosu + alwaysSosu[i];
			int nextSosuNumber = Integer.valueOf(nextSosu);
			if(isSosu(nextSosuNumber)) {
				backTracking(nextSosu, len + 1);
			}
		}
	}
	
	// 해당 수가 소수인지 체크하기
	// 에라토스테네스의 체 이용 
	static boolean isSosu(int num) {
		int sqrt = (int) Math.sqrt(num);
		for(int i = 2; i <= sqrt; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}