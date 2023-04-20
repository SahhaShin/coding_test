import java.util.Scanner;

public class Main {

	static int[] p,rank;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//초기화
		p = new int[N+1];
		rank = new int[N+1];
		
		//구현 시작
		makeset();
		
		for(int i=0;i<M;i++) {
			int mode = sc.nextInt();//0이면 union 1이면 부모 같은지 체크 
			if(mode==0) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				union(node1,node2);
			}
			else if(mode==1) {
				int node1P = myP(sc.nextInt());
				int node2P = myP(sc.nextInt());
				if(node1P==node2P)System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	//자기 자신을 부모로 만든다. 
	public static void makeset() {
		for(int i=1;i<=N;i++) {
			p[i]=i;
			rank[i]=0;
		}
	}
	
	//부모 찾기 
	public static int myP(int node) {
		if(p[node]==node) return node;
		return p[node]=myP(p[node]);
	}
	
	//서로 부모 합치기
	public static void union(int node1, int node2) {
		int a = myP(node1);
		int b = myP(node2);
		
		if(a==b) return;
		else {
			if(rank[a]>rank[b]) {
				p[b]=a;
			}
			else {
				p[a]=b;
				if(rank[a]==rank[b]) rank[b]++;
			}
		}
	}
}