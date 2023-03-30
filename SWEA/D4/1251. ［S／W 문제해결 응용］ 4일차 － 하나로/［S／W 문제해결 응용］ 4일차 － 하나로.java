import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    //프림 알고리즘
    
	static int[] x;// 섬들의 x좌표
	static int[] y;// 섬들의 y좌표
	static double E; // 환경 부담 세율 실수
	static int N; // 섬의 개수
	static List<Node>[] possibleList;// 각 정점에서 갈 수 있는 정점을 나타낸 리스트
	static double minResultFee=Double.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int startNode;
		int endNode;
		double distance;

		public Node(int startNode, int endNode, double distance) {
			this.startNode = startNode;
			this.endNode = endNode;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance > o.distance?1:-1;
		}

		@Override
		public String toString() {
			return "Node [startNode=" + startNode + ", endNode=" + endNode + ", distance=" + distance + "]";
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// test case

		for (int T = 1; T <= t; T++) {
			N = sc.nextInt();// 섬의 개수

			x = new int[N];
			y = new int[N];
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}

			// N(N-1)/2만큼의 모든 간선의 거리를 계산해준다.
			// 거리가 가까울수록 환경부담금이 싸다.
			possibleList = new ArrayList[N * (N - 1) / 2+1];
			for (int i = 0; i < N * (N - 1) / 2+1; i++) {
				possibleList[i] = new ArrayList<>();
			}

			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					//distance 구하기
					double distance = Math.sqrt(Math.pow(Math.abs(x[i]-x[j]), 2)+Math.pow(Math.abs(y[i]-y[j]), 2));
					//프림 알고리즘은 무향이다.
					possibleList[i].add(new Node(i,j,distance));
					possibleList[j].add(new Node(j,i,distance));
				}
			}
			


			E = sc.nextDouble();

			// 총 환경 부담금을 최소로 지불하는 방안을 찾아야 한다.
			// 프림 알고리즘 사용
			minResultFee=prim(0);
			
			//결과 출력
			System.out.println("#"+T+" "+Math.round(minResultFee));
			
			//초기화
			minResultFee=Double.MAX_VALUE;

		} // TEST CASE END

	}

	/**
	 * 프림 알고리즘 배열 : possibleNode(ArrayList), dist(arr), visited(arr), pq(priorityqueue)
	 * 1) 먼저 가장 처음으로 방문하고 싶은 정점을 고른다. -> 그 정점의 dist를 0으로 만든다. -> visited = true
	 * 2) 찍은 정점의 인접한 노드들을 pq에 넣는다.-> 거리가 가장 가까운 것 먼저 나오게 되어있다.
	 * 3) 정렬은 되어있으니까 방문했는지 안했는지 여부를 따져서 가장 앞에있는 노드를 선택하면 비용이 가장 적은 선택이다.
	 * 4) 선택을 한뒤에는 pick+1 -> 현재정점의 끝 정점을 방문 true -> pq에 끝 정점과 인접한 정점들을 모두 넣는다.
	 * 5) 이 과정을 N-1개를 뽑을 때까지 계속한다.
	 */
	static public double prim(int startNode) {
		int[] dist = new int[N];//정점의 갯수만큼 dist 설정
		boolean[] visited = new boolean[N];//방문여부
		Queue<Node> pq = new PriorityQueue<>();//시작 정점으로부터 인접한 정점들을 저장
		double fee = 0.0;
		dist[startNode]=0;
		visited[startNode]=true;
		pq.addAll(possibleList[startNode]);//거리 순으로 나열된 정점들이 있음
		
		//간선은 N-1개가 뽑혀야 끝
		int pick = 1;
		while(pick!=N) {
			Node currNode = pq.poll();
			if(visited[currNode.endNode]) continue;
			
			visited[currNode.endNode]=true;
			pick++;
			fee += E*Math.pow(currNode.distance, 2);
			
			//뽑힌 정점 주변의 인접 노드들을 큐에 저장한다.
			pq.addAll(possibleList[currNode.endNode]);
		}

		return fee;
	}

}