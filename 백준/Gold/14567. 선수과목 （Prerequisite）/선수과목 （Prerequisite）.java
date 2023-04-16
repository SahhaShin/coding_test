import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] indegree;
	static List<Node>[] subList;
	static int N,M;
	static int[] result;
	
	static class Node {
		int num;
		int semester;
		public Node(int num, int semester) {
			super();
			this.num = num;
			this.semester = semester;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//과목의 수
		M = sc.nextInt();//선수 조건의 수 
		
		//초기화
		result = new int[N+1];
		indegree = new int[N+1];
		subList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			subList[i]= new ArrayList<>();
		}
		
		//선수 과목의 조건 A -> B
		for(int i=0;i<M;i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			
			indegree[next]++;
			subList[prev].add(new Node(next,1));
		}
		
		topological();
		
		for(int i=1;i<=N;i++) {
			System.out.printf(result[i]+" ");
		}
		System.out.println();

	}
	
	public static void topological() {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1]; 
		
		//진입 차수가 0인 노드부터 넣어준다.
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) {
				q.add(new Node(i,1));
				visited[i]=true;
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			result[cur.num]=cur.semester;
			
			for(int i=0;i<subList[cur.num].size();i++) {
				Node next = subList[cur.num].get(i);
				
				if(visited[next.num]) continue;
				
				indegree[next.num]--;
				
				if(indegree[next.num]==0) {
					q.add(new Node(next.num,cur.semester+1));
					visited[next.num]=true;
				}
			}
		}
			
	}

}