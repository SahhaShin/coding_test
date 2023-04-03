import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<ComputerEdge>[] comList;
	static int N,M;
	static int result;//감염 컴퓨터 수
	
	static class ComputerEdge{
		int startNode;
		int endNode;
		public ComputerEdge(int startNode, int endNode) {
			super();
			this.startNode = startNode;
			this.endNode = endNode;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//컴퓨터 수
		M = sc.nextInt();//컴퓨터 쌍의 수
		
		//컴퓨터 엣지 리스트 초기화
		comList = new ArrayList[N+1];//1부터 시작하는 컴퓨터
		for(int i=0;i<N+1;i++) {
			comList[i] = new ArrayList<>();
		}
		
		//컴퓨터 엣지 정보 받기
		//1->2일 떈 괜찮은데, 2->1일 떄 안해주면 1이 감염되어도 1에 딸린 리스트가 없어 못 찾아 간다.
		//bfs에서 visited로 같은 노드 방문 막아줘서 양방향해도 괜찮음
		for(int i=0;i<M;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			comList[start].add(new ComputerEdge(start,end));
			comList[end].add(new ComputerEdge(end,start));
		}
		
		//감염 컴퓨터 수 파악
		BFS();
		
		//결과 출력
		//1번 컴퓨터 카운트 제외
		System.out.println(result-1);
		
	}
	
	static public void BFS() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];//컴퓨터 1부터 시작
		
		
		q.add(1);//1번 컴퓨터 감염 시작
		visited[1]=true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			result++;
			for(int i=0;i<comList[curr].size();i++) {
				int next = comList[curr].get(i).endNode;
				if(!visited[next]) {
					q.add(next);
					visited[next]=true;
				}
			}
		}
	}

}
