import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N,M,K;
	static int[] p; //부모
	static int[] rank; //부모의 랭크
	static PriorityQueue<Edge> pq = new PriorityQueue<>(); //전체 간선
	static PriorityQueue<Edge> garbage; //선택받지 못한 간선들
	static PriorityQueue<Edge> mst;
	static int[] count;
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int score;
		public Edge(int start, int end, int score) {
			super();
			this.start = start;
			this.end = end;
			this.score = score;
		}
		@Override
		public int compareTo(Edge o) {
			return this.score>o.score?1:-1;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", score=" + score + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//정점의 개수
		M = sc.nextInt();//간선의 개수
		K = sc.nextInt();//턴의 수
		
		//초기값
		p = new int[N+1];
		rank = new int[N+1];

		//간선 입력받기
		for(int i=1;i<=M;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			pq.add(new Edge(start, end, i));
		}
		
		//입력 받기 끝
		
		int[] result = new int[K+1];
		for(int turn=1;turn<=K;turn++) {
			pset();//부모 자기자신으로 초기화
			mst=new PriorityQueue<>();
			garbage = new PriorityQueue<>();
			count = new int[N+1];
			
			result[turn] = kruskal();
			
			if(result[turn] == 0) {
				break;
			}
			
			mst.poll(); //mst 중 가장 작은 값 빼기
			
			//mst 하나 뺀거 제외하고 다시 복구
			while(!mst.isEmpty()) pq.add(mst.poll());
			while(!garbage.isEmpty()) pq.add(garbage.poll());
		}
		
		//결과 출력
		for(int turn=1;turn<=K;turn++) {
			System.out.printf(result[turn]+" ");
		}
		
	}
	
	public static int kruskal() {
		int pick=0; //N-1이 될 때까지 진행
		int score=0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			//부모가 같으면 이미 연결된 것이므로 생략
			if(find(cur.start)==find(cur.end)) {
				garbage.add(cur);
				continue;
			}else {
				union(cur.start, cur.end);
				mst.add(cur);
				
				count[cur.start]++;//모든 수가 나왔는지 체크
				count[cur.end]++;
				
				score+= cur.score;
				pick++;
				if(pick==N-1) break;
			}
		}
		
		if(pick<N-1) score=0;
		
		//모든 수가 나왔는지 체크 -> 모든 부모가 같은 부모인지 확인
		for(int i=1;i<N;i++) {
			if(find(i)!=find(i+1)) {
				score=0;
				break;
			}
		}
		
		return score;
	}
	
	
	//부모를 나 자신으로 셋팅
	public static void pset() {
		for(int i=1;i<=N;i++) {
			p[i]=i;
			rank[i]=0;
		}
	}
	
	//찐 부모 찾기
	public static int find(int x) {
		if(p[x]==x) return x;
		else return p[x]=find(p[x]);
	}
	
	//union
	public static void union(int x1, int x2) {
		int x1P = find(x1);
		int x2P = find(x2);
		
		//두 부모가 이미 같다면 x
		if(x1P==x2P){
			return;
		}
		else {
			//랭크가 높은 게 있다. -> 찐 부모를 바꿔야함
			if(rank[x1P]>rank[x2P]) {
				p[x2P]=p[x1P];
				rank[x1P]++;
			}else if(rank[x1P]<rank[x2P]){
				p[x1P]=p[x2P];
				rank[x2P]++;
			}else {// 두 부모의 랭크가 같다.
				if(x1<x2) {
					p[x2P]=p[x1P];
					rank[x1P]++;
				}else {
					p[x1P]=p[x2P];
					rank[x2P]++;
				}
			}
		}
	}

}