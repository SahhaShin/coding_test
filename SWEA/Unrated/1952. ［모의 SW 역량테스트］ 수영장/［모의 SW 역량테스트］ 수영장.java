import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int result = Integer.MAX_VALUE;// 수영장을 이용하는 경우 중 가장 적게 지출하는 비용
	static int[] fee;
	static int[] month;
	static int totalDay;

	// static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// TEST CASE
		for (int T = 1; T < t + 1; T++) {

			// 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권의 요금
			fee = new int[4];
			for (int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}

			// 1월부터 12월까지의 이용 계획
			month = new int[13];// 1~12
			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();

				// totalDay+=month[i];
			}

			// 구현
			permutation(1, 0);

			// 결과도출
			System.out.println("#" + T + " " + result);

			// 초기화
			result = Integer.MAX_VALUE;

		} // TEST CASE END

	}

	/**
	 * 중복있는 순열임 mon : 달, static month배열과 헷갈리지 말 것 registFee : 등록비용
	 * 
	 */
	static public void permutation(int mon, int registFee) {
		// 12달 모두 고려 -> 적은 비용 고려
		if (mon >= 13) {
			result = Math.min(result, registFee);
			return;
		}
		// 사용일수가 없으면 pass
		if (month[mon] == 0) {
			permutation(mon + 1, registFee);
		}

		// 이용권 4개 고려
		for (int j = 0; j < 4; j++) {
			// 1일 이용권 -> 해당 달 일수만큼 사줘야함
			if (j == 0) {
				permutation(mon + 1, registFee + (fee[j] * month[mon]));
			}

			// 1달 이용권 -> 1개만 사면됨
			else if (j == 1) {
				permutation(mon + 1, registFee + fee[j]);
			}

			// 3달 이용권의 요금 -> 1개만 사면됨, mon을 +3해줘야함
			// 11월, 12월에도 3달 이용권을 사용할 수 있다 / 다음 해의 이용권만을 구매할 수 있기 때문에
			// 3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할 수는 없다.
			else if (j == 2) {
				permutation(mon + 3, registFee + fee[j]);
			}

			// 1년 이용권의 요금 -> 1개만 사면됨, mon+12해줘야함
			// 매년 1월 1일(i==0)부터 시작한다.
			else if (j == 3 && mon == 1) {
				permutation(mon + 12, registFee + fee[j]);
			}
		}

	}

}