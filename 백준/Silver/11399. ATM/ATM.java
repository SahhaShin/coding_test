import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//누적합의 합 
		Scanner sc = new Scanner(System.in);
		
		//사람의수
		int people = sc.nextInt();
		
		//필요한 시간 
		int[] time = new int[people];
		for(int i=0;i<people;i++) {
			time[i]=sc.nextInt();
		}
		
		//앞의 합을 줄일수록 최소값이 완성됨 
		//정렬하기 
		Arrays.sort(time);
		
		int total=0;
		int result=0;
		
		for(int i=0;i<time.length;i++) {
			total+=time[i];
			result+=total;
		}
		System.out.println(result);

	}

}
