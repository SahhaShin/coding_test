import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	static List<Node>[] tree;
	static int N;
	static int[] p;
	static boolean[] visited;

	static List<Integer> a_parent_list = new ArrayList<>();
	
	public static class Node{
		int parent;
		int child;
		public Node(int parent, int child) {
			super();
			this.parent = parent;
			this.child = child;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			N = sc.nextInt();//노드의 수 
			
			//초기화
			tree = new ArrayList[N+1]; //1~N
			for(int i=1;i<=N;i++) {
				tree[i] = new ArrayList<>();
			}
			
			//N-1개의 노드로 tree를 만든다.
			p = new int[N+1];
			for(int i=1;i<=N-1;i++) {
				int pa = sc.nextInt();
				int c = sc.nextInt();
				
				p[c]=pa;
//				tree[p].add(new Node(p,c));
			}
			
			//두 노드를 받아 공통 부모를 갖는 이를 찾는다.
			int a_node = sc.nextInt();
			int b_node = sc.nextInt();
			
			//1. 자식이 어떤 부모를 갖냐 정리할 필요가 있다.
//			p = new int[N+1];
//			pxc();
			
//			for(int i=0;i<N+1;i++) {
//				System.out.printf(p[i]+" ");
//			}

			//2. a_node의 전체 부모를 구해라 
			//a_parent_list에는 인덱스가 작을수록 a_node와 가까운 부모
			visited = new boolean[N+1];
			total_parent(a_node);
			
			
			//3. b_node의 부모를 추적하면서 같은 수가 있는지 확인 > 결과 출력 
			System.out.println(same_parent(b_node));

		}//test end
	}
	
	//자식이 어떤 부모를 갖냐
	public static void pxc() {
		
		for(int parent=1;parent<=N;parent++) {
			for(int idx=0;idx<tree[parent].size();idx++) {
				p[tree[parent].get(idx).child]=parent;
			}
		}
	}
	
	
	//전체 부모를 구해라
	public static void total_parent(int a_node) {

		int c = a_node;
		while(c!=0) {
//			a_parent_list.add(c);
			visited[c] = true;
			c=p[c];
		}
	}
	
	//같은 부모가 있는지 확인
	public static int same_parent(int b_node) {
		
		int c = b_node;
		int result = 0;
//		same : while(c!=0) {
//			for(int i=0;i<a_parent_list.size();i++) {
//				if(c==a_parent_list.get(i)) {
//					result = c;
//					break same;
//				}
//			}
//			c = p[c];
//		}
		
		while(c!=0) {
			if(visited[c]) {
				result = c;
				break;
			}
			c = p[c];
		}
		
		return result;
		
	}
}