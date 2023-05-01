import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int result;
	static int R, C;
	static char[][] arr;
	static boolean[] visited = new boolean[26];
	static class Alpha {
		int x;
		int y;
		int order;

		public Alpha(int x, int y, int order) {
			super();
			this.x = x;
			this.y = y;
			this.order = order;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();// 2
		C = sc.nextInt();// 4

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = sc.next().toCharArray();
		}

		// 입력 받기 끝
		visited[arr[0][0]-65]=true;
		dfs(0,0,1);

		System.out.println(result);

	}

	public static void dfs(int x, int y, int order) {
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
		if(result<order) result=order;
		
		for (int d = 0; d < 4; d++) {
			int row = x + drc[d][0];
			int col = y + drc[d][1];
			if (row < 0 || row >= R || col < 0 || col >= C || visited[arr[row][col] - 65])
				continue;
			
			visited[arr[row][col] - 65] = true;
			dfs(row,col,order+1);
			visited[arr[row][col] - 65] = false;
		}

	}
}