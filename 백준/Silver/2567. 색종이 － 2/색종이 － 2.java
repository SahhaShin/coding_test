import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. 종이수
		int count = sc.nextInt();

		// 2. map 채우기
		// 끝점 저장해두기
		// 종이 번호로 채우기
		int[][] map = new int[101][101];// 도화지 100x100

		for (int i = 1; i <= count; i++) {
			// 꼭지점 입력받고 저장
			int r = sc.nextInt();// 3
			int c = sc.nextInt();// 7

			// 입력받은 영역 색칠
			// row 7 col 3
			for (int a = r; a < r + 10; a++) {
				for (int b = c; b < c + 10; b++) {
					map[a][b] = 1;
				}
			}

		} // 도화지 영역 입력 끝

		// 3. 둘레구하기
		// 상하좌우를 탐색해서 비어있으면 모서리다
		int dulea = 0;
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int a = 1; a <= 100; a++) {
			for (int b = 1; b <= 100; b++) {
				// 0이 아닌 수가 채워져 있으면 종이
				if (map[a][b] != 0) {
					// 4방 탐색 for
					for (int c = 0; c < 4; c++) {
						// 상하좌우 탐색
						// 경계 체크
						if (a + drc[c][0] >= 0 && a + drc[c][0] <= 101 && b + drc[c][1] >= 0 && b + drc[c][1] <= 101) {
							int row = a + drc[c][0];
							int col = b + drc[c][1];
							// 상하좌우 탐색 -> 비어있으면 둘레 1 추가
							if(row==0 || row == 101 || col==0 || col==101) {
								dulea++;
							}
							else if (map[row][col] == 0) {
								dulea++;
							}
							

						}
					}
				}

			}
		}

		System.out.println(dulea);

	}
}
