import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. test case 
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			char[] arr = sc.next().toCharArray();
			
			//점수 집계
			int count=0;
			int score=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='O') {
					count++;
					score+=count;
				}
				else {
					count=0;
				}
			}
			
			System.out.println(score);
		}//test case end
	}
}
