import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static char[][] map;
	static int our_team;
	static int enemy;
	static boolean[][] visited;
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}

	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//가로
		M = sc.nextInt();//세로
		
		map = new char[M][N];
		
		for(int i=0;i<M;i++) {
			map[i]=sc.next().toCharArray();
		}
		
		//입력 끝
		
		//우리팀 전력
		int count=0;
		visited = new boolean[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='W' && !visited[i][j]) {
					visited[i][j]=true;
					count = bfs(i,j,'W');
					our_team+=Math.pow(count, 2);
					
				}
			}
		}
		
		//상대팀 전력
		visited = new boolean[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='B' && !visited[i][j]) {
					visited[i][j]=true;
					count = bfs(i,j,'B');
					enemy+=Math.pow(count, 2);
					
				}
			}
		}

		
		System.out.println(our_team+" "+enemy);

	}
	
	public static int bfs(int startR, int startC, char color) {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
		
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(startR, startC));
		
		int count=1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int nextR = cur.r+drc[d][0];
				int nextC = cur.c+drc[d][1];
				
				//경계체크
				if(nextR<0 || nextR>=M || nextC<0 || nextC>=N) continue;
				if(map[nextR][nextC]==color && !visited[nextR][nextC]) {
					count++;
					visited[nextR][nextC]=true;	
					q.add(new Node(nextR,nextC));					
				}
				
				
			}
		}
		return count;
		
	}

}