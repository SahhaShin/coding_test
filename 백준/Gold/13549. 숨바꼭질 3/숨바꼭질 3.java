import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static final int max = 100000;
	static int min_result = Integer.MAX_VALUE;
	static int N,K;
	
	static class Node implements Comparable<Node>{
		int num;
		int time;//0, 1
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", time=" + time + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.time>o.time?1:-1;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();//수빈 위치
		K = sc.nextInt();//동생 위치
		//입력 받기 끝
		
		
		visited = new boolean[max+1];
		
		bfs();
		
		System.out.println(min_result);
		
	}
	
	public static void bfs() {
		Queue<Node> p = new LinkedList<>();
		
		//첫 노드 넣기 수빈이가 있는 위치임
		p.add(new Node(N,0));
		visited[N] = true;
		
		while(!p.isEmpty()) {
			Node cur = p.poll();//현재 위치 및 시간
			visited[cur.num] = true;
			
			//어떤 경로로 가던 동생이 있는 위치로 오면 걸린 가장 적은 시간, min값을 체크해준다.
			if(cur.num==K) {
				min_result=Math.min(min_result, cur.time);
			}
			
			//하나 위치에 대해 순간이동, +1 , -1 했을 경우 만족하는지 확인한다.
			//갔던 위치는 다시 가지 않게 한다.
			//순간이동
			if(cur.num*2<=max && !visited[cur.num*2]) {
				p.add(new Node(cur.num*2,cur.time));//시간은 0이 지남 순간이동한 것임
			}
			
			//+1
			if((cur.num+1)<=max && !visited[cur.num+1]) {
				p.add(new Node(cur.num+1,cur.time+1));//1초걸림
			}
			
			//-1
			if((cur.num-1) >= 0 && !visited[cur.num-1]) {
				p.add(new Node(cur.num-1,cur.time+1));//1초걸림
			}
		}
	}
}