import java.util.Scanner;

public class Solution {
	static int n;
	static int[][] food;
	static boolean[] visited;// 음식 수만큼 방문 체크

	// n/2 가질 수 있는 경우의 수 저장
	static int[] a_possible;
	static int[] b_possible;
	
	static int min=Integer.MAX_VALUE;//가장 작은 차이를 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();// test case

		for (int T = 1; T < t + 1; T++) {
			n = sc.nextInt(); // 음식 수, 배열 크기
			food = new int[n + 1][n + 1]; // index 1부터 시작
			visited = new boolean[n + 1];
			a_possible = new int[n + 1];
			b_possible = new int[n + 1];

			// 음식 시너지 넣어주기
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			
			//연산
			possible(1, 0);
			System.out.println("#"+T+" "+min);
			min=Integer.MAX_VALUE;//초기화

		} // test case end

	}

	// r:선택갯수 (0~n/2, 0,1 == 2)
	// depth : 음식 번호 (1~n)
	//중복되지 않는 조합이 결과로 도출됨
	static public void possible(int depth, int r) {
		
		//조합의 갯수 n/2를 넘기면 return
		if (r > (n / 2 - 1)) {
			
			//B 조합 결과도 구해주기 -> A가 방문하지 않은 것이 대상
			int idx=0; //b index
			
			for(int i=1;i<=n;i++) {
				if(visited[i]==false) {
					b_possible[idx++]=i;
				}
			}

			synergy(); //조합 결과(a/b_possible) 들고 시너지 및 둘의 차 구하기
			
			return;
		} 
		
		//음식 번호 n을 넘기면 return
		else if (depth == n + 1) {
			return;
		}

		if (!visited[depth])
			a_possible[r] = depth;

		visited[depth] = true;

		possible(depth + 1, r + 1);// 선택하는 경우

		visited[depth] = false;

		possible(depth + 1, r);// 선택하지 않는 경우 : 다음 숫자로 가되 현재 숫자(r)은 추가하지 않음

	}

	// 시너지 계산 함수 
	// possible 함수를 통해 a/b 조합을 구해준 후 이 함수로 옴
	static public void synergy() {
		int a_synergy=0;
		int b_synergy=0;
		
		for (int i = 0; i < n/2-1; i++) {
			for (int j = i+1; j < n/2; j++) {
				//ij ji 시너지 더해주기
				a_synergy+=food[a_possible[i]][a_possible[j]]+food[a_possible[j]][a_possible[i]];
				b_synergy+=food[b_possible[i]][b_possible[j]]+food[b_possible[j]][b_possible[i]];
			}
		}
		
		//시너지의 차 구해주고 min값인지 판별
		min=Math.min(min, Math.abs(a_synergy-b_synergy));
	}
}