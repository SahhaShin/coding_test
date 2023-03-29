import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] count;//무리의 갯수를 세줄것임
	static int[] parent;//각 노드들이 어떤 부모를 가지고 있는지 저장
	static int N,M;
	private static node[] nodes;
	
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
		int t = sc.nextInt();//test case
		
		for(int T=1;T<=t;T++) {
			N = sc.nextInt();//사람수
			M = sc.nextInt();//관계수
			
			parent = new int[N+1];//사람은 1부터 시작 
			count = new int[N+1];
			nodes = new node[M+1];
			
			//step1. 자기자신을 부모로 갖게 셋팅
			makeSet();

			//관계받기
			for(int i=1;i<=M;i++) {
				int startNode = sc.nextInt();
				int endNode = sc.nextInt();
				
				//간선 저장
				node newNode = new node(startNode,endNode);
				nodes[i]=newNode;
				
				union(startNode, endNode); //관계짓기
			}
			
			//System.out.println("before "+Arrays.toString(parent));
			
			//입력받기 끝
			
			//step2. 다시한번 간선 관계 부모 다른지 확인
			for(int i=1;i<=M;i++) {
				union(nodes[i].startNode, nodes[i].endNode); //관계짓기
			}
			
			//System.out.println("after "+Arrays.toString(parent));
			
			//step3. 카운팅 배열로 다른 무리 세주기
			for(int i=1;i<=N;i++) {
				count[parent[i]]++;
			}
			
			
			
			int result=0;
			for(int i=1;i<=N;i++) {
				if(count[i]>0) result++;
			}
			
			System.out.println("#"+T+" "+result);
		}//test case end

	}
	
	static public void makeSet() {
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
	}
	
	//내 부모를 찾아줘
	static public int findSet(int people) {
		if(parent[people]==people) return people;
		
		return parent[people]=findSet(parent[people]);
	}

	static public void union(int aPeople, int bPeople) {
		int a = findSet(aPeople);
		int b = findSet(bPeople);
		
		if(a<b)parent[b]=a;
		else parent[a]=b;
	}
}