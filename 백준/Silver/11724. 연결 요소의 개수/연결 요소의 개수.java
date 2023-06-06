import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//정점 개수 
		int M = sc.nextInt();//간선 개수 
		
		//초기화
		adj = new ArrayList[N+1];//1정점부터 시작 
		for(int i=1;i<N+1;i++) {
			adj[i]=new ArrayList<>();
		}
		
		visited = new boolean[N+1];//1정점부터 시작 
		
		
		for(int i=0;i<M;i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			//방향 없는 그래프 
			adj[node1].add(node2);
			adj[node2].add(node1);
		}
		
		int connection = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				BFS(i);
				connection++;
			}
		}
		
		System.out.println(connection);
	}
	
	public static void BFS(int start) {
		//내가 이미 방문한 노드면 끝 
		if(visited[start]) return;
		
		//내가 방문하지 않은 노드면 인접 노드 탐색
		visited[start]=true;
		
		for(int i=0;i<adj[start].size();i++) {
			BFS(adj[start].get(i));
		}
	}
}