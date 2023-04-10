import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Node>[] nodeList;
	static Node[] nodeInfo;
	static int[] inNode;
	static int N, result;
	static class Node implements Comparable<Node>{
		int num;
		int time;//걸리는 시간
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time>o.time?1:-1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//작업수
		
		//초기화
		inNode = new int[N+1];
		nodeInfo = new Node[N+1];
		nodeList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			int time = sc.nextInt();
			int count = sc.nextInt();
			nodeInfo[i]=new Node(i,time);
			
			for(int j=0;j<count;j++) {
				int prevWork = sc.nextInt();
				//선행관계 파악
				nodeList[prevWork].add(new Node(i,time));
				//유입수 파악
				inNode[i]++;
			}
		}
		
		Work();//일 시작
		
		System.out.println(result);

	}
	public static void Work() {
		boolean[] sel = new boolean[N+1];
		Queue<Node> q = new PriorityQueue<>();
		
		//유입수가 0인 곳을 모두 큐에 넣어준다.
		for(int i=1;i<N+1;i++) {
			if(inNode[i]==0) {
				q.add(new Node(i,nodeInfo[i].time));
				sel[i]=true;
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//현재 자신이 마지막 작업
			if(nodeList[cur.num].size()==0) {
				result = Math.max(result, cur.time);
			}
			
			for(int i=0;i<nodeList[cur.num].size();i++) {
				Node next = nodeList[cur.num].get(i);
				
				if(sel[next.num]) continue;
				
				inNode[next.num]--;
				if(inNode[next.num]==0) {
					//현재 걸린 시간에 다음 걸릴 시간을 더해 큐에 넣어주기
					q.add(new Node(next.num,cur.time+next.time));
					sel[next.num]=true;
				}
			}
		}
		
	}

}