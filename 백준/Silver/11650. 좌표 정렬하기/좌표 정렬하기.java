import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node>{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if(this.x>o.x || this.x<o.x) return this.x>o.x?1:-1;
			else return this.y>o.y?1:-1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			pq.add(new Node(sc.nextInt(),sc.nextInt()));
		}
		
		for(int i=0;i<N;i++) {
			Node cur = pq.poll();
			System.out.println(cur.x+" "+cur.y);
		}

	}

}