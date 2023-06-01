import java.util.Scanner;

public class Main {
	//합배열을 이용하자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//수의 개수
		int M = sc.nextInt();//합을 구해야하는 개수
		
		int[] nums = new int[N];
		long[] sumNums = new long[N];
		int sum=0;
		for(int i=0;i<N;i++) {
			nums[i] = sc.nextInt();//1 -> 2
			sum+=nums[i];//1 -> 3
			sumNums[i]=sum;//1 -> 3 -> 누적합 
		}
		
		StringBuilder sb = new StringBuilder();//결과 저장소 
		for(int i=0;i<M;i++) {
			int start = sc.nextInt();//1~
			int end = sc.nextInt();//3
			long result=0;
			
			//첫번째 인덱스부터 시작하지 않을때와 시작할 때 구분 
			if(start-1>0) {
				result = sumNums[end-1]-sumNums[start-2];
				sb.append(result).append("\n");
			}
			else {
				result = sumNums[end-1];
				sb.append(result).append("\n");
			}
			
		}
		
		System.out.println(sb);

	}

}