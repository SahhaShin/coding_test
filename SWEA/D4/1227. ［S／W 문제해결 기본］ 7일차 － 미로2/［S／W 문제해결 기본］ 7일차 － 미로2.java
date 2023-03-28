import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	//BFS
	
	//시작 지점과 끝지점을 가진 노드들
	static class node{
		int r;
		int c;
		node(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	
	static boolean flag;
	static int[][] map;
	static boolean[][] visited;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<=10;T++) {
            int test = sc.nextInt();//test case 
            
			map = new int[100][100];
			visited = new boolean[100][100];
			int startR=0;
			int startC=0;
			
			for(int i=0;i<100;i++) {
				String info = sc.next();
				for(int j=0;j<100;j++) {
					map[i][j]=info.charAt(j)-'0';
					
					//출발지점 찾아주기 
					if(map[i][j]==2) {
						startR=i;
						startC=j;
					}
				}
			}
			
			BFS(startR, startC);
			
			if(flag)System.out.println("#"+T+" 1");
			else System.out.println("#"+T+" 0");
			
            //초기화
            flag=false;
			
			
		}//test case end

	}
	
	/**
	 * 출발지점을 queue에 집어넣고, 방문처리한다.(출발지점을 구지 넣는 이유는 q가 첫 시작부터 비면 안되기 때문이다.)
	 * 4방 탐색하면서 갈 수 있는 경로 모두를 queue에 넣고 방문처리한다.
	 * 이 작업을 queue가 빌 때까지 계속한다. 
	 * queue가 빈다는 것은 더이상 갈 수 있는 경로가 없다는 것을 의미한다.
	 * */
	static public void BFS(int startR, int startC) {
		//상 하 좌 우 
		int[][] drc= {{-1,0},{1,0},{0,-1},{0,1}};
		
		Queue<node> queue = new LinkedList<>();
		node startNode = new node(startR, startC);
		queue.offer(startNode);
		
		while(!queue.isEmpty()) {
			//현재 시작할 노드를 뽑기
			node curr = queue.poll();
			
			//4방탐색 
			for(int i=0;i<4;i++) {
				int row = curr.r+drc[i][0];
				int col = curr.c+drc[i][1];
				
				//경계체크
				if(row<0 || row>=100 || col<0 || col>=100) continue;
				
				//벽 만났으면 
				if(map[row][col]==1) continue;
				
				//탈출구를 만나면 flag를 true로 바꿔라 
				if(map[row][col]==3) {
					flag=true;
					return;
				}
				
				//갈 수 있는 길을 만나면 queue에 추가 
				if(!visited[row][col] && map[row][col]==0) {
					node newNode = new node(row,col);
					queue.offer(newNode);
					
					visited[row][col]=true;
				}
			}//4방 탐색 끝 
		}
		
	}

}