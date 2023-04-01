import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    //다익스트라 풀이법
    
	static int N;
	static int[][] map;
	static int result;
	static class Location implements Comparable<Location> {
		int r;
		int c;
		int fee;

		public Location(int r, int c, int fee) {
			super();
			this.r = r;
			this.c = c;
			this.fee = fee;
		}

		@Override
		public int compareTo(Location o) {
			return this.fee > o.fee ? 1 : -1;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {
			N = sc.nextInt();// 지도크기
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String info = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = info.charAt(j)-'0';
				}
			}

			// 입력받기 끝
			
			//최소 비용 구하기
			dijkstra(0,0);
			
			//결과출력
			System.out.println("#"+T+" "+result);
			
			//초기화
			result=0;

		} // test case end
	}

	static public void dijkstra(int startR, int startC) {
		// 상 하 좌 우
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean[][] visited = new boolean[N][N];
		Queue<Location> pq = new PriorityQueue<>();
		int[][] d = new int[N][N];

		// 1. 거리 무한대 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}

		// 2. 출발점 셋팅
		d[startR][startC] = 0;
		pq.offer(new Location(startR, startC, 0));
		visited[startR][startC]=true;
		
		while (!pq.isEmpty()) {
			
			Location nowLocation = pq.poll();
			int nowR = nowLocation.r;
			int nowC = nowLocation.c;
			
			// 인접 노드는 4개 : 상 하 좌 우
			for (int i = 0; i < 4; i++) {
				int nextR = nowR + drc[i][0];
				int nextC = nowC + drc[i][1];

				// 경계체크
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
					continue;
				
				//방문체크
				if(visited[nextR][nextC]) continue;
				
				if(d[nowR][nowC]+map[nextR][nextC]<d[nextR][nextC]) {
					visited[nextR][nextC]=true;
					d[nextR][nextC]=d[nowR][nowC]+map[nextR][nextC];
					pq.add(new Location(nextR, nextC, d[nextR][nextC]));
				}
			}

		}
		result = d[N-1][N-1];
	}

}