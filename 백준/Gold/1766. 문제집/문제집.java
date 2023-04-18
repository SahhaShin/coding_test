import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static List<Node>[] adjList;
	static int[] indegree;
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int num;
		int level;

		public Node(int num, int level) {
			super();
			this.num = num;
			this.level = level;
		}

		@Override
		public int compareTo(Node o) {
			return this.level>o.level?1:-1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//문제수
		int M = sc.nextInt();//정보개수
		
		//초기화
		visited = new boolean[N+1];
		indegree = new int[N+1];
		pq = new PriorityQueue<>();
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adjList[start].add(new Node(end,end));
			indegree[end]++;//진입차수 증가
		}
		
		//진입차수가 0인 곳 먼저 pq에 넣기
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				pq.add(new Node(i,i));
				visited[i]=true;
			}
		}
		
		topol();//순서 정하기 시작 및 결과출력
		System.out.println();

	}
	
	public static void topol() {
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			System.out.printf(cur.num+" ");
			
			for(int i=0;i<adjList[cur.num].size();i++) {
				Node next = adjList[cur.num].get(i);
				if(visited[next.num]) continue;
				
				indegree[next.num]--;
				
				if(indegree[next.num]==0) {
					pq.add(new Node(next.num,next.level));
					visited[next.num]=true;
				}
			}
		}
	}
}