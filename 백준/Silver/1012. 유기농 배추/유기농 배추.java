import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] ground;
	static boolean[][] visited;
	static int width, height;
	static class Cabbage{
		int x;
		int y;
		public Cabbage(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			width = sc.nextInt();//배추밭 가로 길이
			height = sc.nextInt();//배추밭 세로 길이
			
			int K= sc.nextInt();//배추가 심어져있는 위치 개수
			
			//초기화
			ground = new int[height][width];
			visited = new boolean[height][width];
			
			//배추 위치 
			for(int i=0;i<K;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				ground[y][x]=1;
			}
			
			//1인 위치 bfs로 보내서 영역 탐색 
			int whiteWorm=0;
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(ground[i][j]==1 && !visited[i][j]) {
						bfs(i,j);
						whiteWorm++;
					}
				}
			}
			
			System.out.println(whiteWorm);
			
		}//test case end

	}
	
	static public void bfs(int y, int x) {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<Cabbage> q = new LinkedList<>();
		
		q.add(new Cabbage(x,y));
		visited[y][x]=true;

		while(!q.isEmpty()) {
			Cabbage cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int next_y = cur.y+drc[d][0];
				int next_x = cur.x+drc[d][1];
				
				if(next_y<0 || next_y>=height || next_x<0 || next_x>=width || visited[next_y][next_x]) continue;
				
				if(ground[next_y][next_x]==1) {
					visited[next_y][next_x]=true;
					q.add(new Cabbage(next_x,next_y));
				}
			}
		}
	}

}