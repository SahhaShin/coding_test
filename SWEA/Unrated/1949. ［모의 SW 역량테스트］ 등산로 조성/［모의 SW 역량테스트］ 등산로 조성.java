import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, K, maxH, result;
	static int[][] map;
	static List<Point> startPoint;
	static boolean[][] visited;

	static class Point {
		int r;
		int c;
		int height;
		boolean cut;

		public Point(int r, int c, int height) {
			super();
			this.r = r;
			this.c = c;
			this.height = height;
		}

		public Point(int r, int c, int height, boolean cut) {
			super();
			this.r = r;
			this.c = c;
			this.height = height;
			this.cut = cut;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// test case

		for (int T = 1; T < t + 1; T++) {
			N = sc.nextInt();// 지도 한 변의 길이
			K = sc.nextInt();// 최대 공사 가능 깊이

			// 초기화
			map = new int[N][N];
			startPoint = new ArrayList<>();

			maxH = 0;// 가장 높은 산의 높이

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > maxH)
						maxH = map[i][j];
				}
			}

			// 출발 지점 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH)
						startPoint.add(new Point(i, j, map[i][j]));
				}
			}

			// 출발지점 정해주고 함수 출동
			for (int start = 0; start < startPoint.size(); start++) {
				visited = new boolean[N][N];
				visited[startPoint.get(start).r][startPoint.get(start).c] = true;// 시작지점 방문처리
				makeMountain(startPoint.get(start),startPoint.get(start), 1);// 현재 위치부터 길이 1 시작
			}

			// 결과 출력
			System.out.println("#" + T + " " + result);

			// 초기화
			result = 0;
			maxH = 0;
		} // test case end

	}

	// 특정한 도착지가 없기 때문에 DFS를 쓰겠다.
	public static void makeMountain(Point start, Point cur, int len) {
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상 하 좌 우

		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nextR = cur.r + drc[d][0];
			int nextC = cur.c + drc[d][1];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
				continue;// 경계체크
			if (visited[nextR][nextC])
				continue;// 이미 방문한 곳은 방문 안해도 됨

			// 이전 산 높이보다 큰데, 깎을 수도 없다. -> 그럼 끝 -> 산 길이 갱신
			if (cur.height <= map[nextR][nextC] && cur.cut) {
				result = Math.max(result, len);
				continue;// 다음 방향 진행
			}

			// 이전 산 높이보다 큰데, 깎을 수 있다. -> 이전 산 높이 -1이 될 수 있게 깎을 수 있는지 확인하고, 가능하면 DFS
			if (cur.height <= map[nextR][nextC] && !cur.cut) {
				if (map[nextR][nextC] - cur.height + 1 <= K) {
					visited[nextR][nextC] = true;
					makeMountain(start,
							new Point(nextR, nextC, map[nextR][nextC] - (map[nextR][nextC] - cur.height + 1), true),
							len + 1);
					visited[nextR][nextC] = false;//나와야 다음 가는 길에 고려할 수 있음
				}
				//깎을 수 있어도 K를 넘어서 깎을 수 없다. -> 길이 포함 x
				else {
					result = Math.max(result, len);
					continue;
				}
			}

			// 다음 산 높이가 지금 산 높이보다 낮다.
			if (cur.height > map[nextR][nextC]) {
				visited[nextR][nextC] = true;
				makeMountain(start,new Point(nextR, nextC, map[nextR][nextC], cur.cut), len + 1);
				visited[nextR][nextC] = false;//나와야 다음 가는 길에 고려할 수 있음
			}

		}

	}

}