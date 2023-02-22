import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 1. test case
		int t = sc.nextInt();
		for(int T=1;T<t+1;T++) {
			//2. card number
			int card_num = sc.nextInt();
			
			//3. card information 
			sc.nextLine(); //개행문자 방지
			String card=sc.nextLine();
			String[] card_arr = card.split(" ");
			
			//4. find middle
			int mid_idx = card_num/2;
			String mid_info = card_arr[mid_idx];//홀수일 경우 마지막에 마지막 카드가 들어감
			
			String result="";
			for(int i=0;i<mid_idx;i++) {
				//왼쪽 하나 / 오른쪽 하나 결과에 추가하기
				if(card_num%2==1 && (mid_idx+i+1)>=0 && (mid_idx+i+1)<card_num) result+=card_arr[i]+" "+card_arr[mid_idx+i+1]+" "; //홀수
				else if(card_num%2==0 && (mid_idx+i)>=0 && (mid_idx+i)<card_num) result+=card_arr[i]+" "+card_arr[mid_idx+i]+" "; //짝수
			}
			
			//홀수일 경우 중간 카드 마지막에 더해주기
			if(card_num%2==1) {
				result+=mid_info;
			}
			
			System.out.println("#"+T+" "+result);
		}//test case end
	}
}