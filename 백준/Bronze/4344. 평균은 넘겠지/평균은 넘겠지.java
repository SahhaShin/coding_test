import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			int count = sc.nextInt();//학생수
			
			int[] height = new int[count];
			int sum = 0;
			for(int i=0;i<count;i++) {
				height[i]=sc.nextInt();
				sum+=height[i];
			}
			
			float avg = sum / count; //키 평균
			
			int over=0;
			for(int i=0; i<count; i++) {
				if(height[i]>avg) over++;
			}
			float result = (float)over/(float)count * 100;
			System.out.printf("%.3f%%%n",result);
		}

	}

}