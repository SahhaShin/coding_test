import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[][] visited;
	static int[][] fee;
	static int[][] map;
	static int[][] minR;//가장 작은 루피
	static int N;
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int blackR;
		
		public Node (int r, int c, int blackR) {
			super();
			this.r = r;
			this.c = c;
			this.blackR = blackR;
		}

		@Override
		public int compareTo(Node o) {
			return this.blackR>o.blackR?1:-1;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int turn=1;
		while(true) {
			N = sc.nextInt();
			if(N==0) break;
			
			//초기화
			fee = new int[N][N];
			visited = new boolean[N][N];
			map = new int[N][N];
			minR = new int[N][N];
			
			//minR 최대값으로 초기화
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					minR[i][j]=Integer.MAX_VALUE;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//입력 받기 끝
			
			dijkstra();
			
			System.out.println("Problem "+turn+": "+minR[N-1][N-1]);
			
			turn++;

		}

	}
	
	public static void dijkstra() {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
		PriorityQueue<Node> q = new PriorityQueue<>();//연결된 갈 수 있는 길을 저장
		
		//첫 값 저장
		q.add(new Node(0,0,map[0][0]));
		minR[0][0]=map[0][0];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			visited[cur.r][cur.c]=true;
			
			for(int d=0;d<4;d++) {
				int nextR = cur.r+drc[d][0];
				int nextC = cur.c+drc[d][1];
				
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=N || visited[nextR][nextC]) continue;
				
				if(minR[cur.r][cur.c]+map[nextR][nextC]<minR[nextR][nextC]) {
					minR[nextR][nextC]=minR[cur.r][cur.c]+map[nextR][nextC];
					q.add(new Node(nextR,nextC,minR[nextR][nextC]));//얘랑 연결된 길도 값이 바뀔거기 떄문에 큐에 넣는다.
					
				}
			}	
		}	
	}
}