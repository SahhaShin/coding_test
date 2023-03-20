import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int group=sc.nextInt();//마지막 몇개가 1로 켜져있는지
			int num = sc.nextInt();//10진수
			
			//2진수 구하기
			StringBuilder bi = new StringBuilder();
			while(num>0) {
				bi.append(num%2);
				num/=2;
			}
			
			//거꾸로
			bi.reverse();
			
			//판별해야하는 1의 갯수보다 2진수 길이가 적으면 OFF
			String result = "ON";
			if(bi.length()<group) result = "OFF";
			else {
				//그게 아니면 길이만큼 조사해서 1인지 판단
				for(int i=bi.length()-1;i>(bi.length()-1)-group;i--) {
					if(bi.charAt(i)!='1') {
						result = "OFF";
						break;
					}
				}
			}
			System.out.println("#"+T+" "+result);
		}//test case end
	}
}