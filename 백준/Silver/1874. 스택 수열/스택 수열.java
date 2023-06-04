import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		int[] nums = new int[count];
		
		for(int i=0;i<count;i++) {
			nums[i]=sc.nextInt();
		}
		
		//입력 끝
		
		//1부터 스택 쌓기
		Stack<Integer> stack = new Stack<>();
		int numsIdx = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=count;i++) {
			//숫자 스택 쌓기 
			stack.add(i);
			sb.append("+").append("\n"); //push 
			
			//받은 숫자와 일치 
			while(!stack.isEmpty() && stack.peek()==nums[numsIdx]) {
				int num = stack.pop();
				sb.append("-").append("\n"); //pop 
				numsIdx++;
			}
		}

		//다 돌았을 때 stack에 숫자가 남아있으면 수열 완성 불가 
		if(!stack.isEmpty()) System.out.println("NO");
		else System.out.println(sb);

	}

}