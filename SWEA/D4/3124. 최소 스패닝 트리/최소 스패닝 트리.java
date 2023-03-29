import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	// 크루스칼 알고리즘
	// Union-Find 알고리즘
	
	static int[] p;// 부모를 저장할 배열
	static node[] nodes; // 노드들을 기록한 배열

	static class node {
		int startNode;
		int endNode;
		int score;

		node(int startNode, int endNode, int score) {
			this.startNode = startNode;
			this.endNode = endNode;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());//test case
		
		for(int T=1;T<t+1;T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			nodes = new node[E]; //nodes는 0부터 시작
			
			// 간선으로 연결된 정점들의 정보를 받는다.
			// 차례대로 시작노드, 끝노드, 가중치
			//nodes는 0부터 시작
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				node newNode = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				nodes[i] = newNode;
			}
			
			// 간선을 정렬합니다. -> 가중치 순으로 정렬합니다 -> 오름차순
			Arrays.sort(nodes, new Comparator<node>() {
				
				@Override
				public int compare(node o1, node o2) {
					return o1.score - o2.score;
				}
				
			});
			
			
			// 간선을 선택하자! -> 사이클이 발생 안하는 친구들로만 뽑자.
			// 사이클이 발생한다는 것은 찐 부모가 같을 때이다.
			
			// 일단 부모를 초기화 하자 -> 먼저 내가 부모가 되는 것이다.
			p = new int[V+1];//정점들이 1번부터 시작함
			
			for (int i = 1; i <= V; i++) {
				makeSet(i);
			}
			
			// 내가 가중치가 가장 적은 간선을 하나 뽑아서 그 간선의 시작노드와 끝노드의 부모가 같은지 확인해줄것이다.
			// 간선은 v-1개를 뽑아야 최소로 연결된다.
			int pick = 0; // v-1개 뽑자
			long fee = 0; // 최소 비용은 얼마일까 :  가중치 값이 1,000,000이 누적되면 int 범위 넘으므로, result를 long 타입
			StringBuilder sb = new StringBuilder();
			// E만큼의 정점을 하나씩 선택하는 과정을 거친다.
			//nodes는 0부터 시작
			for (int i = 0; i < E; i++) {
				// 시작점과 끝점의 부모를 찾는다.
				int node1 = findSet(nodes[i].startNode);
				int node2 = findSet(nodes[i].endNode);
				
				// 부모가 다르면 간선으로 채택 가능하며, 서로 연결해줄 수 있다.
				if (node1 != node2) {				
					union(node1, node2);
					pick++;
					fee += nodes[i].score;
				}
				
				if (pick == V - 1)
					break;
				
			}
			sb.append("#").append(T).append(" ").append(fee);
			System.out.println(sb);
		}//test case end


	}

	static public void makeSet(int num) {
		p[num] = num; // num의 부모는 num이다.
	}

	// 엄마를 찾아줘
	static public int findSet(int num) {
		// 부모를 찾았더니 나라면? 나를 반환
		if (p[num] == num)
			return num;
		// 근데 내가 부모가 아니다 -> 다른 부모가 있다는 것이다 -> 재귀타고 찐부모를 찾아줘
		return p[num]=findSet(p[num]);
	}

	// 노드를 연결한다는 것은 부모를 바꾼다는 뜻이다.
	// 지금은 p에 자기 자신을 부모로 뒀지만, 간선을 채택함으로써 작은쪽이 큰쪽으로 들어간다.
	static public void union(int node1, int node2) {
		// node2 찐부모의 값에 node1의 찐부모를 넣어주겠다.
		p[findSet(node2)] = findSet(node1);
	}

}