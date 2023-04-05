import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map;
	static int N;
	static boolean[][] visited;
	
	static class Color{
		int r;
		int c;
		char color;
		public Color(int r, int c, char color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//배열 크기
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			map[i] = sc.next().toCharArray();
		}
		
		//일반인 영역 조사
		//visited가 안된 영역 BFS 보내기
		visited = new boolean[N][N];
		int 일반area=0;
		
		for(int startR=0;startR<N;startR++) {
			for(int startC=0;startC<N;startC++) {
				if(!visited[startR][startC]) {
					BFS(startR, startC);
					//BFS에서 나왔다면 영역 1이 추가된 것임
					일반area++;
				}
			}
		}
		
		//적록색맹인 영역 조사
		//R G을 같은 색으로 색칠하기
		for(int startR=0;startR<N;startR++) {
			for(int startC=0;startC<N;startC++) {
				if(map[startR][startC]=='G')map[startR][startC]='R';
			}
		}
		//visited 초기화
		visited = new boolean[N][N];
		//visited가 안된 영역 BFS 보내기
		int 색맹area=0;
		for(int startR=0;startR<N;startR++) {
			for(int startC=0;startC<N;startC++) {
				if(!visited[startR][startC]) {
					BFS(startR, startC);
					//BFS에서 나왔다면 영역 1이 추가된 것임
					색맹area++;
				}
			}
		}
		
		//결과출력
		System.out.println(일반area+" "+색맹area);
	}
	
	public static void BFS(int row, int col) {
		int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
		Queue<Color> q = new LinkedList<>();
		
		//시작점 저장
		q.add(new Color(row, col, map[row][col]));
		visited[row][col]=true;
		
		while(!q.isEmpty()) {
			Color curr = q.poll();//큐에서 첫 값 꺼내기
			
			//4방 조사
			for(int d=0;d<4;d++) {
				int newR = curr.r+direc[d][0];
				int newC = curr.c+direc[d][1];
				
				if(newR<0 || newR>=N || newC<0 || newC>=N) continue;//범위 체크
				if(map[newR][newC]!=curr.color) continue;//같은 색깔인지 확인
				
				//위의 2가지 제약사항을 확인받고 들어왔다면, 방문하지 않았다면 방문 체크 후 큐에 추가
				if(!visited[newR][newC]) {
					visited[newR][newC]=true;
					q.add(new Color(newR, newC, map[newR][newC]));
				}
			}	
		}
	}
}