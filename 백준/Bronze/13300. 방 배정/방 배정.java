import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 수학여행 참가수 / 방 최대 인원
		int entry = sc.nextInt();
		int room_max=sc.nextInt();

		int[][] room = new int[2][7]; //gender / grade
		
		//2. 성별 / 학년
		for(int i=0;i<entry;i++) {
			int gender=sc.nextInt();
			int grade = sc.nextInt();
			room[gender][grade]++;
		}
		
		//3. 최소한의 방의 갯수
		int result=0;
		for(int i=0;i<room.length;i++) {
			for(int j=0;j<room[0].length;j++) {
				if(room[i][j]%room_max==0) result+=room[i][j]/room_max;
				else result+=room[i][j]/room_max+room[i][j]%room_max; //ex 5 -> 2+3 / 1 -> 0+1
			}
		}
		
		System.out.println(result);
		
	}

}
