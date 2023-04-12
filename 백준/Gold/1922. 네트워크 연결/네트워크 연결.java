import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static List<Edge>[] adjList;
	static int N,M,result;
	static class Edge implements Comparable<Edge>{
		int num;
		int fee;
		public Edge(int num, int fee) {
			super();
			this.num = num;
			this.fee = fee;
		}
		@Override
		public int compareTo(Edge o) {
			return this.fee>o.fee?1:-1;
		}
		@Override
		public String toString() {
			return "Edge [num=" + num + ", fee=" + fee + "]";
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//컴퓨터수
		M = sc.nextInt();//간선 수
		
		//초기화
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int startNode = sc.nextInt();
			int endNode = sc.nextInt();
			int fee = sc.nextInt();
			
			//무향
			adjList[startNode].add(new Edge(endNode,fee));
			adjList[endNode].add(new Edge(startNode,fee));
		}
		prim(1);
		System.out.println(result);

	}
	
	public static void prim(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		//첫 노드 처리
		visited[start]=true;
		pq.addAll(adjList[start]);
		
		int pick = 1;
		
		while(pick!=N) {
			
			Edge cur = pq.poll();
			
			if(visited[cur.num]) continue;//이 노드가 이미 방문되었다면 선택 안함
			
			//방문 안된 노드라면 선택함
			pick++;
			result+=cur.fee;
			
			//해당 노드에 연결된 모든 노드들을 pq에 넣는다.
			visited[cur.num]=true;
			pq.addAll(adjList[cur.num]);
			
		}
	}

}