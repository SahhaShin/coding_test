import java.util.Scanner;

public class Solution {

	static int ingredient_count;
	static int limit_cal;
	static int[][] score_cal;
	static int max_score = 0;// 가장높은맛점수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int T = 1; T < t + 1; T++) {
			// 1.재료의 수 / 제한칼로리
			ingredient_count = sc.nextInt();
			limit_cal = sc.nextInt();

			// 2. 재료 수만큼의 맛점수 / 칼로리
			score_cal = new int[ingredient_count ][2];
			for (int i = 0; i < ingredient_count; i++) {
				score_cal[i][0] = sc.nextInt();
				score_cal[i][1] = sc.nextInt();
			}

			// 3. 구현
			dfs(0,0,0);
			System.out.println("#" + T + " " + max_score);
			max_score = 0;// 초기화

		} // test case end

	}

	static public void dfs(int depth, int score, int cal) {
		// 1. 만약 limit cal보다 넘치면 못씀!
		if (cal > limit_cal)
			return;

		// 2. 만약 모든 재료를 고려했다면 크기 비교 후 끝
		// limit cal보다 넘치지 않아도 모든 재료를 고려했음에도 끝나지 않았다면 여기서 끝남
		if (depth == ingredient_count) {
			if (max_score < score) {
				max_score = score;// 가장 높은 맛점수와 비교 후 갱신
			}
			return;
		}

		// 3. 만약 limit cal보다 작거나 같다면
		//limit cal보다 커질 때까지 혹은 모든 재료를 고려할 때까지 계속 재귀 돌리기
		//요소 선택 사항을 보여줄 필요는 없으니 visited 리스트는 생략
		
		dfs(depth + 1,score+score_cal[depth][0],cal+score_cal[depth][1]);// depth번째 재료를 사용했어!
		dfs(depth + 1,score,cal);// depth번째 재료를 안했어!

	}
}