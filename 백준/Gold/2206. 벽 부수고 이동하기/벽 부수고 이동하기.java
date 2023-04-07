import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;

	static class Node {
		int r;
		int c;
		int distance;
		boolean dazzle;// 벽을 부순적이 있다.

		public Node(int r, int c, int distance, boolean dazzle) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.dazzle = dazzle;
		}
	}

	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String info = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = info.charAt(j) - '0';
			}
		}

		// 입력 받기 끝
		
		bump();

	}

	public static void bump() {
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상 하 좌 우
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2];// NXM배열의 (0) 벽이 없는 차원과 (1) 벽이 있는 차원

		q.add(new Node(0, 0, 1, false));// 거리는 1부터 시작


		while (!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int distance = cur.distance;
			boolean dazzle = cur.dazzle;

			if (r == N - 1 && c == M - 1) {
				System.out.println(distance);// 도착지에 도착하면 결과를 출력해라
				return;
			}

			// 4방탐색 : 인접노드
			for (int d = 0; d < 4; d++) {
				int row = r + drc[d][0];
				int col = c + drc[d][1];

				// 범위 체크
				if (row < 0 || row >= N || col < 0 || col >= M)
					continue;

				if (map[row][col] == 0) {
					// 벽을 부순적이 없다.
					if (!dazzle && !visited[row][col][0]) {
						q.add(new Node(row,col,distance+1,false));
						visited[row][col][0]=true;
					}

					// 벽을 부순적이 있다.
					else if (dazzle && !visited[row][col][1]) {
						q.add(new Node(row,col,distance+1,true));
						visited[row][col][1]=true;
					}
				}

				else {
					// 벽을 부순적이 없다. -> 벽을 부술 수 있다.
					//현재 노드 기준으로 벽을 부순적이 없기 때문에 (0,1) (1,0)노드가 들어온다.
					if (!dazzle && !visited[row][col][0]) {
						q.add(new Node(row,col,distance+1,true));
						visited[row][col][1]=true;
					}

					// 벽을 부순적이 있다. -> 벽을 부술 수 없다. -> 갈 수 없다.
				}
			}//4방 탐색 종료
		}//while end
		
		//여기까지 왔다는 것은 출구를 못찾았다는 뜻
		System.out.println(-1);

	}

}