import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int k;
	static int[] nums;
	
	static boolean[] sel; //이미 선택된 숫자를 체크 
	static int[] sel_nums;
	
	static Map<Integer, Integer> nums_map = new HashMap<>();
	static int count; //몇 가지 숫자가 나오냐?

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		nums = new int[n];
		sel = new boolean[n];
		sel_nums = new int[k];
		
		
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		
		permutation(0);
		
		System.out.println(count);

	}
	
	//순서가 중요 => 순열
	public static void permutation(int depth) {
		
		int result = 0;
		if(depth==k) {
			for(int i=0;i<k;i++) {
				//10의 자리면 10을 더 곱해주는 과정이 필요 
				if(sel_nums[i]>=10) result = result*100 + sel_nums[i];
				else result = result*10 + sel_nums[i];
			}
			
			if(!nums_map.containsKey(result)) {
				count++;
				nums_map.put(result, result);
			}
			
			return;
		}
		
		else if(depth==n) {
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			//나랑 같은 수는 또 뽑을 수 없음
			if(sel[i]) continue;
			
			sel_nums[depth] = nums[i];
			sel[i]=true;
			
			permutation(depth+1);
			
			sel[i]=false;
			
		}
	}

}