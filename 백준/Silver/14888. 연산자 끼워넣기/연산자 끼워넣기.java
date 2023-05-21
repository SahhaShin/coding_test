import java.util.Scanner;

public class Main {

	static int numCount;
	static char[] op;
	static char[] sel_op;
	static int[] op_count;
	static int[] numbers;
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		numCount = sc.nextInt();//수의 개수
		
		//초기화
		op = new char[numCount-1];
		sel_op = new char[numCount-1];
		numbers = new int[numCount];
		op_count = new int[4];
		visit = new boolean[numCount-1];
		
		//숫자입력받기 
		for(int i=0;i<numCount;i++) {
			numbers[i]=sc.nextInt();
		}
		
		//연산자 수 입력받기 
		int k = 0;
		for(int i=0;i<4;i++) {
			int count = sc.nextInt();
			for(int j=0;j<count;j++) {
				if(i==0) {
					op[k]='+'; 
					
				}else if(i==1) {
					op[k]='-'; 
					
				}
				else if(i==2) {
					op[k]='*'; 
					
				}else if(i==3) {
					op[k]='/'; 
					
				}
				
				k++;
			}
		}
		
		
		permutation(0, 1, numbers[0]);
		
		System.out.println(max);
		System.out.println(min);

	}
	
	public static void permutation(int depth, int next, long result) {
		if(depth==numCount-1) {

			//최소값 최대값 
			min=Math.min(min,result);
			max = Math.max(max, result);
			
			return;
			
		}
		
		for(int i=0;i<numCount-1;i++) {
			if(visit[i]) continue;
			visit[i]=true;
			permutation(depth+1,next+1,operation(result, op[i], numbers[next]));
			visit[i]=false;
		}
	}
	
	public static long operation(long result, char op, int num) {
		if(op=='+') {
			result+=num;
		}
		
		if(op=='-') {
			result-=num;
		}
		
		if(op=='*') {
			result*=num;
		}
		
		if(op=='/') {
			result/=num;
		}
		
		return result;
	}
	

}