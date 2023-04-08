import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,V;
	static List<Node>[] nodeList;
	static boolean[] visited;
	static class Node implements Comparable<Node> {
		int num;

		public Node(int num) {
			super();
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return this.num>o.num?1:-1;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점의 개수
		M = sc.nextInt();//간선의 개수
		V = sc.nextInt();//탐색 시작 번호
		
		//초기화
		nodeList = new ArrayList[N+1];//정점은 1부터 시작
		for(int i=0;i<N+1;i++) {
			nodeList[i]=new ArrayList<>();
		}
		visited = new boolean[N+1];
		//간선 정보 입력받기 (양방향)
		for(int i=0;i<M;i++) {
			int startNode = sc.nextInt();
			int endNode = sc.nextInt();
			nodeList[startNode].add(new Node(endNode));
			nodeList[endNode].add(new Node(startNode));
		}
		//정렬
		for(int i=0;i<N+1;i++) {
			nodeList[i].sort(Comparator.naturalOrder());
		}
		//입력 끝
		visited[V]=true;
		DFS(V);
		System.out.println();
		BFS(V);
		
	}

	//시스템 스택을 쌓는다.
	public static void DFS(int start) {
		System.out.printf(start+" ");
		for(int i=0;i<nodeList[start].size();i++) {
			int next = nodeList[start].get(i).num;
			if(visited[next]) continue;
			visited[next]=true;
			DFS(next);
		}
		
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.printf(curr+" ");
			
			for(int i=0;i<nodeList[curr].size();i++) {
				int next = nodeList[curr].get(i).num;
				if(visited[next]) continue;
				visited[next]=true;
				q.add(next);
			}
		}
	}
}