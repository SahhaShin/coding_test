import java.util.Scanner;

public class Solution {
	static int[] cm;
	static int count;
	static int h;
	static int result=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			count=sc.nextInt();//직원수
			h = sc.nextInt();//선반 높이
			cm=new int[count];
			
			
			//직원들의 키 받기
			for(int i=0;i<count;i++) {
				cm[i]=sc.nextInt();
			}
		
			make_top(0,0);
			
			System.out.println("#"+T+" "+(result-h));
			
			//초기화
			result=Integer.MAX_VALUE;
		
		}//test case end
	}
	
	/**
	 * 사람이 중복되면 안된다.
	 * 1,2,3번 직원을 뽑아 만드는 탑과 3,2,1번 직원을 뽑아 만드는 탑은 같다.
	 * 순서는 중요하지 않다.
	 * 특정한 몇명의 직원을 뽑아야한다고 제시되지 않았다.
	 * == power set 부분 집합 
	 * */
	static public void make_top(int people, int make_h) {
		
		//만든 탑의 높이가 만들려고 하는 탑의 높이와 같거나 높을 때 결과 도출
		if(make_h>=h) {
			result=Math.min(result, make_h);
			return;
		}
	
		else if(people==count) return;
	
		make_top(people+1,make_h+cm[people]);//선택하는 경우 
		make_top(people+1,make_h);//선택 안하는 경우 
		
	}
}