import java.util.Scanner;

public class Main {
	//메모리 초과 32MB -> 투포인터 쓰기 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();//15
		
		int result = 0;
		
		for(int i=1;i<=num;i++) {
			int sum=i;
			//같은 경우 
			if(sum==num) {
				result++;
				break;
			}
			
			//같지 않은 경우 
			for(int j=i+1;j<=num;j++) {
				sum+=j;
				if(sum==num) {
					result++;
					break;
				}
				else if(sum>num) break;
			}
		}
		System.out.println(result);
		
	}//main
}