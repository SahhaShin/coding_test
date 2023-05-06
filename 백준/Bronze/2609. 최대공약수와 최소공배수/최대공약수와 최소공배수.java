import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int minNum = Math.min(num1, num2);
		int maxNum = Math.max(num1, num2);
		
		//최대 공약수 구하기
		int max = 1;
		for(int i=2;i<=minNum;i++) {
			if(num1%i==0 && num2%i==0) {
				max=i;
			}
		}
		
		//최소 공배수 구하기
		int min=1;
		int iIdx=1;
		int jIdx=1;
		//두 수의 최소공배수는 10000을 넘을 수 있습니다.
		start : for(int i=minNum;i<=100000000;i=minNum*iIdx) {
			for(int j=maxNum;j<=i;j=maxNum*jIdx) {
				if(i==j) {
					min=i;
					break start;
				}
				jIdx++;
			}
			iIdx++;
			jIdx=1;
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}

}