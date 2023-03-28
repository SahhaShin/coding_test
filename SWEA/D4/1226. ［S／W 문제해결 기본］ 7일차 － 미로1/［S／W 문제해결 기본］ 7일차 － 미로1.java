import java.util.Scanner;

public class Solution {
	
	//DFS
	static int[][] map;
	static boolean[][] visited;
	static int[][] start;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T=1; T<=10;T++) {
			
			int test = sc.nextInt();//test case
			
			map = new int[16][16];
			visited=new boolean[16][16];
			
			//미로 정보 받기 
			start = new int[1][2];
			
			for(int i=0;i<16;i++) {
				String info = sc.next();
				for(int j=0;j<16;j++) {
					map[i][j]=info.charAt(j)-'0';
					
					//시작지점 받기 
					if(map[i][j]==2) {
						start[0][0]=i;
						start[0][1]=j;
					}
				}
			}
			
			//구현
			visited[start[0][0]][start[0][1]]=true;
			DFS(start[0][0],start[0][1]);
			
			if(flag) {
				//결과출력
				System.out.println("#"+T+" "+1);
			}
			
			else System.out.println("#"+T+" "+0);//false면 탈출 불가능 
			
			//초기화
			flag=false;
			
		}

	}
	
	/**
	 * 나는 2인 출발지점에서 3인 탈출지점을 가고 싶다.
	 * DFS는 4방 탐색 후 갈 수 있는 곳으로 재귀를 불러 시스템 스택을 쌓는다.
	 * 갈수있는곳으로 쭉 가다가 벽인 1을 만나면 
	 * */
	public static void DFS(int startR, int startC) {
		//상 하 좌 우 
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int direc=0;direc<4;direc++) {
			int row = startR+drc[direc][0];
			int col = startC+drc[direc][1];
			
			//경계체크
			if(row<0 || row>=16 || col<0 || col>=16) continue;
			
			//case 1. 벽을 만나면 return
			if(map[row][col]==1) continue;//벽을 만나도 전체 미로 찾기를 종료하면 안됨 다른 경로를 찾아야 한다.
			
			//case 2. 탈출구를 만나면 return 
			if(map[row][col]==3) {
				flag=true;//탈출가능 
				return;
			}
			
			//case 3. 통로를 만나면 시스템 스택 쌓기
			//방문을 체크해주는 이유 인접한 다음 위치에서 4방탐색하며 방문했던 현재 위치를 또 방문할 수 있기 떄문이다.
			if(!visited[row][col] && map[row][col]==0) {
				visited[row][col]=true;
				DFS(row,col);//이 row, col에서 새로운 시작 
			}
		}
	}

}