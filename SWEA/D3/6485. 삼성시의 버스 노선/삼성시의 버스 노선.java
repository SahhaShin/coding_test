import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. total tc
		int tc1 = sc.nextInt();
		
		for(int T=1;T<tc1+1;T++) {
			//2. sub tc
			int tc2 = sc.nextInt();
			
			//2-1. 부분 테케 만큼 버스가 어느 정류장을 가는지 받아주기
			//Ai~Bi
			//int[] start = new int[tc2+1]; //0번 인덱스 안쓸 것임
			//int[] end = new int[tc2+1]; //0번 인덱스 안쓸 것임
			int[] count = new int[5001];
			for(int t=1;t<tc2+1;t++) {
				//1번 버스가 어느 정류장을 갈 수 있는지 ...
				int start = sc.nextInt(); //1
				int end = sc.nextInt(); //3
				for(int c=start;c<=end;c++) {
					count[c]++;
				}
			}
			
			//3. 정류장 수
			int station_count = sc.nextInt();//5
			
			//4. 정류장 번호를 받음
			System.out.print("#"+T+" ");
			for(int i=1;i<=station_count;i++) {
				System.out.print(count[sc.nextInt()]+" ");
			}
			System.out.println();
		}//total tc end

	}

}