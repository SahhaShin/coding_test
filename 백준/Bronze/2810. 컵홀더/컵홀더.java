import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 좌석수 
		int seat_count = sc.nextInt();
		
		//2. 좌석수에 따른 타입 (SSS)
		String type = sc.next();
		char[] type_arr = new char[seat_count];
		for(int i=0;i<seat_count;i++) {
			type_arr[i]=type.charAt(i);
		}
		
		//3.컵홀더 계산
		int cup = 1; //최초 좌석은 무조건 끝에 컵홀더가 있기 때문 
		int couple=0; //(LL)이면 ++ -> 0초기화 
		for(int r=0;r<seat_count;r++) {
			if(type_arr[r]=='S') {
				cup++;
			}
			else if(type_arr[r]=='L') {
				couple++;
				if(couple==2) {
					cup++;
					couple=0;
				}
			}
		}//for end
		
		//사람보다 컵홀더가 많을 수도 있음 고려!
		if(cup>seat_count)System.out.println(seat_count);
		else System.out.println(cup);

	}

}
