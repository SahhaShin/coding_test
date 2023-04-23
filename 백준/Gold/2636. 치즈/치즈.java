import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int height, width;
	static int[][] map;
	static Queue<Node> q;
	static boolean[][] sel;// 녹아서 큐에 들어간 치즈 표시
	static int hour;// 모두 녹는데 걸린 시간
	static int prevTimeMelting;// 이전 시간에 녹은 치즈 수
	static int totalCheese;// 현재 남은 치즈
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상 하 좌 우

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", hour=" + hour + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();// 세로의 길이
		width = sc.nextInt();// 가로의 길이

		// 초기화
		map = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					totalCheese++;// 전체 치즈 수를 구해준다.
			}
		}

		// 입력 끝
		while (totalCheese > 0) {
			sel = new boolean[height][width];
			hour++;
			prevTimeMelting = totalCheese;
			changeCheese();// 치즈 변화 함수
		}

		System.out.println(hour);
		System.out.println(prevTimeMelting);
	}

	public static void changeCheese() {
		q = new LinkedList<>();
		q.add(new Node(0, 0));
		sel[0][0] = true;// 0,0에는 확실히 치즈가 없기 때문에 여기서부터 시작

		while (!q.isEmpty()) {
			Node cur = q.poll();

			// 치즈가 없는 공간이면 4방탐색을 해서 치즈가 있다면, 없애준다.
			// 큐에는 공간이 0인 곳만 넣는다. 치즈랑 만나면 넣어주진 말고, 없애주기만 해라 > 공기 안통하는 치즈까지 공기가 통하게 되기 때문이다.
			for (int d = 0; d < 4; d++) {
				int row = cur.r + drc[d][0];
				int col = cur.c + drc[d][1];
				if (row < 0 || row >= height || col < 0 || col >= width || sel[row][col]) continue;
				sel[row][col] = true;
				if (map[row][col] == 0) {
					q.add(new Node(row, col));
				} else {
					map[row][col] = 0;
					totalCheese--;
				}
			}

		}
	}

}