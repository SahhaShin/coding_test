import java.util.Scanner;

public class Solution {
	static node[] nodes;
	static int[] parent;//n개 정점의 부모들이 저장되어 있다.
	static int n,m;
	
	static class node{
		int startNode;
		int endNode;
		node(int startNode, int endNode){
			this.startNode=startNode;
			this.endNode=endNode;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			System.out.printf("#"+T+" ");
			
			n=sc.nextInt();//정점의 갯수
			m=sc.nextInt();//간선의 갯수
			
			parent = new int[n+1];//1부터 시작
			nodes = new node[m+1];
			
			makeSet();//나 자신을 부모로 두기 초기화
			
			//간선 정보 받기
			for(int i=1;i<=m;i++) {
				int in = sc.nextInt();//연결할지 확인할지 여부
				int startNode = sc.nextInt();
				int endNode = sc.nextInt();
				
				node newNode = new node(startNode,endNode);
				nodes[i] = newNode;
				
				//집합을 합쳐라
				if(in == 0) {
					union(startNode,endNode);
				}
				//같은 집합에 포함되는지 확인해라
				else if(in==1) {
					if(findSet(startNode)==findSet(endNode)) {
						System.out.printf("1");
					}
					else {
						System.out.printf("0");
					}
				}
			}
			System.out.println();
		}//test case end
	}
	
	static public void makeSet() {
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
	}
	
	static public int findSet(int num) {
		if(parent[num]==num)return num;
		return parent[num]=findSet(parent[num]);
	}

	static public void union(int a, int b) {
		int one = findSet(parent[a]);
		int two = findSet(parent[b]);
		
		if(one<two)parent[two]=one;
		else parent[one]=two;
	}

}