import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[][] map;
	
	static class Point{
		int r;
		int c;
		int distance;
		public Point(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance=distance;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String info = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=info.charAt(j)-'0';
			}
		}
		
		System.out.println(BFS(0, 0));//출발지점 시작 및 결과 출력
		
		
	}
	
	public static int BFS(int startR, int startC) {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited=new boolean[N][M];
		
		q.add(new Point(startR,startC,1));
		
		visited[startR][startC]=true;
		int[][] orderList = new int[N][M];
		
		orderList[startR][startC]=1;
		
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			for(int d=0;d<4;d++) {
				int row = curr.r+drc[d][0];
				int col = curr.c+drc[d][1];
				
				if(row<0 || row>=N || col<0 || col>=M) continue;
				if(map[row][col]==0) continue;
				if(visited[row][col]) continue;
				
				visited[row][col]=true;
				
				orderList[row][col]=curr.distance+1;
				
				q.add(new Point(row,col,curr.distance+1));
			
			}//같은 범위는 같은 order
		}

		return orderList[N-1][M-1];
	}

}