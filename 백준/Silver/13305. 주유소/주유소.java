import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int country = sc.nextInt();
		long[] distance = new long[country-1];
		long[] fee = new long[country];
		
		for(int i=0;i<country-1;i++) {
			distance[i]=sc.nextInt();
		}
		
		for(int i=0;i<country;i++) {
			fee[i]=sc.nextInt();
		}
		
		long result=0;
		long minFee=Long.MAX_VALUE;
		
		for(int i=0;i<country-1;i++) {
			if(fee[i]<minFee) {
				minFee=fee[i];
				result += distance[i]*fee[i];
			}
			else {
				result += distance[i]*minFee;
			}
		}
		
		System.out.println(result);

	}

}