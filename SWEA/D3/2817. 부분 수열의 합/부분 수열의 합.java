import java.util.Scanner;

public class Solution {
	static int[] nums;
	static int k;
	static int n;
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//test case
		
		for(int T=1;T<t+1;T++) {
			n = sc.nextInt();//n개의 자연수
			k = sc.nextInt();//합이 k
			
			nums=new int[n];//n개의 자연수 바구니
			
			//n개의 자연수 입력
			for(int i=0;i<n;i++) {
				nums[i]=sc.nextInt();
			}
			
			//연산 함수 접근
			k_count(0,0);
			
			System.out.println("#"+T+" "+count);
			
			count=0;//다음 테스트 케이스를 위해 초기화 
		}//test case
	}
	
	//합이 k가 되는 수열의 갯수를 구하는 함수
	static public void k_count(int idx,int sum) {
		
		//만약 합이 k가 되면 count +1 -> 종료
		if(sum==k) {
			count++;
			return;
		}
		
		//만약 합이 k를 넘으면 그냥 종료
		if(sum>k) return;
			
		//모든 경우의 수를 따졌다면 (idx==n-1) 종료
		//합이 k가 되지 않았다는 거니까 count++은 해주지 않음
		if(idx==n) return;
			
		//만약 합이 k를 넘지 않으면 다음 조합 찾으러 가기
		k_count(idx+1,sum+nums[idx]); //이 수를 선택함
		k_count(idx+1,sum); //이 수를 선택 안함
	}

}