import java.util.Scanner;

public class Main {

	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();//2
		int r=sc.nextInt();//3
		int c=sc.nextInt();//1
		
		int arr_size=1;
		for(int i=0;i<N;i++) arr_size*=2;//4
		
		order_check(r, c, arr_size);//연산함수 
		
		System.out.println(count);

	}
	public static void order_check(int row, int col, int N) {
		if(N==1) return;
		
		//1사분면 : 다른 분면 안 다녀와서 count 측정 불가 -> 다음 함수로 넘김 
		//만약N=4 ,1사분면은 row는 N/2보다 작고, col은 N/2보다 작아야 한다.
		else if(row<N/2 && col<N/2) {
			order_check(row, col, N/2); //1사분면만 한칸씩 다시 조사 
		}
		
		//2사분면 : 1사분면을 다녀왔을 것이기 때문에 4공간은 분명히 다녀왔다.
		//만약N=4 ,2사분면은 row는 N/2보다 작고, col은 N/2보다 커야 한다.
		else if(row<N/2 && col>=N/2) {
			count+=(N*N)/4; //(4x4)/2 -> (2x2)/2 
			order_check(row, col-(N/2), N/2);//2사분면만 한칸씩 다시 조사, col은 2부터 시작하니까 2만큼 빼 
		}
		
		//3사분면 : 1,2사분면을 다녀왔을 것이기 때문에 8공간은 분명히 다녀왔다.
		//만약 N=4, 3사분면은 row는 N/2보다 크고, col은 N/2보다 작아야 한다.
		else if(row>=N/2 && col<N/2) {
			count+=((N*N)/4)*2;
			order_check(row-(N/2), col, N/2);//3사분면만 한칸씩 다시 조사, row은 3부터 시작하니까 2만큼 빼 
		}
		
		//4사분면 : 1,2,3 분면을 다녀왔을 것이기 때문에 12공간은 분명히 다녀왔다.
		//만약 N=4, 4사분면은 row는 N/2보다 크고, col은 N/2보다 커야 한다.
		else if(row>=N/2 && col>=N/2) {
			count+=((N*N)/4)*3;
			order_check(row-(N/2), col-(N/2), N/2);//3사분면만 한칸씩 다시 조사, row,col은 3부터 시작하니까 2만큼 빼 
		}
	}

}
