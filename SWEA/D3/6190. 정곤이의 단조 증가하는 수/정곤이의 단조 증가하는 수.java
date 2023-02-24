import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//test case
		int t= sc.nextInt();//1
		for(int T=1;T<t+1;T++) {
			int N=sc.nextInt();//4
			
			//1 ≤ i < j ≤ N 즉, 0~N-1까지 -> 인덱스
			int[] nums = new int[N];
			for(int i=0;i<N;i++) {
				nums[i]=sc.nextInt(); //2 4 7 10
			}
			
			//두 수를 곱한 값이 단조 증가하는 수인가 검사
			int max=-1; //단조 증가 수가 없다.
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					int x=nums[i]*nums[j];
					//두 곱이 단조증가하는 수인가?
					if(incre(x)) {
						//구해놓은 단조 증가 수보다 큰가?
						if(max<x) max=x;
					}
				}
			}
			System.out.println("#"+T+" "+max);
		}//test case end
	}
    
    public static boolean incre(int num) {
		boolean result=true;
		int curr_num=Integer.MAX_VALUE;
		while(num>0) {
			int namege = num%10;//123 -> 3
			if(curr_num>=namege) curr_num=namege;//다음값보다 이전 값이 작으면 수정
			else {
				//3-> 2-> 1순이 아니라 1->2->3순으로 점점 커지면 FALSE (원값 321)
				result=false;
				break;
			}
			num/=10;
		}
		return result;
	}
}