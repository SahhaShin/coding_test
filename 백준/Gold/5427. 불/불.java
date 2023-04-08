import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static List<Space> exit, fire;
	static int[][] me;
	static int w, h;
	static int ResultTime;

	static class Space {
		int r;
		int c;
		int time;// 내가 이 위치를 몇 초만에 도착했는가

		public Space(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();// test case
		for (int T = 1; T < t + 1; T++) {
			w = sc.nextInt();
			h = sc.nextInt();

			// 초기화
			map = new char[h + 2][w + 2];// 테두리는 탈출구임
			exit = new ArrayList<>();
			fire = new ArrayList<>();
			me = new int[1][2];// 내위치

			for (int i = 1; i <= h; i++) {
				String info = sc.next();
				for (int j = 1; j <= w; j++) {
					map[i][j] = info.charAt(j-1);

					// 내가 있는 곳 찾기
					if (map[i][j] == '@') {
						me[0][0] = i;
						me[0][1] = j;
					}
					// 불이 있는 곳 저장
					if (map[i][j] == '*') {
						fire.add(new Space(i, j, 0));
					}
				}
			}

			// 시작
			if (Run(me[0][0], me[0][1], 0)) {
				// 탈출성공
				System.out.println(ResultTime);
			} else {
				// 탈출실패
				System.out.println("IMPOSSIBLE");
			}
		} // test case end

	}

	// BFS
	public static boolean Run(int startR, int startC, int time) {
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상 하 좌 우
		boolean[][] visited = new boolean[h+2][w+2];
		Queue<Space> q = new LinkedList<>();

		int prevTime = -1;
		q.add(new Space(startR, startC, time));
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			Space cur = q.poll();// 현재 위치
			if (cur.r == 0 || cur.r == h + 1 || cur.c == 0 || cur.c == w + 1) {
				// 탈출구
				ResultTime = cur.time;
				return true;
			}

			// 이전 시간초와 다른시간대면 fire 예측
			if (cur.time != prevTime) {
				fire();// 탈출로를 선정하기 위해 미리 불이 붙을 곳을 표시한다.
			}
			prevTime = cur.time;
			for (int d = 0; d < 4; d++) {
				int row = cur.r + drc[d][0];
				int col = cur.c + drc[d][1];
				if (map[row][col] == '*' || map[row][col] == '#' || visited[row][col])
					continue;// 불이나 벽이 있으면 못감, 이미 방문한 위치여도 못감
				q.add(new Space(row, col, cur.time + 1));
				visited[row][col] = true;
			}
		}

		return false;
	}

	public static void fire() {
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상 하 좌 우
		
		// 불이 난 곳 4방 처리 -> 새롭게 불이 추가된 곳 fire에 추가
		for (int i = fire.size() - 1; i >= 0; i--) {
			Space cur = fire.remove(i);// 불이 나서 4방 체크해준 곳에서 또 불이 날일은 없으니 제거
			for (int d = 0; d < 4; d++) {
				int row = cur.r + drc[d][0];
				int col = cur.c + drc[d][1];

				if (row < 1 || row > h || col < 1 || col > w)
					continue;// 경계체크
				if (map[row][col] == '*' || map[row][col] == '#')
					continue;// 이미 불이 있거나 벽에는 불을 못 붙이므로 생략 '*'불 자체가 이미 방문처리 되었다는 뜻
				map[row][col] = '*';
				fire.add(new Space(row, col, 0));
			}
		}
	}
}