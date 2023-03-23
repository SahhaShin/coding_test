import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] 규영카드 = new int[10];// 규영 -> 순서 고정
	static int[] 인영카드 = new int[10];// 인영 -> 순서 고정 아님
	static int[] 인영카드순서 = new int[10];
	static boolean[] total_card = new boolean[19];// 1~18까지의 카드 ture면 규영이가 가져간것
	static boolean[] sel = new boolean[10];
	static int win = 0;// 규영 승
	static int lose = 0;// 규영 패

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // test case

		for (int T = 1; T <= t; T++) {

			// 9장의 카드 입력
			// 1~18
			for (int i = 1; i <= 9; i++) {
				규영카드[i] = sc.nextInt();
				total_card[규영카드[i]] = true;
			}

			// 규영이가 받지 않은 카드는 인영이꺼
			int idx = 1;
			for (int i = 1; i <= 18; i++) {
				if (!total_card[i]) {
					인영카드[idx++] = i;
				}
			}

			// 카드 분배 완료

			// 게임시작
			game(1); // 1라운드, 1번 카드 선택부터 시작

			// 결과
			System.out.println("#" + T + " " + win + " " + lose);
			// 초기화
			win = 0;
			lose = 0;
			total_card=new boolean[19];
		}
	}

	/**
	 * 인영이가 내는 카드 순서에 따라 규영이의 승패가 달라짐 규영이가 내는 카드 순서는 변하지 않음 높은 수 카드를 1장 내면 이김 -> 두
	 * 카드 합만큼 점수 가져감 지면 아무런 점수 없음 무승부일 수도 있음 총 9라운드 진행 (round == depth)
	 */
	static public void game(int round) {
		if (round == 10) {
			// 카드 점수를 계산한다.
			int 인영점수 = 0;
			int 규영점수 = 0;
			for (int i = 1; i <= 9; i++) {
				if (인영카드순서[i] > 규영카드[i]) {
					인영점수 += 인영카드순서[i] + 규영카드[i];
				} else {
					규영점수 += 인영카드순서[i] + 규영카드[i];
				}
			} // 각 점수 계산 끝

			if (인영점수 > 규영점수)
				lose++; // 규영짐
			else if (인영점수 < 규영점수)
				win++; // 규영이김
			// 아니면 무승부임

			return; // 9 게임 승부 끝 종료
		}

		
		for(int i=1;i<=9;i++) {
			인영카드순서[round] = 인영카드[i];// ex) 첫번째 라운드에서 인영카드 1번을 넣는다.
			if (!sel[i]) {
				sel[i] = true;
				game(round + 1);// 이 카드 선택
				sel[i] = false;
			}
			
		}
	}

}