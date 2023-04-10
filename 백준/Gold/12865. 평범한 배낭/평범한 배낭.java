import java.util.Scanner;

public class Main {
	static int[] weight;
	static int[] value;
	static int[][] total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//물품 수
		int K = sc.nextInt();//버틸 수 있는 무게
		
		//초기화
		weight = new int[N+1];
		value = new int[N+1];
		total = new int[N+1][K+1]; //행 : 고려 물품 / 열 : 고려 무게
		
		//물건의 무게 + 가치
		for(int i=1;i<=N;i++) {
			weight[i]=sc.nextInt();
			value[i]=sc.nextInt();
		}
		
		//i=0(아무것도 선택하지 않음)의 경우 total[0] 라인이 0으로 이미 초기화 되어 있음
		for(int i=1;i<=N;i++) {
			for(int w=1;w<=K;w++) {//배낭의 크기 만큼 돌려야 함
				//내가 선택한 물건의 무게가 내가 고려하고 있는 가방의 무게보다 작다.
				if(weight[i]<=w) {
					total[i][w]=Math.max(total[i-1][w], total[i-1][w-weight[i]]+value[i]);
				}
				//무게가 넣을 수 있는 무게보다 무겁다면 이전 값을 그대로 사용 -> 넣을 수 없음
				else total[i][w] = total[i-1][w];
				
			}
		}
		System.out.println(total[N][K]);

	}
}