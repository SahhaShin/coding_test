import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Edge>[] EdgeList;
	static int E,V;
	static int result;
	
	static class Edge implements Comparable<Edge>{
		int startNode;
		int endNode;
		int weight;
		public Edge(int startNode, int endNode, int weight) {
			super();
			this.startNode = startNode;
			this.endNode = endNode;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight>o.weight?1:-1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();//정점의 개수
		E = sc.nextInt();//간선의 개수
		
		EdgeList = new ArrayList[V+1];//1번부터 시작
		for(int i=0;i<V+1;i++) {
			EdgeList[i] = new ArrayList<>();
		}
		
		//간선 정보 받기
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();
			
			//무향그래프
			EdgeList[A].add(new Edge(A,B,w));
			EdgeList[B].add(new Edge(B,A,w));
		}

		//정보 입력 모두 받음
		
		//구현
		prim(1);
		
		//결과 출력
		System.out.println(result);
	}
	

	static public void prim(int startNode) {
		Queue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];//1번부터 시작
		
		int pick=0;
		visited[startNode]=true;
		pq.addAll(EdgeList[startNode]);
		
		while(pick!=V-1) {
			Edge curr = pq.poll();
			if(!visited[curr.endNode]) {
				result+=curr.weight;//간선 선택완료
				pick++;
				visited[curr.endNode]=true;
				pq.addAll(EdgeList[curr.endNode]);
			}
		}
	}

}