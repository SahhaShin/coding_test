import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static List<Node>[] adjList;
	static int N,M,result;
	
	static class Node implements Comparable<Node>{
		int num;
		int fee;
		public Node(int num, int fee) {
			super();
			this.num = num;
			this.fee = fee;
		}
		@Override
		public int compareTo(Node o) {
			return o.fee<this.fee?1:-1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//집의 개수 
		M = sc.nextInt();//길의 개수 
		
		//초기화
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int h1 = sc.nextInt();
			int h2 = sc.nextInt();
			int fee = sc.nextInt();
			
			//무향
			adjList[h1].add(new Node(h2,fee));
			adjList[h2].add(new Node(h1,fee));
		}
		
		//입력 끝 
		
		prim();
		
		System.out.println(result);

	}
	
	public static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] sel = new boolean[N+1];
		
		sel[1]=true;
		pq.addAll(adjList[1]);
		
		int pick=1;
		int max = 0;//두 마을로 끊을 간선 중 가장 비용이 높은 간선 비용 저장 
		
		while(pick!=N) {
			
			Node cur = pq.poll();
			if(cur.fee>max) {
				max=cur.fee;
			}
			
			if(sel[cur.num]) continue;
			
			sel[cur.num]=true;
			pick++;
			
			result += cur.fee;
			pq.addAll(adjList[cur.num]);
			
		}
		
		result -= max;
		
	}

}