import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static List<Node> house;
	static List<Node> store;
	static int[][] map;
	static int[] choice;
	static int result=Integer.MAX_VALUE;
	
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 마을 크기
		M = sc.nextInt();// 최대 선택할 치킨집 수
		
		//초기화
		house = new ArrayList<>();// 집 위치 저장
		store = new ArrayList<>();// 치킨집 위치 저장
		choice = new int[M];//내가 선택할 M개의 치킨집
		
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					house.add(new Node(i, j));
				if (map[i][j] == 2)
					store.add(new Node(i, j));
			}
		}

		// 입력 끝
		
		combination(0,1);
		
		System.out.println(result);

	}
	
	//depth (0~M-1) : 최대 M-1 깊이까지 가능 (M개의 치킨집을 뽑는거니까)
	//sel(1~store.size()) : store.size()만큼의 치킨집이 있는데 이 중 몇 번째 치킨 집을 뽑을 것이냐. store.size() 크기를 넘어가면 안됨
	public static void combination(int depth,int sel) {
		
		if(depth==M) {
			//M개의 치킨집 선택을 했다. -> 각 집이 어떤 치킨집을 선택할건지 거리 계산하여 가장 작은 거리 pick!
			//모든 집의 가장작은거리는 한 변수에 전체 더한다. 모든 조합 중 가장 작은 거리를 도출하면 된다.
			int sum=0;
			for(int i=0;i<house.size();i++) {//집의 수(0번부터 시작)
				int minDistance = Integer.MAX_VALUE;
				Node curH = house.get(i);//현재 집

				for(int j=0;j<M;j++) {//선택한 가게 수 (M고정)
					Node curS = store.get(choice[j]-1);//store는 0부터 시작하고, choice의 값은 1부터 시작해서 -1해줘야함
					
					int d = Math.abs(curH.r-curS.r)+ Math.abs(curH.c-curS.c);//거리 계산
					
					minDistance=Math.min(minDistance, d);//한 집에서 치킨집까지의 거리
					
				}
				sum+=minDistance;//각 집의 가장 가까운 치킨집 거리 더해주기
			}
			
			result = Math.min(result,sum);
			return;
		}
		
		if(sel==store.size()+1) {
			//치킨집 가게 수를 넘어섰다. 다 보았다.
			return;
		}
		
		choice[depth]=sel;
		combination(depth+1,sel+1);//치킨집 선택
		combination(depth,sel+1);//치킨집 선택안함
		
		
	}

}