import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1.테스트 케이스
		int t = sc.nextInt();
		for (int T = 1; T < t + 1; T++) {
			// 2. 농장의 크기 n
			int n = sc.nextInt();
			int[][] grd = new int[n][n];
			// 3. 띄어쓰기 없는 농작물 가치 받기
			for (int i = 0; i < n; i++) {
				char[] num = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					grd[i][j] = num[j]-'0';
				}
			}

			// 4. 이익 거두기
			int add = 0;
			int profit = 0;
			for (int r = 0; r < n; r++) {
				// 일단 자신위치의 이익 구해
				profit += grd[r][n / 2];

				// n/2까지 1+

				// left
				for (int j = 1; j <= add; j++) {
					profit += grd[r][n / 2 - j];
				}
				// right
				for (int j = 1; j <= add; j++) {
					profit += grd[r][n / 2 + j];
				}

				if (r >= n / 2)
					add--;
				else
					add++;

			}
			System.out.println("#"+T+" "+profit);
		}//test case end
	}
}