import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int country = sc.nextInt();
		int[] distance = new int[country-1];
		int[] fee = new int[country];
		
		for(int i=0;i<country-1;i++) {
			distance[i]=sc.nextInt();
		}
		
		for(int i=0;i<country;i++) {
			fee[i]=sc.nextInt();
		}
		
		int result=0;
		for(int i=0;i<country-1;i++) {
			if(fee[i]<fee[i+1]) {
				result += (distance[i]+distance[i+1])*fee[i];//내가 다음 도시 비용보다 더 작다면 다음 도시 것도 같이
				i++;//다음도시는 이미 계산 했으니 그 다음 도시로 
			}
			else {
				result += (distance[i])*fee[i];//내가 다음 도시 비용보다 더 크다면 내꺼만
			}
		}
		
		System.out.println(result);

	}

}