import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static List<Edge>[] edgeList;
	static int[] in;//진입차수 저장
	static int V,E;
	static int[] result;
	
	static class Edge{
		int startNode;
		int endNode;
		
		public Edge(int startNode, int endNode) {
			this.startNode=startNode;
			this.endNode=endNode;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T=1;T<=10;T++) {
			V = sc.nextInt();//정점의개수
			E = sc.nextInt();//간선의개수
			result = new int[V+1];
			
	        edgeList = new ArrayList[V+1];
	        for(int i=0;i<V+1;i++) {
	        	edgeList[i]=new ArrayList<>();
	        }
	        in = new int[V+1];
	        //간선 입력
	        for(int i=0;i<E;i++) {
	            int start = sc.nextInt();
	            int end = sc.nextInt();
	            edgeList[start].add(new Edge(start, end));
	            in[end]++;//end로진입하는 게 1개 있다.
	        }
	        
	        //위상정렬 수행
	        operate();
	        
	        //결과 출력
	        System.out.printf("#"+T+" ");
	        for(int i=1;i<=V;i++) {
	        	System.out.printf(result[i]+" ");
	        }
	        System.out.println();
	        
		}//TEST CASE END

	}
	
	public static void operate() {
		//1. 진입차수가 0인 모든 노드를 큐에 삽입한다.
		Queue<Integer> q = new LinkedList<>();
		int idx = 1;//result에 들어가는 원소 순서
		
		for(int i=1;i<=V;i++) {
			if(in[i]==0) q.offer(i);
		}
		
		//2. 큐의 공백상태가 될 때까지 반복 수행
		while(!q.isEmpty()) {
			//3. 큐에서 원소를 꺼낸다.
			//여기서 나오는 순서가 결과이다.
			int curr = q.poll();
			result[idx++]=curr;
			
			//4. 연결된 노드의 진입차수를 감소시킨다.
			for(int i=0;i<edgeList[curr].size();i++) {
				int next = edgeList[curr].get(i).endNode;
				in[next]--;
				if(in[next]==0) q.offer(next);
			}
		}

	}

}