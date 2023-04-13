import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Node> q = new LinkedList<>();
	static boolean[][] visited;
	static int w,h,result;
	static int[][] tomato;
	static class Node{
		int r;
		int c;
		int day;
		public Node(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();//가로 칸의 수
		h = sc.nextInt();//세로 칸의 수
		
		//초기화
		tomato = new int[h][w];
		visited = new boolean[h][w];
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				tomato[i][j]=sc.nextInt();
				
				if(tomato[i][j]==1) {
					q.add(new Node(i,j,0));
					visited[i][j]=true;
				}
			}
		}
		
		//처음부터 다 익었으면 0
		if(allGrow()) {
			result = 0;
		}else {
			grow();
			//다 돌렸음에도 0인 공간이 있으면 -1
			if(!allGrow()) {
				result = -1;
			}			
		}
		
		System.out.println(result);

	}
	
	public static void grow() {
		
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(result<cur.day) {
				result=cur.day;
			}
			for(int d=0;d<4;d++) {
				int row = cur.r+drc[d][0];
				int col = cur.c+drc[d][1];
				
				if(row<0 || row>=h || col<0 || col>=w) continue;
				if(tomato[row][col]==-1)continue;//빈공간
				if(visited[row][col]) continue;
				
				q.add(new Node(row,col,cur.day+1));
				visited[row][col]=true;
			}
		}
	}
	
	public static boolean allGrow() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(tomato[i][j]!=-1 && visited[i][j]==false) {
					return false;
				}
			}
		}
		
		return true;
	}

}