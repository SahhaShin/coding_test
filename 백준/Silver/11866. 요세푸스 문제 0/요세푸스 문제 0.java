import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();//1~N명의 사람
		int K = sc.nextInt();//K번째 사람 제거
		
		boolean[] index = new boolean[N+1];
		
		System.out.printf("<");
		
		int jump=0;
		int targetNum=K;
		
		for(int i=0;i<N;i++) {
			if(i==N-1) {
				System.out.printf(targetNum+">");
			}
			else System.out.printf(targetNum+", ");
			index[targetNum]=true;
			
			while(jump!=K && i!=N-1) {
				targetNum=(targetNum+1)%N;
				if(targetNum==0)targetNum=N;
				if(index[targetNum]==false) jump++;
			}
			jump=0;
		}
	}

}