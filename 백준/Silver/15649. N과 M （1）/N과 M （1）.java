import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();//숫자 
		M=sc.nextInt();//깊이  
		visited=new boolean[N+1];//방문했는지 여부 
		arr=new int[M+1];//방문한 노드 
		dfs(1);
	}
	
	//깊이 우선 탐색 첫 시작!
	static public void dfs(int depth) {
		//만약 재귀 깊이가 M(깊이)를 지난다면 결과 출력 후 그만!
		if(depth==M+1) {
			for(int i=1;i<=M;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			//만약 방문하지 않았다면
			if(!visited[i]) {
				arr[depth]=i;//1뎁스에 대해 arr 추가
				visited[i]=true;//방문 기록 남기기 
				dfs(depth+1);//다음뎁스 구하러 가기 
				visited[i]=false;//다음 노드에서 쭉쭉 arr추가해서 다시 돌아오면 다음 기회를 위해 false 처리 
				//만약 1234에서 4에서 다시 돌아올 때 4 false 3 false해줌으로써 1243을 갈 수 있는 것이다.
			}
			
		}
	}

}