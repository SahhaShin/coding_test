import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Node>[] adjList;
	static int V,E;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int num;
		int w;
		public Node(int num, int w) {
			super();
			this.num = num;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w>o.w?1:-1;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();//정점의 개수
		E = sc.nextInt();//간선의 개수
		
		int startNode = sc.nextInt();//시작 정점 
		
		//초기화
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		adjList = new ArrayList[V+1];
		for(int i=0;i<V+1;i++) {
			adjList[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			
			//유향
			adjList[start].add(new Node(end,weight));
		}
		
		//데이터 입력 끝
		
		dijkstra(startNode);
		
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else System.out.println(dist[i]);
		}
		

	}
	
	public static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.num]) continue;
			
			visited[cur.num]=true;
			
			for(int i=0;i<adjList[cur.num].size();i++) {
				Node next = adjList[cur.num].get(i);
				
				if(dist[next.num]>dist[cur.num]+next.w) {
					dist[next.num]=dist[cur.num]+next.w;
					pq.add(new Node(next.num,dist[next.num]));
				}
				
			}
		}
		
	}

}