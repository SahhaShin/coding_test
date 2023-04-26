import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Node>[] tree;
	static Queue<Node> q;
	static int remove, countLeaf;
	
	static class Node{
		int num;

		public Node(int num) {
			super();
			this.num = num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//트리의 노드 개수
		
		//초기화
		q = new LinkedList<>();
		tree = new ArrayList[N];
		for(int i=0;i<N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		
		//트리 구성
		int start = 0;
		for(int i=0;i<N;i++) {
			int parent = sc.nextInt();
			if(parent==-1) start = i;//가장 최상단 노드임
			else tree[parent].add(new Node(i));
		}
		
		//첫 시작 노드 큐에 넣어주기
		q.add(new Node(start));
		
		//지울 노드 받기
		remove = sc.nextInt();
		
		//만약 start를 지우면 바로 0개 끝
		if(start==remove)countLeaf=0;
		else {
			leafNode();
		}
		
		System.out.println(countLeaf);
		
	}
	
	public static void leafNode() {
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			int count=0;
			for(int i=0;i<tree[cur.num].size();i++) {
				Node next = tree[cur.num].get(i);
				if(next.num==remove) continue;
				count++;
				q.add(new Node(next.num));
			}
			
			//현재 노드에서 자식 노드들이 하나도 안지워졌거나 count ==0
			//아예 자식이 없었다면 끝노드로 생각하고 추가
			if(count==0 || tree[cur.num].size()==0) countLeaf++;
		}
	}
}