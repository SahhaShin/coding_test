import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//18
		int N_copy=0;
		int count=0;
		int idx=0;
		
		//만약에 N이 5로 딱 나눠 떨어지면 결과 쉽게 나옴
		if(N%5==0) count=N/5;
		
		else if(N/5>0) {
			for(int i=N/5;i>=0;i--) {
				//copy본을 사용하는 이유는 N을 나눌 5*i의 적당한 수를 찾기 위함이다. 
				N_copy=N-(5*i); //3 2 1
				//5로 나눌 수 있는 가짓수를 시험하며 그때마다 3으로 나눠지면 ok
				//그러기 위해 높은 5 배수부터 시작하는 것임
				if(N_copy%3==0) {
					count=i+N_copy/3;//5로 나눈 횟수와 3으로 나눈 횟수
					break;//총 결과 끝나고 바로 끝내줘야함 안그럼 계속 돌아가서 정답 갱신
				}
				else {
					count=-1;
				}
			}
			
		}
		else if(N%3==0) count=N/3;
		
		else count=-1;
		
		System.out.println(count);

	}

}
