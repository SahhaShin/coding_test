import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int IslandNum=1;
	static int minLen=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static List<Node>[] edge;//섬의 가장자리 좌표 저장
	static class Node{
		int r;
		int c;
		int len;//이 지점까지 오는데 거리가 얼마나 되니?
		
		public Node(int r, int c, int len) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//지도의 크기
		
		//초기화
		map = new int[N][N];
		visited = new boolean[N][N];
		edge = new ArrayList[N*N];
		for(int i=0;i<N*N;i++) {
			edge[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		//입력받기 끝
		
		//영역 나눠주기 & 가장 자리 저장
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					Island(new Node(i,j,0));
					IslandNum++;
				}
			}
		}
		
		//다른 섬까지 거리 체크
		//각 섬의 가장자리를 준다.
		for(int i=1;i<IslandNum;i++) {
			for(int j=0;j<edge[i].size();j++) {
				visited = new boolean[N][N];//방문 처리 초기화 -> 새로운 길
				//탐색 시작점 주기
				CheckLen(edge[i].get(j),i);
			}
		}
		
		//결과 출력
		System.out.println(minLen);

	}
	public static void Island(Node start) {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
		Queue<Node> q = new LinkedList<>();
		boolean[][] inedge = new boolean[N][N];//가장자리 중복 추가 방지용
		
		q.add(start);
		visited[start.r][start.c]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			map[cur.r][cur.c]=IslandNum;
			
			for(int d=0;d<4;d++) {
				int nextR = cur.r+drc[d][0];
				int nextC = cur.c+drc[d][1];
				
				if(nextR<0||nextR>=N||nextC<0||nextC>=N) continue;
				if(visited[nextR][nextC]) continue;
				//현재 노드가 가장자리라는 뜻
				if(map[nextR][nextC]==0) {
					//섬 번호에 가장 자리 추가
					if(!inedge[cur.r][cur.c]) {
						edge[IslandNum].add(cur);
						inedge[cur.r][cur.c]=true;
					}
					continue;
				}
				q.add(new Node(nextR,nextC,0));
				visited[nextR][nextC]=true;
			}
			
		}
	}
	
	public static void CheckLen(Node start, int IslandNum) {
		int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
		Queue<Node> q = new LinkedList<>();
		
		q.add(start);
		visited[start.r][start.c]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int nextR = cur.r+drc[d][0];
				int nextC = cur.c+drc[d][1];
				
				if(nextR<0||nextR>=N||nextC<0||nextC>=N) continue;
				else if(visited[nextR][nextC] || map[nextR][nextC]==IslandNum) continue;//이미 방문했거나 똑같은 섬이면 다음 탐색
				
				//바다 -> 다리를 만들기 위해 큐에 넣어주기
				else if(map[nextR][nextC]==0) {
					q.add(new Node(nextR,nextC, cur.len+1));
					visited[nextR][nextC]=true;
				}
				
				//다른 섬 도착 완료 -> 길이 갱신 -> 탐색 전체 종료
				else if(map[nextR][nextC]!=IslandNum) {
					minLen = Math.min(minLen, cur.len);
					return;
				}
			}
		}
	}

}