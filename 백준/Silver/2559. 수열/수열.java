import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //전체 수 
		int K = sc.nextInt(); //연속 수 
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		//입력 종료 
		
		
		//1. k개를 넣는다. -> 넣으면서 덧셈한다.
		//2. k가 되면 최대를 비교한다. -> 비교해서 크면 바꾼다.
		//3. 비교가 끝나면 맨 앞에 하나빼고, 맨 뒤에 하나를 넣는다.
		int max=-90000000;
		int sum=0;
		int count=0;
		int startPointer=0;
		for(int i=0;i<N;i++) {
			sum+=arr[i];
			count++;
			
			if(count==K) {
				
				max=Math.max(sum, max);
				
				count--;
				
				sum-=arr[startPointer];
				startPointer++;
			}
			
			
		}
		
		System.out.println(max);

	}

}