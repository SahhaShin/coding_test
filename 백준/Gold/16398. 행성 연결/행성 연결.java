import java.util.*;

public class Main {
	
	public static class Edge implements Comparable<Edge>{
		int num;
		long cost;
		public Edge(int num, long cost) {
			this.num=num;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost>o.cost?1:-1;
		}
	}
	
	static List<Edge>[] adjList;
	static int N;
	static long result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				long cost = sc.nextInt();
				
				if(i==j) continue;
				
				adjList[i+1].add(new Edge(j+1, cost));
				adjList[j+1].add(new Edge(i+1, cost));
			}
		}
		
		//입력 끝
		
		prim();
		
		System.out.println(result);
		

	}
	
	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int pick = 1;
		visited[1]=true;
		pq.addAll(adjList[1]);
		
		while(pick!=N) {
			Edge cur = pq.poll();
			
			if(!visited[cur.num]) {
				visited[cur.num]=true;
				pick++;
				result+=cur.cost;
				
				pq.addAll(adjList[cur.num]);	
			}
		}
	}

}