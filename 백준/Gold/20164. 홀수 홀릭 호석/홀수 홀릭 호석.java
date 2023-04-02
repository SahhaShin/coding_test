import java.util.Scanner;

public class Main {
	// 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각
	// 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
	// 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
	static int result_min = Integer.MAX_VALUE;
	static int result_max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		odd_split(num,0);
		
		System.out.println(result_min+" "+result_max);

	}

	static public void odd_split(String num, int odd) {
	
		int result=0;
		//넘어온 수의 홀수의 수부터 세기 
		for(int i=0;i<num.length();i++) {
			if((num.charAt(i)-'0')%2==1)++result;
		}
		
		char[] arr = num.toCharArray();
		//1자리수면 끝 
		if(arr.length==1) {
			//최소값과 최대값 구하기 
			if(result_min>odd+result)result_min=odd+result;
			if(result_max<odd+result) result_max=odd+result;
			return;
		}
		
		//2자리 수면 2등분 하고 합을 구한다.
		else if(arr.length==2) {	
			odd_split(Integer.toString((arr[0]-'0')+(arr[1]-'0')),odd+result);
		}
		
		// 길이가 3이상일 때 3등분 하는 범위를 정해 함수로 날려줄 것이다.
		else if(arr.length>=3) {
			for (int i = 1; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					int one_n=0;
					int two_n=0;
					int three_n=0;
					//result=0;
					for (int one = 0; one < i; one++) one_n = one_n*10+(arr[one]-'0');
					for (int two = i; two < j; two++) two_n = two_n*10+(arr[two]-'0');
					for (int three = j; three < arr.length; three++) three_n = three_n*10+(arr[three]-'0');
					odd_split(Integer.toString(one_n+two_n+three_n),odd+result);
				}
			}
		}//3 end
	}

}