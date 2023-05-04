import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[] dist;
	static List<Node>[]adjList;
	static int N,M;
	
	static class Node implements Comparable<Node>{
		int num;
		int cow;
		public Node(int num, int cow) {
			super();
			this.num = num;
			this.cow = cow;
		}
		@Override
		public int compareTo(Node o) {
			return this.cow>o.cow?1:-1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//헛간수
		M = sc.nextInt();//소들의 길, 양방향 길
		
		//초기화
		dist = new int[N+1];//N번 헛간까지 가는 최소의 여물
		for(int i=0;i<N+1;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int path1 = sc.nextInt();
			int path2 = sc.nextInt();
			int cow = sc.nextInt();
			adjList[path1].add(new Node(path2, cow));
			adjList[path2].add(new Node(path1, cow));
		}
		
		//입력끝
		
		dijkstra();


		System.out.println(dist[N]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(new Node(1,0));
		dist[1]=0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			visited[cur.num]=true;//큐에서 나오는 순간 이 길을 선택한 것임
			
			for(int i=0;i<adjList[cur.num].size();i++) {
				Node next = adjList[cur.num].get(i);
				
				if(visited[next.num]) continue;//이미 선택된 길을 또 선택하지 않는다.
				
				
				if(dist[next.num]>dist[cur.num]+next.cow) {
					dist[next.num]=dist[cur.num]+next.cow;
					q.add(new Node(next.num,dist[next.num]));
				}
			}
		}
		
	}

}