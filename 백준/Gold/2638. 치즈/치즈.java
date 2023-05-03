import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] visited;
    static int day;
    static int totalCheeze;//전체 치즈수
    static int N,M;
    
    static class Node{
        int row;
        int col;
        public Node(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); //세로 격자의 수
        M = sc.nextInt(); //가로 격자의 수
        
        // 초기화
        map = new int[N][M]; 
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]==1) totalCheeze++;
            }
        }
        
        // 입력 받기 끝
        
        //bfs (총 치즈수가 0개가 될 때까지)
        while(totalCheeze!=0) {
        	visited = new int[N][M];
        	cheeze(0,0);
        	day++;        	
        }
        
        System.out.println(day);

    }
    
    public static void cheeze(int startR, int startC){
        int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    	Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(startR,startC));
        visited[startR][startC] = 1;
        
        while(!q.isEmpty()) {
        	Node cur = q.poll();
        	
        	for(int d=0;d<4;d++) {
        		int row = cur.row+drc[d][0];
        		int col = cur.col+drc[d][1];
        		
        		if(row<0 || row>=N || col<0 || col>=M) continue;
        		if(map[row][col]==0 && visited[row][col]==0) {
        			q.add(new Node(row,col));
        			visited[row][col]++;
        		}
        		if(map[row][col]==1) {
        			visited[row][col]++;
        			//공기에 2변 이상 노출 -> 녹음
        			if(visited[row][col]>=2) {
        				map[row][col]=0;
        				totalCheeze--;
        			}
        		}
        	}//4방 탐색 끝
        }
    }

}