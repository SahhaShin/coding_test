import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우 
	static boolean[] connection;
	static int[][] minDistance;
	static PriorityQueue<Bridge> pq = new PriorityQueue<>();
	static int count;
	static int[] p, rank;

	
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Bridge implements Comparable<Bridge>{
		int start;
		int end;
		int len;
		
		public Bridge(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.len>o.len?1:-1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //세로길이
		M = sc.nextInt(); //가로길이 
		
		//초기화
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		//입력 받기 끝 
		
		//1. 섬 구분 (BFS)
		count = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && visited[i][j]==false) {
					BFS(i,j,count);
					count++;
				}
			}
		}
		
		
		//2. 다리 만들 수 있는 곳 모두 pq 넣기 
		//0이상인 지점 선택해 다리 만들기로 보내주기 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>=1) {
					//하나의 섬에 대해 4방탐색 -> dfs 
					for(int d=0;d<4;d++) {
						bridge(i,j,d, map[i][j],-1);
					}
				}
			}
		}
		
		//3. 최소값부터 확인 후 연결 확인 -> 크루스칼 
		p = new int[count];
		rank = new int[count];
		setP();//부모셋팅 
		int pick = 0;//count-1만큼 선택하면 끝 
		int result = 0;
	
		while(!pq.isEmpty()) {
			Bridge curB = pq.poll();
			if(find(curB.start)==find(curB.end)) {
				continue;
			}
			
			else {
				union(curB.start,curB.end);
				pick++;
				result+=curB.len;
				
				if(pick==count-2) break;
			}
		}

		
		if(pick<count-2) System.out.println(-1); //count는 섬 수보다 +1많은 상태 
		else System.out.println(result);

	}
	
	//섬의 구분을 지어주는 함수 count는 섬의 번호 
	public static void BFS(int startR, int startC, int count) { 
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(new Node(startR,startC));
		visited[startR][startC]=true;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			map[curNode.x][curNode.y]=count;
			
			//현재 위치와 근접한 위치들 넣기 
			for(int d=0;d<4;d++) {
				int nextR = curNode.x+drc[d][0];
				int nextC = curNode.y+drc[d][1];
				
				//경계체크
				if(nextR<0||nextR>=N || nextC<0 || nextC>=M) continue;
				
				//방문하지 않은 노드, 큐에 들어가지 않은 노드 
				if(map[nextR][nextC]==1 && !visited[nextR][nextC]) {
					q.add(new Node(nextR, nextC));
					visited[nextR][nextC]=true;
				}
			}
			
		}
		
	}
	
	//0이 있는 곳이 상/하/좌/우 인지 따져서 그 길로 쭉 갔을 때
	//경계 밖이면 다리를 만들 수 없다.
	//섬을 만나면 다리를 만들 수 있다.
	//4방 중 다리를 만들 수 있는 최소 거리를 구할 것 
	//다리의 길이는 2 이상이다. 
	public static void bridge(int r, int c, int direc, int island, int len) {
		//다른 섬을 만났다.
		if(map[r][c]!=0 && map[r][c]!=island) {
			//길이가 2이상인 것만 넣어라 -> 다른 섬 만났으니 종료 
			if(len>=2) pq.add(new Bridge(island, map[r][c],len));
			return;
		}
		
		int nextR = r+drc[direc][0];
		int nextC = c+drc[direc][1];
		
		//경계체크 
		if(nextR<0||nextR>=N||nextC<0||nextC>=M) return;
		if(map[nextR][nextC]==island) return;
		bridge(nextR, nextC, direc, island, len+1);
	}
	
	public static void setP() {
		for(int i=1;i<count;i++) {
			p[i]=i;
			rank[i]=0;
		}
	}
	
	public static int find(int child) {
		if(p[child]==child) return child;
		else return p[child]=find(p[child]);
	}
	
	public static void union(int c1, int c2) {
		int p1 = find(c1);
		int p2 = find(c2);
		
		if(rank[p1]>rank[p2]) {
			p[p2]=p1;
			rank[p1]++;
		}else if(rank[p1]<=rank[p2]) {
			p[p1]=p2;
			rank[p2]++;
		}
	}
	
}